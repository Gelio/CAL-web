# Example application embedding CAL-web workbench

This project contains an example frontend application that embeds
[the frontend library that renders the CAL-web (Sirius Web) workbench](../frontend/README.md).

## Installation

```sh
npm install
```

## Building the application

```sh
npm run build
```

The build results will be stored in the `dist` directory.

Then, you can run:

```sh
npm run serve-built-files
```

to host the static files at <http://localhost:1234>.

It assumes the Sirius Web backend is running at <http://localhost:8080> (the
default URL when running the backend locally with
[`launch.sh`](../backend/scripts/launch.sh)).

## Using the application

To render the workbench, the BalticLSC auth token and the project ID are needed.

You can get the BalticLSC auth token by logging in to
[BalticLSC](https://balticlsc.iem.pw.edu.pl/) (there are demo user credentials
available on that page) and copying the token from the console.

For the project ID, the easiest way would be to use
[the standalone CAL-web application](../frontend) to create the project, the
model, and the representation, and then copy the project ID from the URL. The
project ID is the segment after `/projects` in the URL. For example, for the URL
`http://localhost:3000/projects/89b137fd-8825-4671-b542-b738bbdac0ba/edit/3fbadf51-d4a1-4984-ade2-5a4db7ec6ca7`
the project ID is `89b137fd-8825-4671-b542-b738bbdac0ba`.

## Developing

```sh
npm start
```

This will start a server at <http://localhost:1234> and rebuild it on changes to
the source code.

It assumes the Sirius Web backend is running at <http://localhost:8080> (the
default URL when running the backend locally with
[`launch.sh`](../backend/scripts/launch.sh)).

Changes to [the workbench library](../frontend) may not be picked up
immediately. After rebuilding the library, run `rm .parcel-cache/ -rf` and
`npm start` again for the changes to be picked up.

<!-- vim: set tw=80; -->
