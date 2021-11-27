import CssBaseline from "@material-ui/core/CssBaseline";
import { ThemeProvider } from "@material-ui/core/styles";
import { ApolloGraphQLClientProvider } from "ApolloGraphQLClient";
import { AuthContextProvider } from "auth";
import { Main } from "main/Main";
import { BrowserRouter } from "react-router-dom";
import { siriusWebTheme } from "theme";

const style = {
  display: "grid",
  gridTemplateColumns: "1fr",
  gridTemplateRows: "1fr",
  minHeight: "100vh",
};

export const App = () => (
  <AuthContextProvider>
    <ApolloGraphQLClientProvider>
      <BrowserRouter>
        <ThemeProvider theme={siriusWebTheme}>
          <CssBaseline />
          <div style={style}>
            <Main />
          </div>
        </ThemeProvider>
      </BrowserRouter>
    </ApolloGraphQLClientProvider>
  </AuthContextProvider>
);
