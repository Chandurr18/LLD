# 🧱 Builder Pattern — HTTP Request Construction System

This example demonstrates the **Builder Design Pattern** from the *Creational Design Patterns* family using an **HTTP Request Builder** — similar to how modern frameworks (`HttpClient`, `OkHttp`, `Retrofit`) construct complex network requests.

Builder states that:

> **Separate the construction of a complex object from its representation so the same construction process can create different representations.**

---

## 🚫 Violation (Problem)

In the violation version, each `HttpRequest` requires **many constructor parameters**:

```java
HttpRequest postRequest = new HttpRequest(
    "https://api.paymentgateway.com/transactions",
    "POST",
    "{ \"amount\": 100.0, \"currency\": \"USD\" }",
    3000,
    true,
    "application/json",
    "Bearer xyz-123-token"
);
```

### ❌ Issues
- Hard to read & maintain (parameter explosion)  
- High risk of mixing up arguments  
- Poor scalability (new parameters → new constructors)  
- Violates *Open/Closed Principle* (each change forces code modification)

Consequences:
- Fragile client code  
- Reduced readability  
- Difficult debugging and testing  

---

## ✅ Builder-Compliant Solution

We create a **nested static Builder** inside `HttpRequest`, providing a clean, fluent interface:

```java
HttpRequest request = new HttpRequest.Builder("https://api.example.com", "POST")
        .header("Content-Type", "application/json")
        .header("Authorization", "Bearer abc123")
        .body("{ \"amount\": 500, \"currency\": \"USD\" }")
        .timeout(5000)
        .followRedirects(true)
        .build();
```

Responsibilities are separated:

| Concern | Implementation | Description |
|----------|----------------|-------------|
| Construction Steps | `Builder` class | Step-by-step setup |
| Final Product | `HttpRequest` | Immutable after build |
| Validation | Inside `build()` | Ensures object integrity |
| Readability | Fluent API | Natural English-like chaining |

---

## 🧩 Responsibilities Breakdown

| **Concern** | **Implementation** | **Description** |
|--------------|--------------------|------------------|
| **Product Class** | `HttpRequest` | Represents the complex immutable object being constructed (contains URL, method, headers, body, etc.) |
| **Builder Class** | `HttpRequest.Builder` | Provides step-by-step methods (`header()`, `body()`, `timeout()`, etc.) to configure and build the final `HttpRequest` object |
| **Director (Optional)** | *Not explicitly used* | Could be introduced if request creation sequences need to be standardized (e.g., “Authenticated Request Builder”) |
| **Build Method** | `build()` inside `Builder` | Validates all parameters and returns a fully constructed, thread-safe `HttpRequest` instance |
| **Client** | `Client.java` | Uses the builder API to create and execute different types of requests (GET, POST, PUT) without dealing with constructor complexity |

---

## 🧠 UML (Simplified)

![Builder UML](../../../assets/uml-images/design-patterns-uml/creational-patterns-uml/Builder.png)

---

## 🧩 Key Components

| Component | Description |
|------------|-------------|
| **Product** | `HttpRequest` — immutable request model |
| **Builder** | Nested `HttpRequest.Builder` — sets values & constructs product |
| **Client** | Application code chaining builder calls |
| **Steps** | `header()`, `body()`, `timeout()`, `followRedirects()` etc. |
| **Output** | Final configured, thread-safe `HttpRequest` instance |

---

## 🧩 Real-World Example Output

```
🚀 Sending POST request to https://api.example.com/v1/payments
Headers: {Content-Type=application/json, Authorization=Bearer abc123}
Timeout: 5000 ms
Follow Redirects: true
Body: { "amount": 500, "currency": "USD" }
✅ Request sent successfully!
```

---

## 🧩 Types of Builder Implementations

| Type | Example | Description |
|------|----------|-------------|
| **Classic Builder** | `House.Builder()` | Separate builder class; stepwise creation |
| **Nested Static Builder (Fluent)** | `HttpRequest.Builder()` | Most common in Java frameworks |
| **Director + Builder** | `ReportDirector` + `ReportBuilder` | Director orchestrates multiple steps |
| **Lombok @Builder** | Auto-generated builder via annotation | Compile-time code generation |

---

## 👌 Benefits

- ✅ Improves readability with fluent method chaining  
- ✅ Avoids telescoping constructors  
- ✅ Supports immutability & thread safety  
- ✅ Enforces construction sequence  
- ✅ Easily extendable without breaking existing code  

---

## 🧩 How It Works

1. **Client** initializes a `Builder` with required fields (`url`, `method`)  
2. Client calls setter-style methods for optional fields  
3. `build()` validates & returns an immutable `HttpRequest`  
4. Client calls `execute()` to send the configured request  

---

## 🧪 Test Output

```
🚀 Sending POST request to https://api.example.com/v1/payments
🚀 Sending GET request to https://api.example.com/v1/users
🚀 Sending PUT request to https://api.example.com/v1/settings
```

All use the **same build process** but produce **different configured objects**.

---

## 🛑 Common Interview Traps

| Trap | Explanation |
|------|--------------|
| Forgetting to make constructor `private` | Allows uncontrolled instantiation |
| Modifying builder after `build()` | Breaks immutability |
| Confusing Builder with Factory | Factory decides *what* to create, Builder decides *how* |
| Overusing Builder | Adds unnecessary complexity for simple objects |

---

## ✅ When to Use

Use Builder when:
- Object has **many optional parameters**
- Object creation needs **validation** or **custom sequence**
- You want **immutable, fluent APIs**

Avoid when:
- Object is simple (few parameters)
- Performance overhead of builder allocation matters

---

## 🏁 One-Liner Summary

> **Builder** simplifies constructing complex, immutable objects by separating the step-by-step build process from the final product representation.

---

Happy building! 🚀
