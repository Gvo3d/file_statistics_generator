docker network create -d bridge statsgen_net
docker run --name statsgre --network=statsgen_net --network-alias statsgre -p 5433:5432 -e POSTGRES_USER=statsgen -e POSTGRES_PASSWORD=root -d postgres:9.6
docker build --network=statsgen_net -t statsgen_image ./dockerfile
docker run --name statsgen_server -network=statsgen_net -p 8080:8080 statsgen_image