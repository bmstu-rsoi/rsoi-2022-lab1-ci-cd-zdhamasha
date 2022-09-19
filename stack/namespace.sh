#!/bin/bash

export KUBECONFIG=~/.kube/local-microk8s

echo "----------connected to microk8s cluster----------"

echo "******check if namespace exists or not******"

kubectl get namespace $1 > /dev/null 2>&1

if [ $? -eq 0 ]
then
  echo "kubernetes namespace already exists."
else
  echo "kubernetes namespace does not exists."
  echo "creating namespace...."
  kubectl create namespace $1
  kubectl get namespace $1
fi