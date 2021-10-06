#!/usr/bin/env bash
set -euo pipefail

mkdir -p backend/sirius-web-frontend/src/main/resources/static
cp -R frontend/build/* backend/sirius-web-frontend/src/main/resources/static
