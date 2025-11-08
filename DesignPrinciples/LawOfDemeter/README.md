# Law of Demeter — Talk Only to Your Immediate Friends

> **Definition:** The *Law of Demeter (LoD)*, also known as the *Principle of Least Knowledge*, states that a class should only interact with its **direct collaborators** — not the internal details of others.  
> In short: **“Don’t talk to strangers.”**

This promotes **loose coupling**, **encapsulation**, and **clean dependency boundaries**.

---

## 🚫 Common Mistake

Developers often chain calls across multiple objects, reaching deep into other classes’ internals.

```java
// Violation: Chained calls violating Law of Demeter
public class OrderService {
    public void processOrder(Order order) {
        String city = order.getCustomer().getAddress().getCity(); // ❌ Too much knowledge!
        System.out.println("Processing order for city: " + city);
    }
}

class Order {
    private Customer customer;
    public Order(Customer customer) { this.customer = customer; }
    public Customer getCustomer() { return customer; }
}

class Customer {
    private Address address;
    public Customer(Address address) { this.address = address; }
    public Address getAddress() { return address; }
}

class Address {
    private String city;
    public Address(String city) { this.city = city; }
    public String getCity() { return city; }
}
```

🔴 **Issue:**
- `OrderService` knows too much about how to access the city.  
- Any change in `Customer` or `Address` structure breaks `OrderService`.  
- This violates **encapsulation** and increases **coupling**.

---

## ✅ Correct Approach

Delegate the responsibility to the object that owns the data.

```java
// Law of Demeter compliant
public class OrderService {
    public void processOrder(Order order) {
        String city = order.getDeliveryCity(); // ✅ Talk only to direct friend
        System.out.println("Processing order for city: " + city);
    }
}

class Order {
    private Customer customer;
    public Order(Customer customer) { this.customer = customer; }

    public String getDeliveryCity() {
        return customer.getDeliveryCity(); // Delegation handled here
    }
}

class Customer {
    private Address address;
    public Customer(Address address) { this.address = address; }

    public String getDeliveryCity() {
        return address.getCity(); // Direct access within own boundary
    }
}

class Address {
    private String city;
    public Address(String city) { this.city = city; }
    public String getCity() { return city; }
}
```

✅ Each class now communicates only with its **immediate collaborators** — not with their collaborators’ internals.

---

## 💡 Core Idea

- An object should only call methods of:
  1. Itself  
  2. Its own fields (direct components)  
  3. Method parameters  
  4. Objects it creates  
- Avoid **method chaining** that digs through multiple levels.  
- Promotes **encapsulation** and **low coupling**.  

---

## 🧠 Real-World Analogy

When you order food, you talk to the waiter — not directly to the chef or the supplier.  
The waiter (your immediate collaborator) handles the communication chain behind the scenes.  
That’s how the *Law of Demeter* works in software.

---

## 💬 When to Apply

Use LoD when:
- You see multiple chained calls like `obj.getX().getY().getZ()`  
- Changes in one class often require changing multiple others  
- You want to improve encapsulation and reduce dependency chains  

Avoid when:
- The chaining is purely fluent API design (like Builders) where each method returns the same object intentionally.

---

## 🧠 Interview Angle

Common questions:
- “What is the Law of Demeter?”  
- “Why is it also called the Principle of Least Knowledge?”  
- “How does it help reduce coupling?”  
- “Give an example where violating LoD caused tight coupling.”  

✅ Mention that frameworks like **Spring** and **DDD architectures** follow this principle by keeping interactions between **aggregates** minimal and controlled.

---

## 🏁 One-Liner Summary

> **Law of Demeter** ensures that classes communicate only with their direct collaborators, reducing coupling and protecting encapsulation.

---

Happy coding! 🚀
