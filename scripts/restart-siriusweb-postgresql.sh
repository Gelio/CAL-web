#!/usr/bin/env bash
set -euo pipefail

running_containers=$(docker ps -q)

if echo "$running_containers" | grep 'sirius-web-postgres'; then
	docker stop sirius-web-postgres
fi

docker run -p 5433:5432 --rm --name sirius-web-postgres \
	-e POSTGRES_USER=dbuser \
	-e POSTGRES_PASSWORD=dbpwd \
	-e POSTGRES_DB=sirius-web-db \
	-d postgres
