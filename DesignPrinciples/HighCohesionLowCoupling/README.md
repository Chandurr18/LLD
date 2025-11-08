# High Cohesion & Low Coupling — Build Focused and Independent Modules

> **Definition:** 
> - **High Cohesion**: A class or module should have a focused, well-defined purpose where all elements work together toward a single goal.  
> - **Low Coupling**: Modules should depend on each other as little as possible. Each component should be easy to modify or replace without impacting others.

Together, they form the foundation of **modular, maintainable, and scalable** software design.

---

## 🚫 Common Mistake

Developers often build classes that handle too many unrelated responsibilities, and they tightly connect modules through direct dependencies.

```java
// Violation: Low cohesion and high coupling
public class OrderManager {
    private EmailService emailService = new EmailService();
    private Database database = new Database();

    public void createOrder(String productId, int qty) {
        database.saveOrder(productId, qty);
        emailService.sendEmail("Order created for product: " + productId);
    }

    public void sendReport() {
        emailService.sendEmail("Daily Sales Report...");
    }
}

class EmailService {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}

class Database {
    public void saveOrder(String productId, int qty) {
        System.out.println("Saving order to DB...");
    }
}
```

🔴 **Issue:**
- `OrderManager` handles **order creation**, **reporting**, and **notifications** — violating cohesion.
- It also creates and manages concrete dependencies — **tightly coupled**.
- Changing email logic or database details requires modifying `OrderManager`.

---

## ✅ Correct Approach

Encapsulate related behaviors and decouple modules through abstractions or dependency injection.

```java
// High Cohesion & Low Coupling version

// 1️⃣ Focused components
public interface NotificationService {
    void send(String message);
}

public class EmailNotificationService implements NotificationService {
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

public interface OrderRepository {
    void save(String productId, int qty);
}

public class DatabaseOrderRepository implements OrderRepository {
    public void save(String productId, int qty) {
        System.out.println("Order saved in DB.");
    }
}

// 2️⃣ Coordinating class focuses on its core responsibility
public class OrderService {
    private final OrderRepository orderRepository;
    private final NotificationService notificationService;

    public OrderService(OrderRepository orderRepository, NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    public void createOrder(String productId, int qty) {
        orderRepository.save(productId, qty);
        notificationService.send("Order created successfully for: " + productId);
    }
}

// 3️⃣ Client code composes dependencies
public class ClientMain {
    public static void main(String[] args) {
        OrderRepository repo = new DatabaseOrderRepository();
        NotificationService emailService = new EmailNotificationService();
        OrderService orderService = new OrderService(repo, emailService);

        orderService.createOrder("P-101", 5);
    }
}
```

✅ `OrderService` now has **high cohesion** (focuses only on order-related operations).  
✅ It also has **low coupling** (depends on abstractions, not concrete implementations).

---

## 💡 Core Idea

- **High Cohesion**: Keep related logic together and unrelated logic apart.  
- **Low Coupling**: Reduce interdependency between components.  
- Makes systems **easier to understand, maintain, test, and extend**.  
- Achieved via **abstraction**, **interfaces**, and **dependency injection**.

---

## 🧠 Real-World Analogy

In a restaurant:
- **High Cohesion**: The chef cooks, the waiter serves, the cashier handles payment. Each has a single responsibility.  
- **Low Coupling**: If the chef changes, the waiter doesn’t need to relearn cooking — they communicate through a simple “order ticket” interface.

---

## 💬 When to Apply

Use **High Cohesion** and **Low Coupling** when:
- Code is growing and responsibilities are blending together.  
- Modifications in one class frequently break others.  
- Testing one component requires setting up many others.  

Avoid over-abstraction — balance simplicity with decoupling.

---

## 🧠 Interview Angle

Common questions:
- “What is the difference between high cohesion and low coupling?”  
- “Can you achieve one without the other?”  
- “Give a real-world example or code snippet showing both.”  
- “How do SOLID principles help achieve this?”  

✅ Mention that **SRP** improves cohesion, and **DIP/OCP** reduce coupling.

---

## 🏁 One-Liner Summary

> **High Cohesion** keeps related logic together; **Low Coupling** keeps modules independent — together, they create clean, modular, and maintainable systems.

---

Happy coding! 🚀
