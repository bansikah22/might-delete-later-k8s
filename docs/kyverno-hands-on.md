# Kyverno Step-by-Step Hands-on Guide

This guide provides a step-by-step walkthrough of installing Kyverno and applying policies for validation and mutation.

## 1. Installation

Install Kyverno in your cluster using the official manifest:

```bash
kubectl create -f https://github.com/kyverno/kyverno/releases/download/v1.11.1/install.yaml
```

**What to expect:**
- You will see several resources created (CRDs, ServiceAccounts, Deployments).
- Run `kubectl get pods -n kyverno` to ensure all pods are `Running`.

## 2. Validation Policy: Enforce Labels

This policy blocks any Pod that does not have an `owner` label.

### The Policy Manifest
File: `k8s/kyverno-require-owner-label.yaml`
```yaml
apiVersion: kyverno.io/v1
kind: ClusterPolicy
metadata:
  name: require-labels
spec:
  validationFailureAction: Enforce
  background: true
  rules:
  - name: check-for-labels
    match:
      any:
      - resources:
          kinds:
          - Pod
    validate:
      message: "The label 'owner' is required for all Pods."
      pattern:
        metadata:
          labels:
            owner: "?*"
```

### Application Step
1. Apply the policy:
   ```bash
   kubectl apply -f k8s/kyverno-require-owner-label.yaml
   ```

2. Test with a non-compliant pod (missing label):
   ```bash
   kubectl run test-fail --image=nginx
   ```
   **Expectation:** The command will fail with an error: `validation error: The label 'owner' is required for all Pods.`

3. Test with a compliant pod:
   ```bash
   kubectl run test-pass --image=nginx --labels=owner=developer
   ```
   **Expectation:** The pod will be created successfully.

## 3. Mutation Policy: Auto-Inject Labels

This policy automatically adds a `team: devops` label to any new Pod.

### The Policy Manifest
File: `k8s/kyverno-mutate-team-label.yaml`
```yaml
apiVersion: kyverno.io/v1
kind: ClusterPolicy
metadata:
  name: add-team-label
spec:
  rules:
  - name: add-team
    match:
      any:
      - resources:
          kinds:
          - Pod
    mutate:
      patchStrategicMerge:
        metadata:
          labels:
            team: "devops"
```

### Application Step
1. Apply the policy:
   ```bash
   kubectl apply -f k8s/kyverno-mutate-team-label.yaml
   ```

2. Create a pod (only providing the required `owner` label):
   ```bash
   kubectl run test-mutate --image=nginx --labels=owner=developer
   ```

3. Verify the mutation:
   ```bash
   kubectl get pod test-mutate --show-labels
   ```
   **Expectation:** You will see both `owner=developer` and `team=devops` in the labels, even though you didn't specify `team`.

## 4. Cleaning Up
To remove the policies:
```bash
kubectl delete -f k8s/kyverno-require-owner-label.yaml
kubectl delete -f k8s/kyverno-mutate-team-label.yaml
```
