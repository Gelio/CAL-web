import * as E from "fp-ts/lib/Either";
import { parse as safeParse } from "fp-ts/lib/Json";
import { flow, pipe } from "fp-ts/lib/function";

export type TokenDecodeError =
  | { type: "not enough parts" }
  | { type: "cannot parse payload"; error: unknown }
  | { type: "payload is not an object" };

const getTokenPayload = (
  authToken: string
): E.Either<TokenDecodeError, Record<string, unknown>> => {
  // See https://github.com/auth0/jwt-decode/blob/master/lib/index.js
  return pipe(
    E.of(authToken.split(".")),
    E.chain((parts) => {
      if (parts.length !== 3) {
        return E.left({ type: "not enough parts" });
      }

      return E.right(parts[1]);
    }),
    E.map(atob),
    E.chain(safeParse),
    E.mapLeft(
      (error): TokenDecodeError => ({
        type: "cannot parse payload",
        error,
      })
    ),
    E.chain((json) => {
      if (typeof json !== "object" || Array.isArray(json)) {
        return E.left<TokenDecodeError>({
          type: "payload is not an object",
        });
      }

      return E.right(json as Record<string, unknown>);
    })
  );
};

export type TokenExpiryVerificationError =
  | { type: "missing expiry field" }
  | { type: "expiry field is not a number" };
const isTokenExpired = (
  tokenPayload: Record<string, unknown>
): E.Either<TokenExpiryVerificationError, boolean> => {
  if (!tokenPayload.hasOwnProperty("exp")) {
    return E.left<TokenExpiryVerificationError>({
      type: "missing expiry field",
    });
  }

  const expiry = tokenPayload["exp"];
  if (typeof expiry !== "number") {
    return E.left<TokenExpiryVerificationError>({
      type: "expiry field is not a number",
    });
  }

  return E.right(expiry * 1000 <= Date.now());
};

export const isTokenExpiredPipeline = flow(
  getTokenPayload,
  E.chainW(isTokenExpired)
);

export const getTokenVerificationErrorTitle = (
  error: TokenDecodeError | TokenExpiryVerificationError
): string => {
  switch (error.type) {
    case "not enough parts":
      return "Could not parse the token: not enough parts";
    case "cannot parse payload":
      return `Could not parse the token payload: ${error.error}`;
    case "missing expiry field":
      return "Malformed token - expiry (exp) field is missing from the payload";
    case "payload is not an object":
      return "Malformed token - payload is not an object";
    case "expiry field is not a number":
      return "Malformed token - expiry (exp) field is not a number";
  }
};
