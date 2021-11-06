# CAL web

A web modeller for the CAL language.

Based on [sirius-web](https://github.com/eclipse-sirius/sirius-web).

## Setup

### Prerequisites

1. Java 11

   Make sure it is Java 11. Other version **will not work**.

2. Docker
3. Apache Maven 3.6.3

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
  ./backend/scripts/launch.sh --eu.balticlsc.model.features.modificationsEnabled=true
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

### Enabling experimental model modifications

To enable experimental model modifications, pass the
`--eu.balticlsc.model.features.modificationsEnabled=true` flag to the
`launch.sh` or `launch-debug.sh` script:

```sh
./backend/scripts/launch.sh --eu.balticlsc.model.features.modificationsEnabled=true
```

This will run the application with experimental model modifications. This means
that when loading the model, there will be an extra `ComputationUnitRelease`
added to the model.

The change is not meaningful right now, but it shows it is possible to modify
the model programmatically when it is being loaded.

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

3. After the patches are applies, update the commit the `sirius-web` submodule
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

<!-- vim: set tw=80: -->
