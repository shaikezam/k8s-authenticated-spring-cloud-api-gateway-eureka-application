#!/bin/bash

echo "start build..."

cd api-gateway
mvn clean install -DskipTests -T 4
docker build -t api-gateway .

cd ../service-discovery
mvn clean install -DskipTests -T 4
docker build -t service-discovery .

cd ../product-service
mvn clean install -DskipTests -T 4
docker build -t product-service .

cd ../order-service
mvn clean install -DskipTests -T 4
docker build -t order-service .

cd ../db
docker build -t db .

cd ../

kubectl apply -f app.yml