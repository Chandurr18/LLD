# Favor Immutability — Make Objects That Cannot Change State

> **Definition:** Favor immutability means designing objects whose state cannot change after they are created.  
> Immutable objects are **thread-safe**, **predictable**, and **easier to reason about**.

This principle is especially important in **concurrent systems**, **functional programming**, and **data integrity–sensitive domains**.

---

## 🚫 Common Mistake

Developers often design mutable objects that can be modified by anyone, leading to unintended side effects.

```java
// Violation: Mutable class - allows external modification
public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void setBalance(double balance) {
        this.balance = balance; // ❌ Can be modified anytime
    }

    public double getBalance() {
        return balance;
    }
}
```

🔴 **Issue:**
- Any part of the program can modify the balance.  
- Leads to concurrency bugs, data corruption, and unpredictable state changes.

---

## ✅ Correct Approach

Design the class to be **immutable** — make all fields `final`, remove setters, and return new objects for updates.

```java
// Immutable version
public final class BankAccount {
    private final String accountNumber;
    private final double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Instead of modifying state, return a new object
    public BankAccount deposit(double amount) {
        return new BankAccount(accountNumber, balance + amount);
    }
}
```

✅ Now, `BankAccount` instances are immutable — thread-safe and predictable.  
Each operation returns a *new instance* instead of mutating the existing one.

---

## 💡 Core Idea

- Immutable objects **cannot be changed** once created.  
- State transitions happen by creating **new objects**, not modifying old ones.  
- Eliminates shared state issues and simplifies debugging.  
- Encourages **pure functions** and **functional style design**.

---

## 🧠 Real-World Analogy

A bank statement is **immutable** — once issued, it cannot be modified.  
If corrections are needed, a new statement is generated.  
This ensures auditability and integrity — just like immutable objects in code.

---

## 💬 When to Apply

Use immutability when:
- Working with concurrent or multi-threaded systems.  
- Data integrity is critical (finance, audit, distributed systems).  
- You want to avoid side effects and shared mutable state.

Avoid when:
- Object creation cost is extremely high, and mutation is cheaper (like in tight loops).  
- Performance-critical systems where immutability creates too many temporary objects.

---

## 🧠 Interview Angle

Common questions:
- “What are the benefits of immutability?”  
- “How do you make a class immutable in Java?”  
- “Why are immutable objects thread-safe?”  
- “Give examples of immutable classes in Java.”  

✅ Mention that **String**, **Integer**, **LocalDate**, and **BigDecimal** are immutable in Java.  
Also note that immutability helps in designing **pure functions** and **stateless architectures**.

---

## 🏁 One-Liner Summary

> **Favor Immutability** ensures that once created, objects remain consistent and predictable — improving safety, thread-safety, and maintainability.

---

Happy coding! 🚀