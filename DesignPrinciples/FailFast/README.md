# Fail Fast — Detect Problems Early, Not Late

> **Definition:** The *Fail Fast* principle states that a system should detect and report errors **as soon as they occur**, rather than allowing them to propagate and cause unpredictable behavior later.

Fail fast systems are **easier to debug, safer to maintain**, and **more reliable in production**.

---

## 🚫 Common Mistake

Developers often let failures go unnoticed — leading to silent bugs, corrupted data, or undefined system states.

```java
// Violation: Failing silently
public class PaymentProcessor {
    public void processPayment(String cardNumber, double amount) {
        if (cardNumber == null) return; // Silent failure 😬
        // Continue processing...
        System.out.println("Processing payment for card: " + cardNumber);
    }
}
```

🔴 **Issue:**
- The method silently ignores an invalid state.
- Downstream systems assume success.
- Failures are discovered much later, making debugging harder.

---

## ✅ Correct Approach

Fail early, fail clearly, fail loudly.

```java
// Fail Fast Example
public class PaymentProcessor {
    public void processPayment(String cardNumber, double amount) {
        if (cardNumber == null || cardNumber.isEmpty()) {
            throw new IllegalArgumentException("Card number cannot be null or empty.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive.");
        }

        System.out.println("Processing payment for card: " + cardNumber);
    }
}
```

✅ The code immediately rejects invalid input, preventing undefined behavior later in execution.

---

## 💡 Core Idea

- Detect problems **as close to their source** as possible.  
- **Validate assumptions early** — don’t trust external input blindly.  
- **Throw meaningful exceptions** instead of silently ignoring them.  
- Makes debugging, monitoring, and recovery **simpler and faster**.

---

## 🧠 Real-World Analogy

In aviation, pre-flight checks detect issues before takeoff — not mid-air.  
Failing fast in software is the same: it ensures problems are found **before they crash the system**.

---

## 💬 When to Apply

Use *Fail Fast* when:
- Handling critical operations (payments, transactions, data integrity).  
- Accepting user input or external data.  
- Developing APIs or service contracts.

Avoid when:
- In temporary or retryable scenarios (use **Fail Safe** or **Retry** patterns instead).  
- When failures are expected and recoverable.

---

## 🧠 Interview Angle

Common questions:
- “What is the Fail Fast principle?”  
- “How is it different from defensive programming?”  
- “Why do fail-fast systems improve reliability?”  
- “Can you give an example of fail-fast design in a large system?”

✅ Mention that **Java’s Collections Framework** is designed as fail-fast — iterators throw `ConcurrentModificationException` immediately when a collection is modified during iteration.

---

## 🏁 One-Liner Summary

> **Fail Fast** systems detect and report errors immediately, preventing hidden bugs, reducing complexity, and improving reliability.

---

Happy coding! 🚀
