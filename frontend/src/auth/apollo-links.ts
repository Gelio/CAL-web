import * as O from "fp-ts/lib/Option";
import { onError } from "@apollo/client/link/error";

export const getAuthHeaders = (token: O.Option<string>) => ({
  Authorization: O.isSome(token) ? `Bearer ${token.value}` : undefined,
});

export const getAuthErrorLink = () =>
  onError(({ graphQLErrors, networkError }) => {
    console.log({ graphQLErrors, networkError });
    // TODO: show an error
  });
