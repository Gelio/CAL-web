import * as O from "fp-ts/lib/Option";
import { onError } from "@apollo/client/link/error";
import { useAuthErrorStore } from "./error";
import { ServerError } from "@apollo/client";

export const getAuthHeaders = (token: O.Option<string>) => ({
  Authorization: O.isSome(token) ? `Bearer ${token.value}` : undefined,
});

export const getAuthErrorLink = () =>
  onError(({ networkError }) => {
    if (networkError && isServerError(networkError)) {
      if (networkError.statusCode === 401 || networkError.statusCode === 403) {
        useAuthErrorStore.getState().setError(networkError);
      }
    }
  });

const isServerError = (error: Error): error is ServerError =>
  error.name === "ServerError";
