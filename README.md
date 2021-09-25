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

2. In the `backend` directory, run:

   ```sh
   mvn package
   ```

### Running the application

1. Start the database

   ```sh
   ./scripts/restart-siriusweb-postgresql.sh
   ```

2. Launch the application

   ```sh
   ./scripts/restart-siriusweb-postgresql.sh
   ```

## Keeping up with the upstream `sirius-web`

The `sirius-web` directory is a git submodule containing the
[sirius-web](https://github.com/eclipse-sirius/sirius-web) repository.
The commit it points to is the commit that the rest of this repository is based
on.

If there are changes to `sirius-web`, the diff between the current commit in the
`sirius-web` submodule and the latest version of that repository should be
reviewed and the changes applied to relevant parts of the main repository.

Changes need to be applied manually since the structure of the main repository
is different from `sirius-web`'s. Not all parts of `sirius-web` are relevant in
the main repository.

<!-- vim: set tw=80: -->
