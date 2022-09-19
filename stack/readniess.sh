#!/bin/bash

stat=$(kubectl get pods -n $1 -o jsonpath='{.items[*].status.containerStatuses[?(@.ready)].ready}')

echo $stat > /dev/null 2>&1

while [[ $stat != "true true" ]]
do
 if [ -z "$stat" ]
  then
    echo "no resources found"
      exit 1
  else

    kubectl get pods -n $1
    echo "waiting pods to be ready"
    echo $stat > /dev/null 2>&1
    sleep 5
    stat=$(kubectl get pods -n $1 -o jsonpath='{.items[*].status.containerStatuses[?(@.ready)].ready}')

  fi

  done
  echo "--------------------------------------------"
  echo "pods are ready ! "
  kubectl get pods -n $1
