# What is @FunctionalInterface?

`@FunctionalInterface` is an annotation used on an interface to indicate that:

- This interface is intended to have exactly ONE abstract method
- That’s it.

It’s a compiler-level guarantee, not magic.

## Basic example
```java
@FunctionalInterface
interface CalculatorOperation {
    int apply(int a, int b);
}
```

This interface:
- Has one abstract method
- Can be used with lambdas
- Is enforced by the compiler

## Why does @FunctionalInterface exist?
### Without the annotation
```java
interface Operation {
    int apply(int a, int b);
}
```

This works… but:
- Someone might later add another abstract method
- That would break all lambdas using it

### With @FunctionalInterface
```java
@FunctionalInterface
interface Operation {
    int apply(int a, int b);
}
```

If someone tries to add another abstract method:
```java
void reset(); // ❌
```

➡️ Compilation error
The annotation protects your design.

## Rules of a Functional Interface

An interface marked with `@FunctionalInterface`:

**✅ MUST have:**
- Exactly one abstract method

**✅ MAY have:**
- Any number of default methods
- Any number of static methods
- Methods from `Object` (toString, equals, etc.)

### Valid example
```java
@FunctionalInterface
interface Printer {

    void print(String msg); // ONE abstract method

    default void printError(String msg) {
        print("ERROR: " + msg);
    }

    static void info() {
        System.out.println("Printer interface");
    }
}
```

✔ Still functional
✔ Lambda-compatible

### ❌ Invalid example
```java
@FunctionalInterface
interface Broken {
    void a();
    void b(); // ❌ compile-time error
}
```
