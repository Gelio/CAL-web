import * as E from "fp-ts/lib/Either";
import * as O from "fp-ts/lib/Option";
import {
  getTokenExpiryDate,
  getTokenPayload,
  getTokenVerificationErrorTitle,
  TokenDecodeError,
  TokenExpiryVerificationError,
} from "../is-token-expired";
import { ReactNode, useEffect, useMemo, useState } from "react";
import { pipe } from "fp-ts/lib/function";
import { formatDistanceToNowStrict } from "date-fns";
import { Typography } from "@material-ui/core";

interface AuthTokenDetailsProps {
  token: string;
}

export const AuthTokenDetails = ({ token }: AuthTokenDetailsProps) => {
  const [details, setDetails] = useState<
    O.Option<E.Either<TokenDecodeError | TokenExpiryVerificationError, Details>>
  >(() => parseToken(token));

  const debouncedSetDetails = useMemo(
    () => debounce((token: string) => pipe(parseToken(token), setDetails)),
    []
  );

  useEffect(() => {
    debouncedSetDetails(token);
  }, [token, debouncedSetDetails]);

  if (O.isNone(details)) {
    return <>Empty token</>;
  }

  if (E.isLeft(details.value)) {
    return <>Error: {getTokenVerificationErrorTitle(details.value.left)}</>;
  } else {
    const unwrappedDetails = details.value.right;
    return (
      <>
        <Typography variant="body2" gutterBottom>
          Username: {unwrappedDetails.username}
        </Typography>
        <Typography variant="body2">
          <Refresher value={unwrappedDetails.expiryDate}>
            {() =>
              `${
                unwrappedDetails.expiryDate.getTime() <= Date.now()
                  ? "Expired"
                  : "Expires"
              } ${formatDistanceToNowStrict(unwrappedDetails.expiryDate, {
                addSuffix: true,
              })}`
            }
          </Refresher>
        </Typography>
      </>
    );
  }
};

interface Details {
  username: unknown;
  expiryDate: Date;
}

const debounce = <F extends (...arg: any[]) => any>(f: F, waitMs = 500) => {
  let timer: O.Option<number> = O.none;

  return (...args: Parameters<F>): void => {
    if (O.isSome(timer)) {
      clearTimeout(timer.value);
    }

    timer = O.some(
      // NOTE: use `window` prefix because of type mismatch coming from
      // `@types/node`
      window.setTimeout(() => {
        f(...args);
        timer = O.none;
      }, waitMs)
    );
  };
};

const parseToken = (
  tokenArg: string
): O.Option<
  E.Either<TokenDecodeError | TokenExpiryVerificationError, Details>
> =>
  pipe(
    O.fromNullable(tokenArg),
    O.filter((token) => token.length > 0),
    O.map((token) =>
      pipe(
        E.Do,
        E.bind("payload", () => getTokenPayload(token)),
        E.bindW("expiryDate", ({ payload }) => getTokenExpiryDate(payload)),
        E.map(
          ({ payload, expiryDate }): Details => ({
            username: payload.sub,
            expiryDate,
          })
        )
      )
    )
  );

interface RefresherProps<T> {
  value: T;
  children: (value: T) => ReactNode;
  intervalMs?: number;
}
/**
 * Refreshes content on an interval. Makes sure relative dates are
 * accurate.
 */
const Refresher = <T extends any>({
  value,
  children: updater,
  intervalMs = 1000,
}: RefresherProps<T>) => {
  const [computedValue, setComputedValue] = useState(() => updater(value));

  useEffect(() => {
    setComputedValue(updater(value));
    const intervalRef = setInterval(() => {
      setComputedValue(updater(value));
    }, intervalMs);
    return () => clearInterval(intervalRef);
  }, [value, intervalMs, updater]);

  return <>{computedValue}</>;
};
