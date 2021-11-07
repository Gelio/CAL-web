#!/usr/bin/env bash
set -euo pipefail

# https://stackoverflow.com/a/246128/4874344
script_dir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)"

repo_dir=$(realpath "$script_dir/..")

frontend_destination_directory="$repo_dir/backend/sirius-web-frontend/src/main/resources/static"

mkdir -p "$frontend_destination_directory"
cp -R "$repo_dir/frontend/build/" "$frontend_destination_directory"
