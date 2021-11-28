import { renderApp } from "@eclipse-sirius/sirius-web";

const container = document.getElementById("root");

renderApp(
  {
    authToken: "",
    projectId: "",
  },
  container
);
