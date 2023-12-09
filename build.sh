#!/bin/bash

echo "start build..."

cd api-gateway
mvn clean install -DskipTests -T 4

cd ../service-discovery
mvn clean install -DskipTests -T 4

cd ../product-service
mvn clean install -DskipTests -T 4

cd ../order-service
mvn clean install -DskipTests -T 4

docker compose up