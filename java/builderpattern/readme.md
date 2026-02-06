# 🏗️ Builder Pattern — Little Notes

## 🧠 What is the Builder Pattern?

👉 **Builder Pattern** = A way to construct complex objects step by step.

Instead of having a constructor with many parameters:
- ❌ `new Server("name", "ip", 8080, "user", "pass", true, false)`

We use a `Builder` to make it readable:
- ✅ `new Server.Builder().name("name").ip("ip").port(8080).build()`

---

### 🧾 Plain English

The Builder pattern is like ordering a custom pizza. You tell the chef what toppings you want one by one, and when you're done, the chef gives you the pizza. You don't have to tell the chef all the toppings at once.

---

## 🎯 Why Was the Builder Pattern Created?

### 1️⃣ To Avoid "Telescoping Constructors"
This is when you have many constructors with different parameters, and it gets messy.
```java
// Telescoping constructors - BAD
public Server(String name) { ... }
public Server(String name, String ip) { ... }
public Server(String name, String ip, int port) { ... }
```

### 2️⃣ To Improve Readability
It's much easier to see what each parameter is for when you use the builder.
```java
// Hard to read
new Server("my-server", "127.0.0.1", 8080, "admin", "password", true, false);

// Easy to read
new Server.Builder()
    .name("my-server")
    .ip("127.0.0.1")
    .port(8080)
    .username("admin")
    .password("password")
    .useTls(true)
    .useCompression(false)
    .build();
```

### 3️⃣ To Allow for Optional Parameters
You can set only the parameters you need and the builder will use default values for the rest.

### 4️⃣ To Create Immutable Objects
The `build()` method can create an immutable object, which is great for safety.

---

## ⭐ Why YOU Need the Builder Pattern (Real Dev View)

You'll use it when:
- You have a class with many attributes.
- Some attributes are optional.
- You want to create immutable objects.
- You want to improve the readability of your code.

---

## 🧩 Core Components You Must Know

### 1️⃣ The Main Class
The class you want to build (e.g., `Server`). It has a private constructor to force the use of the builder.

### 2️⃣ The Static Nested Builder Class
This class has the same fields as the main class and is used to set the values.

### 3️⃣ The `build()` Method
This method in the `Builder` class returns a new instance of the main class.

---

## 🔥 Golden Rule (Senior Dev Thinking)

👉 Use the **Builder Pattern** when you have more than a few optional parameters for an object.
👉 It's a great way to make your code more maintainable and easier to read for other developers.
