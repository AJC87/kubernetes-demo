#!/bin/bash

minikube start

minikube addons enable ingress

eval $(minikube docker-env)

docker build -t talk-booker-back-end back-end
docker build -t talk-booker-front-end front-end

kubectl apply --recursive -f back-end/k8s
kubectl apply --recursive -f front-end/k8s
