import ReactDOM from "react-dom";
import { Workbench } from "../src/views/edit-project/Workbench";
import { ApolloGraphQLClientProvider } from "../src/ApolloGraphQLClient";
import { siriusWebTheme } from "../src/theme";
import { ThemeProvider } from "@material-ui/styles";
import { CssBaseline } from "@material-ui/core";
import { PropsWithChildren } from "react";
import { useTokenStore } from "../src/auth";
import { APIURLsInput, useAPIURLsStore } from "../src/api-urls";
import "../src/fonts.css";
import "../src/reset.css";
import "../src/Sprotty.css";
import "../src/variables.css";

interface AppProperties {
  projectId: string;
  authToken: string;
  apiURLs: APIURLsInput;
}

export function renderApp(
  appProperties: AppProperties,
  container: HTMLElement
) {
  useTokenStore.getState().setToken(appProperties.authToken);
  useAPIURLsStore.getState().setURLs(appProperties.apiURLs);

  ReactDOM.render(
    <AppProviders>
      <Workbench
        // TODO: resolve these parameters based on project ID. Maybe expose a function so the caller does it?
        editingContextId="89b137fd-8825-4671-b542-b738bbdac0ba"
        representation={{
          id: "3fbadf51-d4a1-4984-ade2-5a4db7ec6ca7",
          label: "Computation diagram",
          kind: "Diagram",
        }}
      />
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
