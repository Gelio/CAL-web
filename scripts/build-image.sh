#!/usr/bin/env bash
set -euo pipefail

# A script that orchestrates building the Docker image for the application

# https://stackoverflow.com/a/246128/4874344
script_dir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)"
repo_dir="$script_dir/.."

npmrc_path="$repo_dir/frontend/.npmrc"
settings_path="$repo_dir/backend/settings.xml"

if [ ! -f "$npmrc_path" ] || [ ! -f "$settings_path" ]; then
	echo ".npmrc or settings.xml secret files are not generated"
	echo "See the README for information about prerequisites" \
		"to building a Docker image"
	echo "TL;DR: run the $repo_dir/scripts/generate-secret-files.sh script"
	exit 1
fi

# 1 MB of logs is not enough for maven. 10 MB should be enough
# Changing the log limit requires creating a new BuildKit builder
# https://github.com/docker/buildx/issues/484#issuecomment-757105086
log_limit=10485760
docker_builder_name="cal-builder"

if ! docker buildx inspect "$docker_builder_name" >/dev/null 2>&1; then
	docker buildx create \
		--name "$docker_builder_name" \
		--driver-opt env.BUILDKIT_STEP_LOG_MAX_SIZE=$log_limit \
		--driver-opt env.BUILDKIT_STEP_LOG_MAX_SPEED=$log_limit
fi

cd "$repo_dir"
docker buildx build \
	--builder "$docker_builder_name" \
	--secret "id=.npmrc,src=$npmrc_path" \
	--secret "id=settings.xml,src=$settings_path" \
	-t balticlsc/cal-web \
	--load \
	.
