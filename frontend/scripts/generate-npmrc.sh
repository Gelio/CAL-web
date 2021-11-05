#!/usr/bin/env bash
set -euo pipefail

# Generates .npmrc based on .npmrc-template
# .npmrc contains inlined secrets (the GitHub token)

# https://stackoverflow.com/a/246128/4874344
script_dir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)"

github_token=${GITHUB_TOKEN:-${1-}}

if [ -z "$github_token" ]; then
	echo "GitHub token is not provided."
	echo "Provide GITHUB_TOKEN as an environment variable or an argument to this script:"
	echo "$0 [GITHUB_TOKEN]"
	exit 1
fi

frontend_dir=$(realpath "$script_dir/..")
npmrc_template_path="$frontend_dir/.npmrc-template"
npmrc_path="$frontend_dir/.npmrc"

if [ ! -f "$npmrc_template_path" ]; then
	echo ".npmrc template file not found at $npmrc_template_path"
	echo "Something is wrong with the repository configuration"
	exit 2
fi

# Variables names are passed in single quotes on purpose
# shellcheck disable=SC2016
GITHUB_TOKEN=${github_token} envsubst '${GITHUB_TOKEN}' \
	<"$npmrc_template_path" \
	>"$npmrc_path"

echo ".npmrc generated to $npmrc_path"
