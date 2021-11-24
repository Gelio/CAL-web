import * as TE from "fp-ts/lib/TaskEither";
import * as O from "fp-ts/lib/Option";
import { pipe } from "fp-ts/lib/function";
import { ToolboxEntry } from "./interop";
import { useEffect, useState } from "react";
import { httpOrigin } from "@eclipse-sirius/sirius-components";

interface BalticLSCToolboxResponseBody {
  data: ToolboxEntry[];
  message: string;
  success: boolean;
}

const balticLSCAPIUrl =
  process.env.REACT_APP_BALTICLSC_API_URL ??
  `${httpOrigin}/api/balticlsc-proxy`;

const toolboxUrl = `${balticLSCAPIUrl}/backend/dev/toolbox/`;

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

export const useBalticLSCToolboxEntries = (authToken: O.Option<string>) => {
  const [error, setError] = useState<Error | undefined>();
  const [loading, setLoading] = useState(true);
  const [toolboxEntries, setToolboxEntries] = useState<
    ToolboxEntry[] | undefined
  >();

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
      }),
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
