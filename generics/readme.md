## Generics 
### What are Generics?

Generics allow you to write code that works with different data types, while still being type-safe at compile time.

Instead of this ❌:
```
Object value = "Hello";
Integer number = (Integer) value; // Runtime crash
```

You do this ✅:
```
String value = "Hello";
```
Generics let the compiler protect you from type errors.

### Why Generics exist (real reasons)

**Type safety**
- Errors are caught at compile time, not runtime.

**No casting**
- Cleaner code, fewer bugs.

**Code reuse**
- One class or method works for many types.

**Readable APIs**
- You immediately know what type a class or method expects.

Core generic concepts (must-know)
1. Generic type parameter
<T>


### Common conventions:

**T** → Type

**E** → Element

**K** → Key

**V** → Value

### Generic class
```java
class Box<T> {
    private T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}
```
### Generic method
```java
public static <T> void print(T value) {
    System.out.println(value);
}
```
### Bounded generics
```java
<T extends Number>
```

Means: `only Number or its subclasses`
