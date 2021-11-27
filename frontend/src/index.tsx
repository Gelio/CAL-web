/*******************************************************************************
 * Copyright (c) 2019, 2021 Obeo.
 * This program and the accompanying materials
 * are made available under the erms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
import { ApolloProvider } from "@apollo/client";
import CssBaseline from "@material-ui/core/CssBaseline";
import { ThemeProvider } from "@material-ui/core/styles";
import { ApolloGraphQLClient } from "ApolloGraphQLClient";
import { Main } from "main/Main";
import ReactDOM from "react-dom";
import { siriusWebTheme } from "theme";
import { BrowserRouter } from "react-router-dom";
import "./fonts.css";
import "./reset.css";
import "./Sprotty.css";
import "./variables.css";

const style = {
  display: "grid",
  gridTemplateColumns: "1fr",
  gridTemplateRows: "1fr",
  minHeight: "100vh",
};

ReactDOM.render(
  <ApolloProvider client={ApolloGraphQLClient}>
    <BrowserRouter>
      <ThemeProvider theme={siriusWebTheme}>
        <CssBaseline />
        <div style={style}>
          <Main />
        </div>
      </ThemeProvider>
    </BrowserRouter>
  </ApolloProvider>,
  document.getElementById("root")
);
