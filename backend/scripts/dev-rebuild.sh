#!/usr/bin/env bash
set -euo pipefail

# Performs a rebuild of only the model and the web application.
# It does not rebuild other backend projects, even if their source code changed.
# This results in a faster rebuild, but can potentially not include some
# changes.
#
# Useful when wanting to see the changes in the UI after modifying the model.

# https://stackoverflow.com/a/246128/4874344
script_dir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)"
backend_dir="$script_dir/.."

cd "$backend_dir/model"
../mvnw package

cd "$backend_dir"
./mvnw package -pl sirius-web-sample-application
