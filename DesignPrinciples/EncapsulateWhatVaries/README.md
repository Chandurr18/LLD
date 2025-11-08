# Encapsulate What Varies — Isolate Change for Stability

> **Definition:** Identify the aspects of your code that vary frequently and encapsulate them, so the rest of your system remains stable when those variations change.

This principle is foundational to many design patterns (like Strategy and Factory) and promotes **maintainability, flexibility, and scalability**.

---

## 🚫 Common Mistake

Developers often hardcode logic that’s likely to change — mixing variable behavior with stable structure.

```java
// Violation: Hardcoding discount rules inside OrderService
public class OrderService {
    public double calculateTotal(String customerType, double amount) {
        double discount = 0.0;
        if (customerType.equals("GOLD")) {
            discount = amount * 0.2;
        } else if (customerType.equals("SILVER")) {
            discount = amount * 0.1;
        }
        return amount - discount;
    }
}
```

🔴 **Issue:**  
- Adding a new customer type (e.g., PLATINUM) requires modifying this class.  
- The discount logic is **coupled** to the order calculation logic.  
- Any business rule change risks breaking stable functionality.

---

## ✅ Correct Approach

Encapsulate the varying behavior (discount rules) into separate classes and **delegate** that responsibility.

```java
// Step 1: Define the varying behavior
public interface DiscountStrategy {
    double applyDiscount(double amount);
}

// Step 2: Implement different variations
public class GoldDiscountStrategy implements DiscountStrategy {
    public double applyDiscount(double amount) { return amount * 0.2; }
}

public class SilverDiscountStrategy implements DiscountStrategy {
    public double applyDiscount(double amount) { return amount * 0.1; }
}

public class NoDiscountStrategy implements DiscountStrategy {
    public double applyDiscount(double amount) { return 0.0; }
}

// Step 3: Stable code depends on abstraction, not concrete behavior
public class OrderService {
    private final DiscountStrategy discountStrategy;

    public OrderService(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotal(double amount) {
        return amount - discountStrategy.applyDiscount(amount);
    }
}

// Step 4: Client code chooses what varies
public class ClientMain {
    public static void main(String[] args) {
        OrderService goldOrder = new OrderService(new GoldDiscountStrategy());
        System.out.println("Gold total: " + goldOrder.calculateTotal(1000));

        OrderService silverOrder = new OrderService(new SilverDiscountStrategy());
        System.out.println("Silver total: " + silverOrder.calculateTotal(1000));
    }
}
```

✅ Adding a new discount rule (e.g., Platinum) no longer affects `OrderService` — it just means adding a new class implementing `DiscountStrategy`.

---

## 💡 Core Idea

- **Encapsulate the changeable parts** of your system.  
- **Depend on abstractions**, not concrete implementations.  
- **Separate stable and unstable behavior** to minimize ripple effects.  
- **Delegate what varies** — don’t let it pollute core logic.

---

## 🧠 Real-World Analogy

In a car, the **engine** varies (diesel, petrol, electric), but the **chassis and controls** remain the same.  
You can swap engines without redesigning the entire car — that’s “encapsulating what varies.”

---

## 💬 When to Apply

Use this principle when:
- Requirements frequently change in one part of the system.  
- You have multiple variations of a behavior (payment methods, sorting strategies, pricing rules).  
- You want to reduce modification ripple effects across the codebase.

Avoid when:
- The “varying” behavior is trivial or unlikely to change. (Encapsulation adds overhead.)

---

## 🧠 Interview Angle

Common questions:
- “What does ‘encapsulate what varies’ mean?”  
- “How is it applied in the Strategy or Factory patterns?”  
- “Give an example from your project where you isolated changing behavior.”  

✅ Mention that this principle **reduces coupling**, **supports open/closed**, and **enhances flexibility**.

---

## 🏁 One-Liner Summary

> **Encapsulate What Varies** ensures that changing behavior is isolated, keeping your core system stable, testable, and adaptable.

---

Happy coding! 🚀
