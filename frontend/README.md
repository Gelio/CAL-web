# CAL-web frontend

Based on
[the frontend for Sirius Web](https://github.com/eclipse-sirius/sirius-web/tree/master/frontend).

This projects consists of 2 parts:

1. The standalone diagram editor based on Sirius Web.

   It is a standalone frontend application that allows manipulating new Sirius
   Web projects and editing the models.

   This is also the application that is hosted by the Sirius Web backend server.

2. A library exposing the Sirius Web workbench as a standalone component.

   The library exposes plain JavaScript functions and is framework-agnostic. It
   allows mounting the workbench into any HTML container.

   See [an example frontend application](../frontend-library-example/README.md)
   that uses the workbench in a vanilla JavaScript application.

<!-- vim-markdown-toc GFM -->

- [Installation](#installation)
- [Building the standalone application](#building-the-standalone-application)
- [Building the library](#building-the-library)
- [Development](#development)
- [Library documentation](#library-documentation)
  - [`renderApp`](#renderapp)
  - [`unmountApp`](#unmountapp)
  - [`resolveWorkbenchProperties`](#resolveworkbenchproperties)

<!-- vim-markdown-toc -->

## Installation

Run the following to install the dependencies:

```sh
npm install
```

## Building the standalone application

To build the frontend code into minified static assets, run:

```sh
npm run build
```

The build results will be in the `build` directory. You can then copy them to an
appropriate backend directory to be used in the final application. See
[the project's README.md](../README.md) for more information.

## Building the library

To build the workbench library, run:

```sh
npm run library:build
```

The build results will be in the `dist` directory.

To consume it from a local directory, in your application directory run:

```sh
npm install [path to frontend directory]
```

Alternatively, you can pack the library (`npm pack` in the `frontend` directory)
and then install it in your application directory:

```sh
npm install [path to tarball]
```

## Development

To run the frontend in development mode, run:

```sh
npm run start
```

Make sure you have a backend server running in the background.

The browser should open automatically with the frontend loaded. If that does not
happen, go to <http://localhost:3000>.

In development mode, changes to the frontend source code will be visible in the
browser without having to rebuild the application.

## Library documentation

This section contains a description of the functions exposed by the library.

See
[an example application using it here](../frontend-library-example/src/app.js).

### `renderApp`

`renderApp` renders the workbench in a given HTML container.

Example:

```ts
const apiURLs = {
  siriusWebWSAPIURL: "ws://localhost:8080",
  siriusWebHTTPAPIURL: "http://localhost:8080",
};

const workbenchProperties = (await resolveWorkbenchProperties({
  apiURLs,
  authToken: authTokenInput.value,
  projectId: projectIDInput.value,
})).right; // NOTE: ignores error handling, assumes this will always succeed

renderApp(
  {
    authToken: authTokenInput.value,
    apiURLs,
    workbenchProperties,
  },
  container: document.getElementById("root"),
);
```

### `unmountApp`

`unmountApp` hides the application and cleans up any event listeners it might
have attached.

Example:

```ts
unmountApp(document.getElementById("root"));
```

### `resolveWorkbenchProperties`

`resolveWorkbenchProperties` retrieves information about the project so they can
be provided to the workbench.

It returns an `Either<unknown, WorkbenchProperties>` from the `fp-ts` library
(see
[the documentation on the `Either` type](https://github.com/gcanti/fp-ts/blob/master/src/Either.ts)).

```ts
const apiURLs = {
  siriusWebWSAPIURL: "ws://localhost:8080",
  siriusWebHTTPAPIURL: "http://localhost:8080",
};

const workbenchPropertiesResult = await resolveWorkbenchProperties({
  apiURLs,
  authToken: authTokenInput.value,
  projectId: projectIDInput.value,
});
```

<!-- vim: set tw=80: -->
