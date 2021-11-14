import * as TE from "fp-ts/lib/TaskEither";
import { pipe } from "fp-ts/lib/function";
import { useEffect, useState } from "react";
import { ToolboxEntry } from "./interop";
import { UseToolboxEntryButton } from "./UseToolboxEntryButton";
import { useRootObjectId } from "./root-object-id";
import { isNone } from "fp-ts/lib/Option";
import { isLeft } from "fp-ts/lib/Either";

interface ToolboxProps {
  editingContextId: string;
}

const toolboxUrl = `${process.env.REACT_APP_BALTICLSC_API_URL}/backend/dev/toolbox/`;

interface BalticLSCToolboxResponseBody {
  data: ToolboxEntry[];
  message: string;
  success: boolean;
}

const fetchToolboxEntries = ({
  authToken,
  abortSignal,
}: {
  authToken: string;
  abortSignal: AbortSignal;
}): TE.TaskEither<Error, ToolboxEntry[]> => {
  return pipe(
    TE.tryCatch(
      () =>
        fetch(toolboxUrl, {
          headers: { Authorization: `Bearer ${authToken}` },
          signal: abortSignal,
        }),
      (reason) => reason as Error
    ),
    TE.chain((response) => {
      if (!response.ok) {
        if (response.status === 401) {
          return TE.left(new Error("Invalid authentication token"));
        } else {
          return TE.left(
            new Error(`Unexpected error (status code ${response.status})`)
          );
        }
      }

      return TE.tryCatch(
        () => response.json(),
        (reason) => {
          console.error("Cannot parse toolbox response", reason);
          return new Error("Cannot parse response");
        }
      );
    }),
    TE.chain((body: BalticLSCToolboxResponseBody) => {
      if (body.success) {
        return TE.of(body.data);
      }

      return TE.left(new Error(`Cannot get toolbox entries: ${body.message}`));
    })
  );
};

const useBalticLSCToolboxEntries = (authToken: string) => {
  const [error, setError] = useState<Error | undefined>();
  const [loading, setLoading] = useState(true);
  const [toolboxEntries, setToolboxEntries] = useState<
    ToolboxEntry[] | undefined
  >();

  useEffect(() => {
    setLoading(true);
    const abortController = new AbortController();
    const runFetch = pipe(
      fetchToolboxEntries({ authToken, abortSignal: abortController.signal }),
      TE.apFirst(TE.fromIO(() => setLoading(false))),
      TE.match(setError, (entries) => {
        setToolboxEntries(entries);
        setError(undefined);
      })
    );
    runFetch();

    return () => abortController.abort();
  }, [authToken]);

  return { error, loading, toolboxEntries };
};

export const Toolbox = ({ editingContextId }: ToolboxProps) => {
  // TODO: allow passing in the auth token, https://github.com/Gelio/CAL-web/issues/43
  const authToken =
    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6ImRlbW8iLCJzdWIiOiJkZW1vIiwianRpIjoiMjU2Y2RkZjRiZmQ0NGE5YzhmNTg1MGIxY2E0Zjc2YjciLCJzaWQiOiI3OGU5OTA1YzQ2NTU0OTkwODYwYzQxODQ3YmY1OGIxZiIsImV4cCI6MTYzNjkwNDQ2OCwiaXNzIjoid3V0LmJhbHRpY2xzYy5ldSIsImF1ZCI6Ind1dC5iYWx0aWNsc2MuZXUifQ.Mft3pbnrBqQRwXryFmyTNlNB4a9Y_ZHThe9T4IVI70A";

  const { error, loading, toolboxEntries } =
    useBalticLSCToolboxEntries(authToken);
  const rootObjectIdResOpt = useRootObjectId(editingContextId);

  if (loading) {
    return <div>Loading</div>;
  }

  if (error) {
    return <div>Cannot load toolbox: {error.message}</div>;
  }
  // TODO: add a button to refresh the entries
  if (isNone(rootObjectIdResOpt)) {
    return <div>Loading</div>;
  }
  const { value: rootObjectIdRes } = rootObjectIdResOpt;

  if (isLeft(rootObjectIdRes)) {
    return (
      <div>Cannot load root object ID: {rootObjectIdRes.left.message}</div>
    );
  }

  return (
    <div>
      {toolboxEntries?.map((entry) => (
        <UseToolboxEntryButton
          toolboxEntry={entry}
          key={entry.uid}
          editingContextId={editingContextId}
          rootObjectId={rootObjectIdRes.right}
        />
      ))}
    </div>
  );
};
