#!/bin/bash

#openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout key  -out pem -subj "/CN=${HOST}/O=${HOST}"

#kubectl create secret tls self-signed --key key --cert pem



export KUBECONFIG=~/.kube/local-microk8s;


bash ./stack/namespace.sh $1

echo "---------------------- installing MySQL database ----------------------"
pwd


helm upgrade --debug --install  mysql  --set mysqlRootPassword=zaid,mysqlUser=zaid,mysqlPassword=zaid,mysqlDatabase=devops --namespace zdhamasha  ./stack/mysql

echo "---------------------- installing App ----------------------"

helm upgrade --debug --install app --namespace zdhamasha ./stack/person

./stack/readniess.sh $1

echo "************************************************************************"
kubectl get all -n $1
helm3 get notes mysql-$1 -n $1
helm3 get notes app-$1 -n $1

#cat ~/.kube/local-microk8s

#kubectl create ns ${CI_COMMIT_BRANCH}
#helm3 install --wait mysql  \
#   --set mysqlRootPassword=zaid,mysqlUser=root,mysqlPassword=zaid,mysqlDatabase=devops \
#   --namespace person-${CI_COMMIT_BRANCH} --debug \
#   stack/mysql

#echo ${CI_COMMIT_BRANCH}
#echo ${PSCI_COMMIT}
#echo $COMMIT
#echo $1
#
#helm3 upgrade --install --force --wait person-${CI_COMMIT_BRANCH} --namespace ${CI_COMMIT_BRANCH} --set image.tag=$1 \
#--set PSCI_BRANCH=${CI_COMMIT_BRANCH} --debug \
#person