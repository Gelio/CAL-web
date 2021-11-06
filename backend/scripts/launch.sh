#!/usr/bin/env bash
set -euo pipefail

# https://stackoverflow.com/a/246128/4874344
script_dir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)"

cd "$script_dir/.."

# Do not word split on purpose. Otherwise, java tries to run an empty string
# shellcheck disable=SC2086
java ${EXTRA_JAVA_ARGS:-} \
	-jar sirius-web-sample-application/target/sirius-web-sample-application-*.jar \
	--spring.profiles.active=dev \
	"$@"
