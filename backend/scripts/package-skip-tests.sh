#!/usr/bin/env bash
set -euo pipefail

# Package the backend directory but skip tests.
# The tests for the packages that remain faily stable (e.g. sirius-web-graphql)
# take a long time, which prolongs the build unnecessarily.
#
# Packaging without tests is mostly safe and about 50% faster.

# https://stackoverflow.com/a/246128/4874344
script_dir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)"
backend_dir="$script_dir/.."

cd "$backend_dir"
./mvnw package -DskipTests
