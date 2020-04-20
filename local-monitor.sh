#!/bin/bash
BLUE_H='\033[44m\033[30m'
RESET='\033[0m'
watch --color -n 5 -t "
date
echo
echo '$BLUE_H Pods $RESET'
kubectl get pods
echo
echo '$BLUE_H Services $RESET'
kubectl get service
echo
echo '$BLUE_H Deployments $RESET'
kubectl get deployment
echo
echo '$BLUE_H Replica Sets $RESET'
kubectl get rs
echo
echo '$BLUE_H Persistent Volumes $RESET'
kubectl get pv
echo
echo '$BLUE_H Persistent Volume Claims $RESET'
kubectl get pvc
echo
echo '$BLUE_H Secrets $RESET'
kubectl get secrets
echo
echo '$BLUE_H Minikube Services $RESET'
minikube service list
"
