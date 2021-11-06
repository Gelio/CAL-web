#!/usr/bin/env bash
set -euo pipefail

# https://stackoverflow.com/a/246128/4874344
script_dir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)"

frontend_destination_directory="$script_dir/backend/sirius-web-frontend/src/main/resources/static"

mkdir -p "$frontend_destination_directory"
cp -R "$script_dir/frontend/build/*" "$frontend_destination_directory"
