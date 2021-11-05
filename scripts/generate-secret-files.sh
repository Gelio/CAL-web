#!/usr/bin/env bash
set -e

# https://stackoverflow.com/a/246128/4874344
script_dir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)"
repo_dir=$(realpath "$script_dir/..")

"$repo_dir/backend/scripts/generate-settings.sh" "$1" "$2"
"$repo_dir/frontend/scripts/generate-npmrc.sh" "$2"
