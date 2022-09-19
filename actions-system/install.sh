
#deploying actions to kubernetes
kubectl create -f https://github.com/actions-runner-controller/actions-runner-controller/releases/download/v0.25.2/actions-runner-controller.yaml

#create personal token then replace it here and create the secret 
kubectl create secret generic controller-manager \
    -n actions-runner-system \
    --from-literal=github_token=${GITHUB_TOKEN}
    
# remove github actions runner system    
kubectl delete -f https://github.com/actions-runner-controller/actions-runner-controller/releases/download/v0.25.2/actions-runner-controller.yaml
