# CAL web

A web modeller for the CAL language.

Based on [sirius-web](https://github.com/eclipse-sirius/sirius-web).

## Setup

Keep in mind this project is using an outdated version of sirius-web.

The goal is to keep up-to-date with the latest version.

### Prerequisites

1. Java 11

   Make sure it is Java 11. Other version **will not work**.

2. Docker
3. Apache Maven 3.6.3

### Building

1. Generate a GitHub Access Token and add it to Maven and npm

   See <https://github.com/eclipse-sirius/sirius-web#github-access-token>.

2. In the `packages` directory, run:

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
