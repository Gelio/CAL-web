/*******************************************************************************
 * Copyright (c) 2019, 2020 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
import {
  ApolloClient,
  ApolloProvider,
  DefaultOptions,
  from,
  HttpLink,
  InMemoryCache,
  split,
} from "@apollo/client";
import { WebSocketLink } from "@apollo/client/link/ws";
import { getMainDefinition } from "@apollo/client/utilities";
import { httpOrigin, wsOrigin } from "@eclipse-sirius/sirius-components";
import {
  getAuthErrorLink,
  getAuthHeaders,
  TokenStore,
  useTokenStore,
} from "auth";
import { PropsWithChildren, useMemo } from "react";
import * as O from "fp-ts/lib/Option";

const httpLink = (token: O.Option<string>) =>
  new HttpLink({
    uri: `${process.env.REACT_APP_HTTP_ORIGIN ?? httpOrigin}/api/graphql`,
    headers: getAuthHeaders(token),
  });

const wsLink = (token: O.Option<string>) =>
  new WebSocketLink({
    uri: `${process.env.REACT_APP_WS_ORIGIN ?? wsOrigin}/subscriptions`,
    options: {
      reconnect: true,
      lazy: true,
      connectionParams: () => ({
        // NOTE: these headers are not automatically handled by Sirius Web
        // See https://github.com/Gelio/CAL-web/issues/96#issuecomment-980572837
        // Based on https://github.com/apollographql/apollo-client/issues/3967#issuecomment-450255702
        headers: getAuthHeaders(token),
      }),
    },
  });

const splitLink = (token: O.Option<string>) =>
  split(
    ({ query }) => {
      const definition = getMainDefinition(query);
      return (
        definition.kind === "OperationDefinition" &&
        definition.operation === "subscription"
      );
    },
    wsLink(token),
    httpLink(token)
  );

const defaultOptions: DefaultOptions = {
  watchQuery: {
    fetchPolicy: "no-cache",
  },
  query: {
    fetchPolicy: "no-cache",
  },
  mutate: {
    fetchPolicy: "no-cache",
  },
};

const tokenSelector = ({ token }: TokenStore) => token;

export const ApolloGraphQLClientProvider = ({
  children,
}: PropsWithChildren<{}>) => {
  const token = useTokenStore(tokenSelector);
  const cache = useMemo(() => new InMemoryCache(), []);
  const client = useMemo(
    () =>
      new ApolloClient({
        link: from([getAuthErrorLink(), splitLink(token)]),
        cache,
        connectToDevTools: true,
        defaultOptions,
      }),
    [cache, token]
  );

  return <ApolloProvider client={client}>{children}</ApolloProvider>;
};
