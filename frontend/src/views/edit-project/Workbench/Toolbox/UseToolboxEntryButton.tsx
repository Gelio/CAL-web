import * as E from "fp-ts/lib/Either";
import { v4 as uuid } from "uuid";
import { gql, useMutation } from "@apollo/client";
import { getGQLComputationUnitReleaseInput, ToolboxEntry } from "./interop";
import { pipe } from "fp-ts/lib/function";
import { GQLCreateUnitCallInput } from "./types";
import { Button } from "@material-ui/core";

interface UseToolboxEntryButtonProps {
  toolboxEntry: ToolboxEntry;
  editingContextId: string;
  rootObjectId: string;
}

const createUnitCallMutation = gql`
  mutation createUnitCall($input: CreateUnitCallInput!) {
    createUnitCall(input: $input) {
      __typename
      ... on CreateUnitCallSuccessPayload {
        id
        createdUnitCall {
          id
          kind
          label
        }
      }
      ... on ErrorPayload {
        message
      }
    }
  }
`;

export const UseToolboxEntryButton = ({
  toolboxEntry,
  rootObjectId,
  editingContextId,
}: UseToolboxEntryButtonProps) => {
  const [createToolboxEntry /* { data, loading, error } */] = useMutation(
    createUnitCallMutation
  );

  // TODO: display loading and error information
  // TODO: use images for button labels
  // TODO: add tooltips with unit name and version

  return (
    <Button
      onClick={() => {
        pipe(
          getGQLComputationUnitReleaseInput(toolboxEntry),
          E.match(
            (errors) => {
              console.error("Cannot parse toolbox entry", errors);
            },
            (unitRelease) => {
              const input: GQLCreateUnitCallInput = {
                id: uuid(),
                rootObjectId,
                editingContextId,
                unitRelease,
              };
              createToolboxEntry({
                variables: { input },
              });
            }
          )
        );
      }}
    >
      {toolboxEntry.unit.name} {toolboxEntry.version}
    </Button>
  );
};
