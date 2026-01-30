# Interfaces vs Abstract Classes (Core Theory)
### What is an Interface?

An interface defines **WHAT** a class can do, not **HOW** it does it.

>Think of it as a contract.
```java
interface Animal {
    void makeSound();
}
```

Any class that implements this must provide an implementation.

**Key points about interfaces**
- Methods are abstract by default
- Fields are public static final (constants)
- A class can implement multiple interfaces
- Cannot have instance state (no normal fields)

### What is an Abstract Class?

An abstract class is a partial implementation.
```java
abstract class Vehicle {
    abstract void move();

    void startEngine() {
        System.out.println("Engine started");
    }
}
```

**Key points about abstract classes**
- Can have abstract and concrete methods
- Can have instance variables
- A class can extend only one abstract class
- Used when classes share common behavior + state

### When to use which?
**Use interface when:**
- You want to define a capability
- You want multiple inheritance
- You plan to use lambdas later
- Example: Runnable, Comparable, Payment

**Use abstract class when:**
- You share code + state
- Classes are closely related
- You want protected fields or base logic
