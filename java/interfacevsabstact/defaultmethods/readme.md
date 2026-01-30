## Default methods 
Default methods are the missing puzzle piece between interfaces → lambdas → modern Java. Let’s go step by step and really understand why they exist and how to use them properly.

### PART 1: Why Default Methods Exist
**The problem before Java 8**

Imagine this interface:
```java
interface Payment {
    void pay(int amount);
}
```

Now imagine 100 classes implement it.

If you later add a new method:
```java
void refund(int amount);
```

Every implementing class breaks.

**Solution: Default methods**

Java 8 introduced default methods so interfaces can:
- Add new behavior
- Without breaking existing implementations

### PART 2: What is a Default Method?

A default method is:
- A method in an interface
- With a default implementation

**Syntax:**
```java
default void methodName() {
    // implementation
}
```
