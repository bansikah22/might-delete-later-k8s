# Markdown Notes — Java Optional Basics

## What Is Optional?

Optional is a container that:

- May contain a value
- May be empty

It helps avoid:

- `NullPointerException`
- Manual null checks

## Why Optional Was Created

Before `Optional`:

- Many null checks
- Risk of runtime crashes
- Hard to chain operations

`Optional` provides:
- Safer code
- Functional style
- Cleaner logic

## Optional Mental Model

`Optional<Value> = Maybe there is a value`

## Creating Optional

### With Value

```java
Optional<String> name = Optional.of("Alice");
```

Cannot be `null`.

### Nullable Value

```java
Optional<String> name = Optional.ofNullable(value);
```

### Empty Optional

```java
Optional<String> name = Optional.empty();
```

## Reading Optional Safely

### ifPresent()

Runs code only if value exists.

```java
optional.ifPresent(value -> System.out.println(value));
```

### orElse()

Default value if empty.

```java
String name = optional.orElse("Unknown");
```

### orElseGet()

Lazy default value.

```java
optional.orElseGet(() -> generateValue());
```

### orElseThrow()

Throw exception if empty.

```java
optional.orElseThrow();
```

## Transforming Optional

### map()

Transforms inside `Optional`.

```java
optional.map(User::name);
```

## Optional + Streams

Streams often return `Optional`.

```java
users.stream()
     .findFirst();
```

## Optional Best Practices

- Avoid `get()` -> `optional.get();` is risky
- Don’t Use `Optional` In Fields

**Bad:**

```java
class User {
    Optional<String> name;
}
```

- Use `Optional` For Return Types

**Good:**

```java
Optional<User> findUserById(String id);
```

## Real World Usage

`Optional` is used in:

- Spring Boot repositories
- API responses
- Database lookups
- Stream results

## Simple Memory Rule

`Optional` = Safe way to handle missing values

## One-Line Summary

`Optional` is a safe wrapper that helps avoid null errors using functional operations.

### Ultra Simple Memory Example

- `Optional` = Safe Box
- `ifPresent` = If box not empty → use value
- `map` = Change value inside box
- `orElse` = Give default if box empty
