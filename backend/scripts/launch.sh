#!/usr/bin/env bash
set -euo pipefail

# https://stackoverflow.com/a/246128/4874344
script_dir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)"

cd "$script_dir/.."

# Do not word split on purpose. Otherwise, java tries to run an empty string
# shellcheck disable=SC2086
java ${EXTRA_JAVA_ARGS:-} \
	-jar sirius-web-sample-application/target/sirius-web-sample-application-*.jar \
	--spring.datasource.url=jdbc:postgresql://localhost:5433/sirius-web-db \
	--spring.datasource.username=dbuser \
	--spring.datasource.password=dbpwd \
	--spring.liquibase.change-log=classpath:db/changelog/sirius-web.db.changelog.xml \
	--spring.profiles.active=dev \
	--org.eclipse.sirius.web.features.studioDefinition=true \
	"$@"
