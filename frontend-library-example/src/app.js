// @ts-check
import {
  renderApp,
  resolveWorkbenchProperties,
  unmountApp,
} from "@eclipse-sirius/sirius-web";
import * as E from "fp-ts/lib/Either";
import { pipe } from "fp-ts/lib/function";

const container = document.getElementById("root");

/** @type {HTMLButtonElement} */
const toggleApplicationButton = document.getElementById("toggle-application");
console.assert(
  toggleApplicationButton,
  "App explanation container was not found"
);

/** @type {HTMLInputElement} */
const authTokenInput = document.getElementById("auth-token");
console.assert(
  authTokenInput,
  "Authentication token input element was not found"
);

/** @type {HTMLInputElement} */
const projectIDInput = document.getElementById("project-id");
console.assert(projectIDInput, "Project ID input element was not found");
const apiURLs = {
  // NOTE: assumes Sirius Web backend is running locally
  siriusWebWSAPIURL: "ws://localhost:8080",
  siriusWebHTTPAPIURL: "http://localhost:8080",
};

let appMounted = false;
toggleApplicationButton.addEventListener("click", async () => {
  if (appMounted) {
    unmountApp(container);
    toggleApplicationButton.textContent = "Mount application";
    appMounted = false;
  } else {
    toggleApplicationButton.textContent = "Loading...";
    toggleApplicationButton.disabled = true;

    const workbenchPropertiesResult = await resolveWorkbenchProperties({
      apiURLs,
      authToken: authTokenInput.value,
      projectId: projectIDInput.value,
    });
    pipe(
      workbenchPropertiesResult,
      E.match(
        (error) => {
          console.error("Could not get workbench properties", error);
          toggleApplicationButton.textContent = "Error, check console";
        },
        (workbenchProperties) => {
          toggleApplicationButton.textContent = "Unmount application";
          renderApp(
            {
              authToken: authTokenInput.value,
              apiURLs,
              workbenchProperties,
            },
            container
          );
          appMounted = true;
        }
      )
    );

    toggleApplicationButton.disabled = false;
  }
});
toggleApplicationButton.disabled = false;
