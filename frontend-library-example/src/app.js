import { renderApp } from "@eclipse-sirius/sirius-web";

const container = document.getElementById("root");

renderApp(
  {
    authToken:
      "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6ImRlbW8iLCJzdWIiOiJkZW1vIiwianRpIjoiNTg4NTRjYTYyMWIxNGRiYTgwMDZmNzgyYzU1NDRmNGQiLCJzaWQiOiJjNmI3MmRiOGZhYzI0ZDlhYjliZmNiMTk2NzUyYjQ4ZiIsImV4cCI6MTYzODEzMTM3OSwiaXNzIjoid3V0LmJhbHRpY2xzYy5ldSIsImF1ZCI6Ind1dC5iYWx0aWNsc2MuZXUifQ.b3-PAxFiUxPDdOOGDGaL7NrYr-jmyJmqYuuL2SKIJ_g",
    projectId: "",

    apiURLs: {
      // NOTE: assumes Sirius Web backend is running locally
      siriusWebWSAPIURL: "ws://localhost:8080",
      siriusWebHTTPAPIURL: "http://localhost:8080",
    },
  },
  container
);
