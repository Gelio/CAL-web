import { Button, styled } from "@material-ui/core";
import { pipe } from "fp-ts/lib/function";
import * as O from "fp-ts/lib/Option";
import * as TE from "fp-ts/lib/TaskEither";
import * as T from "fp-ts/lib/Task";
import {
  FormEventHandler,
  useCallback,
  useEffect,
  useRef,
  useState,
} from "react";
import { AuthTokenAcquiryInformation } from "./AuthTokenAcquiryInformation";
import { APIURLsStore, useAPIURLsStore } from "../../api-urls";

interface ChangeAuthTokenFormProps {
  initialAuthToken: O.Option<string>;
  onSubmit: (authToken: string) => void;
  onCancel: () => void;
}

const balticLSCAPIUrlSelector = ({ balticLSCAPIURL }: APIURLsStore) =>
  balticLSCAPIURL;

export const ChangeAuthTokenForm = ({
  initialAuthToken,
  onSubmit,
  onCancel,
}: ChangeAuthTokenFormProps) => {
  const onFormSubmit: FormEventHandler<HTMLFormElement> = (event) => {
    event.preventDefault();
    const formData = new FormData(event.target as HTMLFormElement);
    onSubmit(formData.get("authToken").toString());
  };
  const balticLSCAPIUrl = useAPIURLsStore(balticLSCAPIUrlSelector);
  const demoUserToken = useDemoUserToken(balticLSCAPIUrl);
  const tokenTextareaRef = useRef<HTMLTextAreaElement>();
  const abortController = useRef<O.Option<AbortController>>(O.none);

  const abort = () => {
    pipe(
      abortController.current,
      O.map((controller) => controller.abort())
    );
  };

  useEffect(() => abort, []);

  const loadDemoUserToken = () => {
    abort();
    const newController = new AbortController();
    abortController.current = O.some(newController);
    const run = pipe(
      T.fromIO(() => {
        if (tokenTextareaRef.current) {
          tokenTextareaRef.current.disabled = true;
        }
      }),
      T.apSecond(demoUserToken.load(newController.signal)),
      TE.match(
        (error) => {
          console.error("Could not fetch demo user token", error);
        },
        (token) => {
          if (tokenTextareaRef.current) {
            tokenTextareaRef.current.value = token;
          }
        }
      ),
      T.chainIOK(() => () => {
        if (tokenTextareaRef.current) {
          tokenTextareaRef.current.disabled = false;
        }
      })
    );

    run();
  };

  return (
    <form onSubmit={onFormSubmit}>
      <AuthTokenTextarea
        defaultValue={O.toNullable(initialAuthToken)}
        name="authToken"
        placeholder="Enter your authentication token"
        ref={tokenTextareaRef}
      />

      <AuthTokenAcquiryInformation />

      <AuthTokenFormButtonsContainer>
        <Button onClick={onCancel}>Cancel</Button>
        <ButtonGroup>
          <Button onClick={loadDemoUserToken} disabled={demoUserToken.loading}>
            Get demo user token
          </Button>
          <Button
            type="submit"
            variant="contained"
            color="primary"
            disabled={demoUserToken.loading}
          >
            Submit
          </Button>
        </ButtonGroup>
      </AuthTokenFormButtonsContainer>
    </form>
  );
};

const AuthTokenTextarea = styled("textarea")(({ theme }) => ({
  width: "100%",
  marginTop: theme.spacing(1),
  resize: "vertical",
  minHeight: "10em",
  boxShadow: theme.shadows[1],
}));
const AuthTokenFormButtonsContainer = styled("div")(({ theme }) => ({
  display: "flex",
  justifyContent: "space-between",
  marginTop: theme.spacing(2),
}));

const ButtonGroup = styled("div")(({ theme }) => ({
  display: "flex",
  gap: theme.spacing(1),
}));

const demoUserCredentials = {
  // NOTE: credentials are publicly available on the login page
  // @see https://balticlsc.iem.pw.edu.pl/#/
  username: "demo",
  password: "BalticDemo",
};
interface BalticLSCLoginResponseBody {
  data: {
    token: string;
  };
  message: string;
  success: boolean;
}
const useDemoUserToken = (balticLSCAPIURL: string) => {
  const [loading, setLoading] = useState(false);
  const loginUrl = `${balticLSCAPIURL}/backend/Login`;

  const load = useCallback(
    (abortSignal: AbortSignal) =>
      pipe(
        T.fromIO(() => setLoading(true)),
        T.chain(() =>
          TE.tryCatch(
            () =>
              fetch(loginUrl, {
                body: JSON.stringify(demoUserCredentials),
                headers: {
                  "Content-Type": "application/json",
                },
                method: "POST",
              }),
            (reason) => reason as Error
          )
        ),
        maybeInterruptTask(abortSignal),
        TE.chain((response) => {
          if (!response.ok) {
            return TE.left(
              new Error(
                `Cannot authenticate as demo user (status code ${response.status})`
              )
            );
          }

          return TE.tryCatch(
            () => response.json(),
            (reason) => {
              console.error(
                "Cannot parse authentication token response",
                reason
              );
              return new Error("Cannot parse response");
            }
          );
        }),
        TE.chain((body: BalticLSCLoginResponseBody) => {
          if (!body.success) {
            return TE.left(
              new Error(`Could not authenticate: ${body.message}`)
            );
          }

          return TE.right(body.data.token);
        }),
        T.chainFirst(() => T.fromIO(() => setLoading(false)))
      ),
    [loginUrl]
  );

  return {
    loading,
    load,
  };
};

/** Stops task execution if the signal was aborted */
const maybeInterruptTask = <T extends any>(abortSignal: AbortSignal) =>
  T.chain((value: T) => {
    if (abortSignal.aborted) {
      return T.never;
    }

    return T.of(value);
  });
