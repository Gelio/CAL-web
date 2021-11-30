// @ts-check
import { renderApp, unmountApp } from "@eclipse-sirius/sirius-web";

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

let appMounted = false;
toggleApplicationButton.addEventListener("click", () => {
  if (appMounted) {
    unmountApp(container);
    toggleApplicationButton.textContent = "Mount application";
  } else {
    toggleApplicationButton.textContent = "Unmount application";
    renderApp(
      {
        authToken: authTokenInput.value,
        projectId: "",

        apiURLs: {
          // NOTE: assumes Sirius Web backend is running locally
          siriusWebWSAPIURL: "ws://localhost:8080",
          siriusWebHTTPAPIURL: "http://localhost:8080",
        },
      },
      container
    );
  }
  appMounted = !appMounted;
});
toggleApplicationButton.disabled = false;

toggleApplicationButton.click();
