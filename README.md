# CAL web

A web modeller for the CAL language.

Based on [sirius-web](https://github.com/eclipse-sirius/sirius-web).

![Application UI](https://user-images.githubusercontent.com/889383/144030193-36d29f62-fd6c-451e-a273-c56292ca1487.png)

<!-- vim-markdown-toc GFM -->

- [Setup](#setup)
  - [Prerequisites](#prerequisites)
  - [Building](#building)
  - [Running the application](#running-the-application)
  - [Configuring the application](#configuring-the-application)
  - [Debugging the application](#debugging-the-application)
  - [Building and running the application with Docker](#building-and-running-the-application-with-docker)
  - [Using Docker Compose to run the application](#using-docker-compose-to-run-the-application)
- [Keeping up with the upstream `sirius-web`](#keeping-up-with-the-upstream-sirius-web)
- [Running tests](#running-tests)

<!-- vim-markdown-toc -->

## Setup

### Prerequisites

1. Java 11

   Make sure it is Java 11. Other versions **will not work**.

2. Docker
3. Apache Maven 3.6.3

You can build and run the application manually on your system (see
[Building](#building)), or
[use Docker](#building-and-running-the-application-with-docker).

### Building

1. Generate a GitHub Access Token and add it to Maven and npm

   See <https://github.com/eclipse-sirius/sirius-web#github-access-token>.

2. Build the frontend application (see
   [frontend/README.md](./frontend/README.md))

3. Copy the frontend build results to backend resources directory.

   ```sh
   ./scripts/copy-frontend.sh
   ```

4. Build the backend application.

   In the `backend` directory, run:

   ```sh
   ./mvnw package
   ```

   Use `./mvnw` (or `mvnw.cmd` on Windows). This uses
   [maven-wrapper](https://github.com/takari/maven-wrapper) which works even if
   Maven is not installed globally.

### Running the application

1. Start the database

   ```sh
   ./scripts/restart-siriusweb-postgresql.sh
   ```

2. Launch the backend application

   ```sh
   ./backend/scripts/launch.sh
   ```

### Configuring the application

The application uses standard
[Spring Boot application properties](https://docs.spring.io/spring-boot/docs/1.2.0.M1/reference/html/boot-features-external-config.html)
for configuration.

To configure the properties, do one of the following:

- pass the properties to the `launch.sh` script:

  ```sh
  ./backend/scripts/launch.sh --logging.level.org.eclipse.sirius.web=debug
  ```

- create an `application.properties` file in the current directory and launch
  the application

- modify the existing `application.properties` file and rebuild the backend

### Debugging the application

The backend application can be launched in debug mode using the following
script:

```sh
./backend/scripts/launch-debug.sh
```

This exposes a debugging interface on port 8000. This allows attaching debuggers
(such as
[Java Debugger for VSCode](https://github.com/microsoft/vscode-java-debug) or
[the debugger exposed via `nvim-jdtls`](https://github.com/mfussenegger/nvim-jdtls#debugger-via-nvim-dap)).

There is an existing VSCode [`launch.json`](./backend/.vscode/launch.json)
configuration. For neovim, there is an
[`nvim-dap`](https://github.com/mfussenegger/nvim-dap) configuration in
[`.nvimrc.lua`](./backend/.nvimrc.lua).

See [`launch-debug.sh`](./backend/scripts/launch-debug.sh) for details of debug
settings.

### Building and running the application with Docker

You can also run Docker to run the application.

First, you need to generate secret files (Maven `settings.xml` and `.npmrc` that
contain a GitHub Token to be able to pull packages from GitHub Packages). To do
that, run:

```sh
./scripts/generate-secret-files.sh [GitHub username] [GitHub token]
```

You only need to do this once.

Then, to build the `balticlsc/cal-web` Docker image, run:

```sh
./scripts/build-image.sh
```

You can then run it the same way as any other Docker image via `docker run`:

```sh
docker run --rm -it balticlsc/cal-web
```

Note that this will most likely fail, because you need to provide database
connection information. This can be done by passing command line arguments or
mounting an `application.properties` file into `/app` inside of the container.
See [a section about configuration](#configuring-the-application) for more
information.

Alternatively, this command is the equivalent of the `launch.sh` script but
using Docker to run the application:

```sh
docker run --network=host -it --rm balticlsc/cal-web \
  java -jar sirius-web-application.jar --spring.profiles.active=dev
```

### Using Docker Compose to run the application

You can also use [Docker Compose](https://docs.docker.com/compose/) to run the
database and the application.

1. Build the Docker image (see
   [the section about it](#building-and-running-the-application-with-docker)).
2. Run `docker-compose up -d`

   This will pull the Postgres database image and run both the database and the
   application.

See [`docker-compose.yml`](./docker-compose.yml) for details.

## Keeping up with the upstream `sirius-web`

The `sirius-web` directory is a git submodule containing the
[sirius-web](https://github.com/eclipse-sirius/sirius-web) repository. The
commit it points to is the commit that the rest of this repository is based on.

If there are changes to `sirius-web`, the diff between the current commit in the
`sirius-web` submodule and the latest version of that repository should be
reviewed and the changes applied to relevant parts of the main repository.

Git patches can be leveraged to make the pulling changes simpler.

1. Generate the patches for changes made in the upstream repository

   ```sh
   cd sirius-web
   git format-patch ..origin/master
   ```

   This will create one file per commit. Patch files start with a number
   (e.g. 0001) and have a `.patch` extension.

2. In the main repository, apply the patches using a three-way merge for
   resolving merge conflicts.

   ```sh
   git am -3 sirius-web/0*.patch
   ```

   This should apply all the patches and notify about any conflicts that need to
   be resolved manually.

3. After the patches are applied, update the commit the `sirius-web` submodule
   points to. This way it is clear which upstream commits are applied in this
   repository.

   ```sh
   cd sirius-web
   git pull origin/master
   cd ..
   git add sirius-web
   git commit
   ```

Alternatively, changes can be applied manually. This seems like a tedious
process, though. Using git patches is recommended.

NOTE: Files modified in patches will not run through the pre-commit hook. Thus,
make sure to wait for the CI to pass before merging the changes to see if the
project still builds and passes all checks.

## Running tests

To execute tests of the backend application, run the following command in the
`backend` directory:

```sh
./mvnw clean verify
```

This will compile the application and run unit and integration tests.

After modifying the code, make sure to run the tests again using the same
command. Running only `./mvnw test` or `./mvnw verify` can lead to
false-positive errors being reported. See
[this GitHub issue](https://github.com/Gelio/CAL-web/issues/58#issuecomment-971819426)
for more information.

<!-- vim: set tw=80: -->
