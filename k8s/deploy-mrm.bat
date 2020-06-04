
kubectl config use-context docker-desktop


kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/master/deploy/static/provider/cloud/deploy.yaml

kubectl apply  -f k8s\namespace.yaml

kubectl apply  -f k8s\deployment-mrm-db.yaml
kubectl apply  -f k8s\deployment-mrm-api.yaml
kubectl apply  -f k8s\deployment-mrm-adminer.yaml

kubectl apply  -f k8s\service-mrm-db.yaml
kubectl apply  -f k8s\service-mrm-api.yaml
kubectl apply  -f k8s\service-mrm-adminer.yaml

kubectl apply  -f k8s\ingress-mrm.yaml