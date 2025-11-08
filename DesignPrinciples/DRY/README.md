# DRY (Don't Repeat Yourself) — Reuse Logic, Reduce Duplication

> **Definition:** The DRY Principle states that every piece of knowledge must have a single, unambiguous representation in the system.  
> In simpler terms — **don’t duplicate logic or code; extract it into a reusable form.**

---

## 🚫 Common Mistake

Developers often repeat similar logic across multiple classes or methods, which leads to maintenance nightmares.

```java
// Violation: Same validation logic duplicated in multiple places
public class CustomerService {
    public boolean isValidEmail(String email) {
        return email.contains("@") && email.endsWith(".com");
    }
}

public class SupplierService {
    public boolean isValidEmail(String email) {
        return email.contains("@") && email.endsWith(".com");
    }
}
```

🔴 **Issue:** If email validation logic changes (e.g., `.org`, `.net`, etc.), every place must be updated.  
This violates **DRY**, increases maintenance overhead, and risks inconsistency.

---

## ✅ Correct Approach

Extract common logic into a **shared utility class** or **domain service**.

```java
// DRY-compliant version
public class EmailValidator {
    public static boolean isValid(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}

public class CustomerService {
    public void registerCustomer(String email) {
        if (EmailValidator.isValid(email)) {
            System.out.println("Customer registered: " + email);
        }
    }
}

public class SupplierService {
    public void registerSupplier(String email) {
        if (EmailValidator.isValid(email)) {
            System.out.println("Supplier registered: " + email);
        }
    }
}
```

✅ Now the validation logic lives in one place — **change once, reflect everywhere**.

---

## 💡 Core Idea

- **Centralize logic** that can be reused across multiple modules.  
- Duplication → Divergence → Bugs.  
- Reuse functions, constants, configurations, and validation rules.  
- Use abstraction wisely — don’t abstract too early or too much.

---

## 🧠 Real-World Analogy

Imagine two employees keeping separate copies of the same Excel sheet.  
When one updates prices, the other doesn’t — now both have inconsistent data.  
The same happens in code when logic is duplicated in multiple places.

---

## 💬 When to Apply

Use DRY when:
- The same logic, constants, or configuration appear in multiple files.  
- You need to update the same code in more than one place.  
- Different modules behave inconsistently for the same rule.

Avoid DRY when:
- The code *looks* similar but has **different reasons to change** (i.e., forcing DRY can break SRP).

---

## 🧠 Interview Angle

Common questions:
- “What is DRY and why is it important?”  
- “Give an example where violating DRY caused a bug.”  
- “When can DRY be harmful?”  

✅ **Pro Tip:** Mention that DRY should be balanced with SRP — over-deduplication can lead to tight coupling.

---

## 🏁 One-Liner Summary

> **DRY** ensures that knowledge is not scattered or duplicated, making your codebase easier to maintain, consistent, and less error-prone.

---

Happy coding! 🚀
