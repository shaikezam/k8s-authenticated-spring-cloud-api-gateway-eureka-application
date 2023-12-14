#!/bin/bash

echo "start build..."

echo "start build api-gateway"
cd api-gateway
mvn clean install -DskipTests -T 4
docker build -t api-gateway .
echo "finished build api-gateway"

echo "start build service-discovery"
cd ../service-discovery
mvn clean install -DskipTests -T 4
docker build -t service-discovery .
echo "finished build service-discovery"

echo "start build product-service"
cd ../product-service
mvn clean install -DskipTests -T 4
docker build -t product-service .
echo "finished build product-service"

echo "start build order-service"
cd ../order-service
mvn clean install -DskipTests -T 4
docker build -t order-service .
echo "finished build order-service"

echo "start build db"
cd ../db
docker build -t db .
echo "finished build db"

#echo "start build keycloak"
#cd ../keycloak
#docker build -t keycloak .
#echo "finished build keycloak"
#kubectl get events --all-namespaces  --sort-by='.metadata.creationTimestamp'

cd ../k8s-resources
echo "start build entire application"
kubectl apply -f api-gw.yml
kubectl apply -f service-discovery.yml
kubectl apply -f order-service.yml
kubectl apply -f product-service.yml
kubectl apply -f db.yml
kubectl apply -f phpmyadmin.yml
kubectl apply -f keycloak.yml
echo "finished build entire application"

cd ../