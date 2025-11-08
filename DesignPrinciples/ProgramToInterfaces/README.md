# Program to Interfaces — Depend on Abstractions, Not Implementations

> **Definition:** "Program to an interface, not an implementation" means that code should depend on **abstract interfaces** rather than concrete classes.  
> This reduces coupling, increases flexibility, and makes swapping implementations easier (e.g., for testing or changing providers).

This principle supports **DIP (Dependency Inversion Principle)** and is a cornerstone of maintainable, testable architectures.

---

## 🚫 Common Mistake

Developers directly instantiate and depend on concrete classes, which makes the code rigid and hard to change.

```java
// Violation: Direct dependency on concrete implementation
public class PaymentService {
    private final StripePaymentProcessor stripeProcessor = new StripePaymentProcessor();

    public void process(double amount) {
        stripeProcessor.charge(amount);
    }
}

public class StripePaymentProcessor {
    public void charge(double amount) {
        System.out.println("Charging via Stripe: " + amount);
    }
}
```

🔴 **Issue:**
- `PaymentService` is tightly coupled to `StripePaymentProcessor`.  
- Swapping to a different provider requires changing `PaymentService`.  
- Harder to unit-test `PaymentService` without real Stripe interactions.

---

## ✅ Correct Approach

Introduce an interface (abstraction) and depend on it. Use dependency injection to supply implementations.

```java
// Abstraction
public interface PaymentProcessor {
    void charge(double amount);
}

// Concrete implementations
public class StripePaymentProcessor implements PaymentProcessor {
    public void charge(double amount) {
        System.out.println("Charging via Stripe: " + amount);
    }
}

public class PaypalPaymentProcessor implements PaymentProcessor {
    public void charge(double amount) {
        System.out.println("Charging via PayPal: " + amount);
    }
}

// Consumer depends on the interface
public class PaymentService {
    private final PaymentProcessor paymentProcessor;

    public PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void process(double amount) {
        paymentProcessor.charge(amount);
    }
}

// Client code
public class ClientMain {
    public static void main(String[] args) {
        PaymentProcessor stripe = new StripePaymentProcessor();
        PaymentService service = new PaymentService(stripe);
        service.process(100.0);

        // Swap implementation easily
        PaymentProcessor paypal = new PaypalPaymentProcessor();
        PaymentService service2 = new PaymentService(paypal);
        service2.process(200.0);
    }
}
```

✅ `PaymentService` can work with any implementation of `PaymentProcessor` — making it flexible and testable.

---

## 💡 Core Idea

- Depend on **contracts** (interfaces/abstract classes) rather than concrete classes.  
- Enables **loose coupling**, easier **mocking** in tests, and simple swapping of implementations.  
- Use factories or dependency injection frameworks to assemble concrete implementations in production.

---

## 🧠 Real-World Analogy

Think of a power outlet (interface) and electrical devices (implementations). Any device that matches the outlet specification can be plugged in — the device doesn't need to know the outlet internals.

---

## 💬 When to Apply

Use this principle when:
- You expect multiple implementations (third-party providers, mock vs real).  
- You want to write unit tests without heavy integration setup.  
- You need to decouple high-level modules from low-level implementations.

Avoid over-abstraction when:
- There is truly only one reasonable implementation and no foreseeable change. (Premature abstraction adds complexity.)

---

## 🧠 Interview Angle

Common questions:
- “What does it mean to program to an interface?”  
- “How does this help testing?”  
- “Give an example where switching implementations was useful in your project.”

✅ Mention how this principle relates to **DIP** and frameworks like **Spring** that wire dependencies by interfaces.

---

## 🏁 One-Liner Summary

> **Program to interfaces** so your code depends on stable contracts — making systems flexible, testable, and resilient to change.

---

Happy coding! 🚀
