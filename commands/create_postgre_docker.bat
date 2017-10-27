docker network create -d bridge statsgen_net
docker run --name statsgre --network=statsgen_net --network-alias statsgre -p 5433:5432 -e POSTGRES_USER=statsgen -e POSTGRES_PASSWORD=root -d postgres:9.6