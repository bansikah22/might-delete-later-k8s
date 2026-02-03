# Java Streams — Core Notes

## What Are Java Streams?

Java Streams are used to process collections of data in a declarative and functional style.

They allow you to:

- Filter data
- Transform data
- Sort data
- Aggregate data
- Process large datasets efficiently

## Why Streams Were Created

### Problems Before Streams

- Too many loops
- Verbose code
- Hard to parallelize
- More bugs from manual logic
- Hard to chain operations

### Goals of Streams

- Cleaner code
- Functional programming support
- Easy parallel processing
- Less mutation (safer code)
- Pipeline-style data processing

## Imperative vs Declarative

### Imperative (Old Java Style)

Focus on HOW to do something.

```java
List<String> names = new ArrayList<>();
for (User u : users) {
    if (u.age() > 18) {
        names.add(u.name());
    }
}
```

### Declarative (Streams)

Focus on WHAT you want.

```java
List<String> names =
    users.stream()
         .filter(u -> u.age() > 18)
         .map(User::name)
         .toList();
```

## Key Benefits of Streams

### Readability

Code is shorter and easier to understand.

### Functional Programming

Works with:

- Lambdas
- Method references
- Functional interfaces

### Parallel Processing

Easy multi-threading support.

```java
users.parallelStream()
```

### Less Bugs

Less manual state handling.

### Pipeline Processing

Operations can be chained.

`Filter → Map → Sort → Limit → Collect`

## Streams Are NOT Collections

**Streams:**

- Do not store data
- Cannot be reused
- Are processed once

**Streams:**

- Process data
- Transform data
- Produce results

## Stream Pipeline Structure

`Source → Intermediate Operations → Terminal Operation`

### Source

Where data comes from.

**Examples:**

- `list.stream()`
- `Arrays.stream(array)`
- `Stream.of(1,2,3)`

### Intermediate Operations

Return another stream.

**Examples:**

- `filter()`
- `map()`
- `sorted()`
- `distinct()`
- `limit()`

### Terminal Operations

Produce final result.

**Examples:**

- `forEach()`
- `collect()`
- `toList()`
- `findFirst()`
- `count()`
- `reduce()`

## Lazy Evaluation

Streams process data only when terminal operation is called.

**Example:**

```java
users.stream()
     .filter(u -> u.age() > 18)
     .map(User::name)
     .findFirst();
```

Stops when first match is found.

## Method References in Streams

**Example:**

`.map(User::name)`

**Equivalent:**

`.map(user -> user.name())`

## When To Use Streams

Use Streams when:

- Filtering collections
- Transforming data
- Aggregating values
- Processing large datasets
- Working with pipelines

## When NOT To Use Streams

Avoid Streams when:

- Complex nested logic
- Heavy mutation
- Very simple loops

## Real World Usage

Used heavily in:

- Spring Boot
- Microservices
- Data processing
- Log analysis
- API transformations

## Simple Memory Rule

If you see:

`Collection → Filter → Transform → Result`

👉 Use Streams.

## One-Line Summary

Streams allow clean, functional, and efficient processing of collections in Java.