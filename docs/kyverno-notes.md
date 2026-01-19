# Kyverno Learning Notes

Kyverno is a policy engine designed for Kubernetes. It allows you to manage configurations as policies without writing complex code.

## 1. Installation

Based on official documentation, Kyverno can be installed using Helm or a standalone YAML manifest.

### Standalone Manifest (Used in this session)
```bash
kubectl create -f https://github.com/kyverno/kyverno/releases/download/v1.11.1/install.yaml
```

## 2. Core Concepts

- **ClusterPolicy**: A cluster-wide resource that applies to all namespaces.
- **Policy**: A namespaced resource that applies only to the namespace where it is created.
- **Rules**: The building blocks of a policy. A rule consists of:
    - **Match**: Defines which resources the rule applies to (e.g., Pods, Services).
    - **Exclude**: Optional field to skip certain resources.
    - **Actions**:
        - **Validate**: Checks if a resource meets specific criteria and blocks it if it doesn't.
        - **Mutate**: Modifies a resource during creation or update (e.g., adding labels).
        - **Generate**: Creates additional resources when a specific resource is created.
        - **VerifyImages**: Verifies image signatures using Cosign.

## 3. Hands-on Examples

### Validation: Require Owner Label
File: `k8s/kyverno-require-owner-label.yaml`
This policy ensures every Pod has an `owner` label. If missing, the creation is blocked.

### Mutation: Add Team Label
File: `k8s/kyverno-mutate-team-label.yaml`
This policy automatically injects `team: devops` into any Pod created in the cluster.

## 4. Useful Commands

- Check policies: `kubectl get cpol` (ClusterPolicies) or `kubectl get pol` (Policies).
- Check policy reports: `kubectl get polr` (Policy Reports) or `kubectl get cpolr` (Cluster Policy Reports).
- Debug Kyverno: `kubectl logs -n kyverno -l app.kubernetes.io/instance=kyverno`.
