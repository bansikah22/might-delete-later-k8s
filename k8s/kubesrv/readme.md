```
# Apply a deployment manifest
kubectl apply -f deployment.yaml

# Check deployment status
kubectl get deploy -n kubesrv-ns

# Rollout restart deployment
kubectl rollout restart deployment kubesrv -n kubesrv-ns

# Apply resources using kustomize
kubectl apply -k .

# Delete all resources managed by kustomize
kubectl delete -k .

```