import * as TE from "fp-ts/lib/TaskEither";
import * as T from "fp-ts/lib/Task";
import * as O from "fp-ts/lib/Option";
import { pipe } from "fp-ts/lib/function";
import { ToolboxEntry } from "./interop";
import { useEffect, useState } from "react";
import { APIURLsStore, useAPIURLsStore } from "../../../../api-urls";

interface BalticLSCToolboxResponseBody {
  data: ToolboxEntry[];
  message: string;
  success: boolean;
}

const fetchToolboxEntries = ({
  authToken,
  abortSignal,
  balticLSCAPIUrl,
}: {
  authToken: string;
  abortSignal: AbortSignal;
  balticLSCAPIUrl: string;
}): TE.TaskEither<Error, ToolboxEntry[]> => {
  const toolboxUrl = `${balticLSCAPIUrl}/backend/dev/toolbox/`;

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

const balticLSCAPIUrlSelector = ({ balticLSCAPIURL }: APIURLsStore) =>
  balticLSCAPIURL;

export const useBalticLSCToolboxEntries = (authToken: O.Option<string>) => {
  const [error, setError] = useState<Error | undefined>();
  const [loading, setLoading] = useState(true);
  const [toolboxEntries, setToolboxEntries] = useState<
    ToolboxEntry[] | undefined
  >();
  const balticLSCAPIUrl = useAPIURLsStore(balticLSCAPIUrlSelector);
  const [refreshId, setRefreshId] = useState(Math.random);

  const refresh = () => setRefreshId(Math.random());

  useEffect(() => {
    if (O.isNone(authToken)) {
      setError(new Error("Missing authentication token"));
      setLoading(false);
      return;
    }

    setError(undefined);
    setLoading(true);
    const abortController = new AbortController();
    const runFetch = pipe(
      fetchToolboxEntries({
        authToken: authToken.value,
        abortSignal: abortController.signal,
        balticLSCAPIUrl,
      }),
      TE.match(setError, (entries) => {
        setToolboxEntries(entries);
        setError(undefined);
      }),
      T.map(() => setLoading(false))
    );
    runFetch();

    return () => abortController.abort();
  }, [authToken, balticLSCAPIUrl, refreshId]);

  return { error, loading, toolboxEntries, refresh };
};
