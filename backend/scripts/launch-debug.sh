#!/usr/bin/env bash
set -euo pipefail

# https://stackoverflow.com/a/246128/4874344
script_dir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)"

suspend=${SUSPEND:-"n"}

export EXTRA_JAVA_ARGS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=${suspend},address=8000"
"$script_dir/launch.sh"
