# Sirius Web Frontend

Based on [the frontend for Sirius Web](https://github.com/eclipse-sirius/sirius-web/tree/master/frontend).

## Installation

Run the following to install the dependencies:

```sh
npm install
```

## Building

To build the frontend code into minified static assets, run:

```sh
npm run build
```

The build results will be in the `build` directory.
You can then copy them to an appropriate backend directory to be used in the
final application. See [the project's README.md](../README.md) for more
information.

## Development

To run the frontend in development mode, run:

```sh
npm run start
```

Make sure you have a backend server running in the background.

The browser should open automatically with the frontend loaded. If that does not
happen, go to <http://localhost:3000>.

In development mode, changes to the frontend source code will be
visible in the browser without having to rebuild the application.

<!-- vim: set tw=80: -->
