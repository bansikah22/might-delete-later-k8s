# 🚀 STAGE 1 — OOP (From Foundation → Real Usage)

## 🧠 1️⃣ Why OOP Was Created

Before OOP, programs were mostly procedural (step-by-step instructions).
As software grew, code became:

- Hard to maintain
- Hard to scale
- Hard to reuse

👉 OOP was created to model real-world objects and manage complexity.

---

## 🏛️ 2️⃣ The 4 Pillars of OOP (Core Foundation)

### 🔐 Encapsulation

- ➡ Hide internal data
- ➡ Control access through methods

**Why?**

- Protects data
- Prevents bugs
- Allows internal changes without breaking external code

**Getters/setters help encapsulation because they:**

- Hide internal data structure
- Allow validation or extra logic later
- Keep public interface stable even if implementation changes

---

### 🧬 Inheritance

- ➡ Reuse code from another class

**Example:**

`Vehicle` → `Car` → `ElectricCar`

Child classes inherit fields + behavior and can extend them.

---

### 🎭 Polymorphism

- ➡ Same method name → Different behavior

**Types:**

- **Method Overloading** → Same method, different parameters
- **Method Overriding** → Child replaces parent behavior

---

### 🎨 Abstraction

- ➡ Show only important details
- ➡ Hide complexity

**Example:**
You drive a car without knowing engine internals.

---

## 🧱 3️⃣ Core OOP Building Blocks (VERY IMPORTANT)

### 🏗️ Class

Blueprint for objects.

```java
class Car {
   String model;
}
```

### 📦 Object

Instance of a class.

```java
Car c1 = new Car();
```

### 🏗️ Constructor — WHY It Exists

- 👉 Runs when object is created
- 👉 Ensures object starts in valid state

**Example:**

```java
User(String name) {
   this.name = name;
}
```

**💡 Real reason:**

- Guarantees required data exists
- Prevents invalid objects
- Central place for validation

---

### 🔐 Getters and Setters — WHY Not Public Fields?

Instead of:

```java
public int age;
```

We do:

```java
private int age;

public int getAge() { return age; }
public void setAge(int age) { this.age = age; }
```

**Real Reasons:**

- ✅ Encapsulation
- ✅ Add validation later
- ✅ Change internal representation safely
- ✅ Control access levels

---

### 🧪 Real World Thinking

**❌ Without Getter/Setter**

If you change field → break entire app.

**✅ With Getter/Setter**

Change logic in one place → app still works.

---

## 🧠 4️⃣ Access Modifiers (Security Layer)

| Modifier  | Access                |
| --------- | --------------------- |
| `private`   | Only inside class     |
| `default`   | Package only          |
| `protected` | Package + subclasses  |
| `public`    | Everywhere            |

---

## 🔥 5️⃣ Why Companies Still Use OOP Today

Because it:

- Organizes large codebases
- Makes teams work independently
- Enables reusable libraries
- Helps testing & maintenance

---

### 💡 Real Example — Banking App Thinking

- **Encapsulation** → Hide balance
- **Inheritance** → `SavingsAccount` extends `Account`
- **Polymorphism** → Different `withdraw` rules
- **Abstraction** → User only sees ATM interface
