#!/usr/bin/env bash
set -euo pipefail

# Generates settings.xml based on settings-template.xml
# settings.xml contains inlined secrets (the GitHub token)

# https://stackoverflow.com/a/246128/4874344
script_dir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)"

github_username=${GITHUB_USERNAME:-${1-}}
github_token=${GITHUB_TOKEN:-${2-}}

if [ -z "$github_username" ] || [ -z "$github_token" ]; then
	echo "GitHub Username or token is not provided."
	echo "Provide GITHUB_USERNAME and GITHUB_TOKEN as environment variables or arguments to this script:"
	echo "$0 [GITHUB_USERNAME] [GITHUB_TOKEN]"
	exit 1
fi

backend_dir=$(realpath "$script_dir/..")
settings_template_path="$backend_dir/settings-template.xml"
settings_path="$backend_dir/settings.xml"

if [ ! -f "$settings_template_path" ]; then
	echo "Settings template file not found at $settings_template_path"
	echo "Something is wrong with the repository configuration"
	exit 2
fi

# Variables names are passed in single quotes on purpose
# shellcheck disable=SC2016
GITHUB_USERNAME=${github_username} GITHUB_TOKEN=${github_token} envsubst '${GITHUB_USERNAME},${GITHUB_TOKEN}' \
	<"$settings_template_path" \
	>"$settings_path"

echo "settings.xml generated to $settings_path"
