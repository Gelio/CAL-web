#!/usr/bin/env bash
set -euo pipefail

# Generate patches for `sirius-web` in the range `HEAD..origin/master` and
# apply them in the main repository.

# https://stackoverflow.com/a/246128/4874344
script_dir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)"
repo_dir=$(realpath "$script_dir/..")

submodule_directory=sirius-web

pushd "$repo_dir" >/dev/null
pushd "$submodule_directory" >/dev/null

existing_patch_files=$(ls ./*.patch 2>/dev/null || true)

if [[ -n "$existing_patch_files" ]]; then
	echo "There are existing patch files (*.patch) in the $submodule_directory"
	echo "Clean them up and start again"
	exit 1
fi

echo "Fetching $submodule_directory upstream commits"
git fetch
upstream_tip_rev=origin/master
upstream_tip_hash=$(git rev-parse "$upstream_tip_rev")

commits_to_upstream_tip=$(git rev-list "..$upstream_tip_hash")

if [ -z "$commits_to_upstream_tip" ]; then
	echo "Nothing to upgrade. Already up-to-date"
	echo "$upstream_tip_rev is at $upstream_tip_hash"
	exit 0
fi

commits_to_upstream_tip_count=$(wc -l <<<"$commits_to_upstream_tip")
echo "Upgrading $commits_to_upstream_tip_count commit(s) to $upstream_tip_rev ($upstream_tip_hash)"

echo "Generating patch files"
git format-patch "..$upstream_tip_hash"
echo "Generated patch files. Applying them in the main repository"
popd >/dev/null
if ! git am -3 $submodule_directory/*.patch; then
	echo ""
	echo "Could not cleanly apply patches. You are on your own now"
	echo "Use 'git status' for guidance"
	echo "Do not forget to remove generated patches in the $submodule_directory directory"
	echo "and point that submodule tip to $upstream_tip_rev ($upstream_tip_hash)"
	exit 2
fi

echo "Cleaning up generated patches"
pushd "$submodule_directory" >/dev/null
rm ./*.patch

echo "Updating $submodule_directory tip to $upstream_tip_rev ($upstream_tip_hash)"
git pull "$upstream_tip_hash"

echo "Done, upgraded $commits_to_upstream_tip_count commits"
