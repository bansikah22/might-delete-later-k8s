# Built-in Functional Interfaces (java.util.function)

Java gives us ready-made functional interfaces, so we don’t have to create our own every time.

The big four you’ll use 90% of the time are:

1.  **Predicate**
2.  **Function**
3.  **Consumer**
4.  **Supplier**

They all have exactly one abstract method (that’s why they work with lambdas).

## 1. Predicate<T> → Test something
**Definition**
```java
boolean test(T t);
```
**Meaning**
-   Takes one input
-   Returns `true` or `false`

**Example**
```java
Predicate<Integer> isAdult = age -> age >= 18;

System.out.println(isAdult.test(20)); // true
System.out.println(isAdult.test(15)); // false
```
**Real-world use**
-   Validate input
-   Filter collections
-   Check conditions

**Very common usage (with streams)**
```java
List<Integer> numbers = List.of(10, 20, 30, 5);

numbers.stream()
       .filter(n -> n > 15)
       .forEach(System.out::println);
```

🔑 **Mental model:** “Should I keep this or not?”

## 2. Function<T, R> → Transform something
**Definition**
```java
R apply(T t);
```
**Meaning**
-   Takes one input (T)
-   Returns a different result (R)

**Example**
```java
Function<String, Integer> lengthFunction = str -> str.length();

System.out.println(lengthFunction.apply("Java")); // 4
```
**Real-world use**
-   Convert data
-   Map one object to another
-   DTO → Entity conversion

**With streams**
```java
List<String> names = List.of("Alice", "Bob");

names.stream()
     .map(String::length)
     .forEach(System.out::println);
```

🔑 **Mental model:** “Turn this into something else”

## 3. Consumer<T> → Use something, return nothing
**Definition**
```java
void accept(T t);
```
**Meaning**
-   Takes one input
-   Returns nothing

**Example**
```java
Consumer<String> printer = msg -> System.out.println(msg);

printer.accept("Hello Lambda");
```
**Real-world use**
-   Logging
-   Printing
-   Sending data somewhere (email, DB, API)

**With streams**
```java
List<String> names = List.of("Alice", "Bob");

names.forEach(name -> System.out.println(name));
```

🔑 **Mental model:** “Just do something with it”

## 4. Supplier<T> → Provide something
**Definition**
```java
T get();
```
**Meaning**
-   No input
-   Returns a value

**Example**
```java
Supplier<Double> randomValue = () -> Math.random();

System.out.println(randomValue.get());
```
**Real-world use**
-   Lazy object creation
-   Default values
-   Generating IDs, tokens, timestamps

**Example**
```java
Supplier<String> uuidSupplier = () -> UUID.randomUUID().toString();

System.out.println(uuidSupplier.get());
```

🔑 **Mental model:** “Give me something”

## Summary Table
| Interface     | Takes Input | Returns | Typical Use     |
| :------------ | :---------- | :------ | :-------------- |
| Predicate<T>  | T           | boolean | Check condition |
| Function<T,R> | T           | R       | Transform       |
| Consumer<T>   | T           | void    | Perform action  |
| Supplier<T>   | none        | T       | Provide value   |

## How this connects to Lambdas
When you write:
```java
x -> x > 10
```
Java knows:
-   Takes one input
-   Returns boolean
-   👉 **Predicate**

When you write:
```java
x -> x * 2
```
-   👉 **Function**

When you write:
```java
x -> System.out.println(x)
```
-   👉 **Consumer**

When you write:
```java
() -> Math.random()
```
-   👉 **Supplier**

## Mini Practice (Try mentally)
1.  **Which interface?**
    ```java
    name -> name.isEmpty()
    ```
2.  **Which interface?**
    ```java
    price -> price * 0.9
    ```
3.  **Which interface?**
    ```java
    order -> saveToDatabase(order)
    ```
4.  **Which interface?**
    ```java
    () -> LocalDate.now()
    ```
