import ReactDOM from "react-dom";
import * as O from "fp-ts/lib/Option";
import * as E from "fp-ts/lib/Either";
import { Workbench } from "../src/views/edit-project/Workbench";
import {
  ApolloGraphQLClientProvider,
  getApolloClient,
} from "../src/ApolloGraphQLClient";
import { siriusWebTheme } from "../src/theme";
import { ThemeProvider } from "@material-ui/styles";
import { CssBaseline } from "@material-ui/core";
import { ComponentProps, PropsWithChildren } from "react";
import { useTokenStore } from "../src/auth";
import { APIURLsInput, useAPIURLsStore } from "../src/api-urls";
import "../src/fonts.css";
import "../src/reset.css";
import "../src/Sprotty.css";
import "../src/variables.css";
import { InMemoryCache } from "@apollo/client";
import {
  GQLGetProjectQueryData,
  GQLGetProjectQueryVariables,
} from "../src/views/edit-project/EditProjectView.types";
import { getProjectQuery } from "../src/views/edit-project/EditProjectView";
import { getRepresentationFromEditingContext } from "../src/views/edit-project/EditProjectViewMachine";
import { pipe } from "fp-ts/lib/function";

export interface AppProperties {
  workbenchProperties: WorkbenchProperties;
  authToken: string;
  apiURLs: APIURLsInput;
}

export type WorkbenchProperties = Required<
  Pick<ComponentProps<typeof Workbench>, "editingContextId" | "representation">
>;

export function renderApp(
  appProperties: AppProperties,
  container: HTMLElement
) {
  useTokenStore.getState().setToken(appProperties.authToken);
  useAPIURLsStore.getState().setURLs(appProperties.apiURLs);

  ReactDOM.render(
    <AppProviders>
      <Workbench {...appProperties.workbenchProperties} />
    </AppProviders>,
    container
  );
}

/**
 * Unmounts the application from a given container.
 * A no-op if the application was not mounted in a given container.
 *
 * @returns was the app unmounted successfully
 */
export function unmountApp(container: HTMLElement) {
  return ReactDOM.unmountComponentAtNode(container);
}

/**
 * Queries the Sirius Web backend to get information
 * required to show the workbench.
 */
export const resolveWorkbenchProperties = async ({
  projectId,
  apiURLs: apiURLsInput,
  authToken,
}: { projectId: string } & Pick<AppProperties, "authToken" | "apiURLs">) => {
  useAPIURLsStore.getState().setURLs(apiURLsInput);
  const apiURLs = useAPIURLsStore.getState();
  const apolloClient = getApolloClient({
    urls: apiURLs,
    token: O.some(authToken),
    cache: new InMemoryCache(),
  });

  const { data, error, errors } = await apolloClient
    .query<GQLGetProjectQueryData, GQLGetProjectQueryVariables>({
      query: getProjectQuery,
      variables: {
        projectId,
      },
    })
    .catch((error) => ({ error, data: undefined, errors: undefined }));

  if (error || errors) {
    return E.left(error || errors);
  }

  const { currentEditingContext } = data.viewer.project;
  const representationResult = getRepresentationFromEditingContext(
    currentEditingContext
  );

  return pipe(
    representationResult,
    E.map(
      (representation): WorkbenchProperties => ({
        editingContextId: currentEditingContext.id,
        representation,
      })
    )
  );
};

const AppProviders = ({ children }: PropsWithChildren<{}>) => {
  return (
    <ApolloGraphQLClientProvider>
      <ThemeProvider theme={siriusWebTheme}>
        {children}
        <CssBaseline />
      </ThemeProvider>
    </ApolloGraphQLClientProvider>
  );
};
