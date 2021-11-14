import * as TE from "fp-ts/lib/TaskEither";
import * as T from "fp-ts/lib/Task";
import * as O from "fp-ts/lib/Option";
import * as E from "fp-ts/lib/Either";
import { v4 as uuid } from "uuid";
import { ApolloClient, gql, Observable, useApolloClient } from "@apollo/client";
import { pipe } from "fp-ts/lib/function";
import { useEffect, useState } from "react";

/**
 * Based on
 * https://github.com/eclipse-sirius/sirius-components/blob/master/frontend/src/explorer/getTreeEventSubscription.ts
 */
const rootObjectIdTreeEventQuery = gql`
  subscription rootObjectIdTreeEvent($input: TreeEventInput!) {
    treeEvent(input: $input) {
      ... on TreeRefreshedEventPayload {
        id
        tree {
          id
          label
          children {
            id
            label
            kind
            children {
              id
              label
              kind
            }
          }
        }
      }
    }
  }
`;

interface GQLTreeEventInput {
  id: string;
  editingContextId: string;
  /** ID of nodes to expand */
  expanded: string[];
}

/** Children after discovered only IDs of their parents are in the `expanded` array */
interface GQLRootObjectIdTreeEventResponse {
  id: string;
  tree: {
    id: string;
    label: string;
    children: {
      id: string;
      label: string;
      kind: string;

      children: {
        id: string;
        label: string;
        kind: string;
      }[];
    }[];
  };
}

const getSingleSubscriptionResponse =
  <T>(observable: Observable<T>): TE.TaskEither<unknown, T> =>
  () =>
    new Promise((resolve) => {
      const subscription = observable.subscribe(
        (result) => {
          subscription.unsubscribe();
          resolve(E.right(result));
        },
        (error) => {
          subscription.unsubscribe();
          resolve(E.left(error));
        }
      );
    });

type CancellationPoint = <U>(t: T.Task<U>) => T.Task<U>;
interface TaskCancellationContext {
  cancel: () => void;
  cancellationPoint: CancellationPoint;
}

/**
 * Allows marking when tasks should be cancelled and actually cancelling them.
 *
 * Cancelling means no further tasks will run beyond the cancellation point.
 *
 * Promise chains will be created anyway, but the cancellation point may never resolve,
 * which will not invoke further promise callbacks.
 */
const getTaskCancellationContext = (): TaskCancellationContext => {
  let canceled = false;

  return {
    cancel: () => {
      canceled = true;
    },
    cancellationPoint: (t) => (canceled ? T.never : t),
  };
};

const getTreeEventSingleSubscriptionResponse = (
  apolloClient: ApolloClient<unknown>,
  editingContextId: string,
  expanded: GQLTreeEventInput["expanded"]
): TE.TaskEither<Error, GQLRootObjectIdTreeEventResponse> =>
  pipe(
    getSingleSubscriptionResponse(
      apolloClient.subscribe<
        { treeEvent: GQLRootObjectIdTreeEventResponse },
        { input: GQLTreeEventInput }
      >({
        query: rootObjectIdTreeEventQuery,
        variables: {
          input: {
            id: uuid(),
            editingContextId,
            expanded,
          },
        },
      })
    ),
    TE.mapLeft((error) => {
      console.error("Unknown error from root object ID subscription", error);
      return new Error("Unknown error when fetching root object ID");
    }),
    TE.chain((result) => {
      if (result.errors) {
        console.error("Could not fetch root object ID", result.errors);
        return TE.left(
          new Error("GraphQL errors when fetching root object ID")
        );
      }

      return TE.of(result.data.treeEvent);
    })
  );

/**
 * Root object (`ComputationApplicationRelease`) ID can be retrieved
 * by asking for the expanded first level of the Explorer tree.
 */
const getRootObjectId = (
  apolloClient: ApolloClient<unknown>,
  editingContextId: string,
  cancellationPoint: CancellationPoint
): TE.TaskEither<Error, string> =>
  pipe(
    getTreeEventSingleSubscriptionResponse(apolloClient, editingContextId, []),
    cancellationPoint,
    TE.chain((response) => {
      const projectNode = response.tree.children[0];

      return getTreeEventSingleSubscriptionResponse(
        apolloClient,
        editingContextId,
        [projectNode.id]
      );
    }),
    TE.map((response) => response.tree.children[0].children[0].id),
    cancellationPoint
  );

export const useRootObjectId = (editingContextId: string) => {
  const apolloClient = useApolloClient();
  const [rootObjectId, setRootObjectId] = useState<
    O.Option<E.Either<Error, string>>
  >(O.none);

  useEffect(() => {
    const cancellactionContext = getTaskCancellationContext();

    setRootObjectId(O.none);

    pipe(
      getRootObjectId(
        apolloClient,
        editingContextId,
        cancellactionContext.cancellationPoint
      ),
      TE.match(
        (error) => {
          console.error("Could not fetch root object ID", error);
          setRootObjectId(O.some(E.left(error)));
        },
        (id) => {
          setRootObjectId(O.some(E.right(id)));
        }
      )
    )();

    return () => cancellactionContext.cancel();
  }, [apolloClient, editingContextId]);

  return rootObjectId;
};
