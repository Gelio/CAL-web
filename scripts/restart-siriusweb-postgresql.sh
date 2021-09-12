#!/usr/bin/env bash
set -euo pipefail

container_name=sirius-web-postgres
container_running=$(docker ps | grep $container_name || true)

if [ -n "$container_running" ]; then
	echo "Stopping an existing $container_name container"
	docker stop sirius-web-postgres
fi

echo "Starting $container_name"
docker run -p 5433:5432 --rm --name sirius-web-postgres \
	-e POSTGRES_USER=dbuser \
	-e POSTGRES_PASSWORD=dbpwd \
	-e POSTGRES_DB=sirius-web-db \
	-d postgres
