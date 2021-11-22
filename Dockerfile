# syntax=docker/dockerfile:1

FROM node:16.13 AS frontend-builder

WORKDIR /app

COPY frontend/package*.json ./
RUN --mount=type=secret,id=.npmrc,dst=./.npmrc npm ci

COPY frontend/ ./
RUN npm run build

FROM openjdk:11 AS app-builder

WORKDIR /app

COPY backend/ ./
COPY --from=frontend-builder /app/build ./sirius-web-frontend/src/main/resources/static/

# NOTE: must skip tests and use the `package` goal instead of `verify`
# sirius-web-persistence uses testcontainers which need to spin up Docker containers.
# https://www.testcontainers.org/supported_docker_environment/continuous_integration/dind_patterns/
# There was no easy solution to bind-mount the `/var/run/docker.sock` as the image is being built.
# maven surefire plugin tried to run tests in the `test` phase, before `package`.
# Skipping tests is a quick way to get the image to build.
RUN --mount=type=secret,id=settings.xml,dst=./settings.xml --mount=type=cache,target=/root/.m2/repository \
  ./mvnw package --settings settings.xml -DskipTests

# There are multiple jar files in the `target` directory, but only one of them is needed
RUN mkdir staging && \
  find sirius-web-sample-application/target -maxdepth 1 -name "*.jar" -not -name "*-sources.jar" -exec cp {} staging/sirius-web-application.jar \;

FROM openjdk:11 AS app-runner

WORKDIR /app

COPY --from=app-builder /app/staging/ ./

ENV PORT=8080

# NOTE: Heroku requires listening on the port passed in the $PORT environment variable
# Configuration can be passed in by mounting application.properties into `/app/application.properties`
# NOTE: use shell to expand environment variables https://stackoverflow.com/a/40454758/4874344
CMD ["sh", "-c", "java -jar sirius-web-application.jar --server.port=$PORT"]
