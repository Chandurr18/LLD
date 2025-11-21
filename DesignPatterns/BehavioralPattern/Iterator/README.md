# Iterator Pattern — Order Processing System

This example demonstrates the **Iterator Design Pattern** from the **Behavioral Patterns** family using an *order retrieval and traversal scenario*.

Iterator states that:

> **Provide a way to access elements of an aggregate object sequentially without exposing its internal representation.**

In simple terms:  
➡️ The client can traverse a collection (list, tree, paginated data) **without knowing how the data is stored** or how traversal is implemented internally.

---

## 🚫 Violation (Problem)

In the naive approach, clients directly access the internal `List<Order>` inside an `OrderRepository`.

Example:

```java
List<Order> orders = orderRepository.orders; // directly exposed list
for (int i = 0; i < orders.size(); i++) {
    ...
}
```

This causes:

- ❌ Tight coupling to the internal representation  
- ❌ Violates **Encapsulation** — internal list is exposed  
- ❌ If internal structure changes (array → linked list → API call), all clients break  
- ❌ Duplicate traversal logic across services  
- ❌ Hard to create custom traversal (pagination, filtering, batching)  

This is a **classic violation** that the Iterator pattern solves.

---

## ✅ Iterator-Compliant Solution

We introduce:

| Concern | Implementation | Description |
|--------|----------------|-------------|
| Aggregate Interface | `OrderCollection` | Declares `iterator()` |
| Iterator Interface | `OrderIterator` | Declares traversal methods |
| Concrete Aggregate | `DatabaseOrderRepository` | Stores orders and creates iterator |
| Concrete Iterator | `OrderListIterator` | Sequentially iterates list-backed repository |
| Variant Iterator | `PaginatedOrderIterator` | Fetches orders in batches (simulated) |
| Client | `Client.java` | Traverses orders without knowing internal structure |

This design ensures:

- Order collection internals remain hidden  
- New traversal strategies → simply create new iterator implementations  
- Clean separation of concerns  
- Extensibility without modifying client code (**OCP**)  

---

## 🧠 UML Reference

### Class Diagram  
![Iterator](../../../assets/uml-images/design-patterns-uml/Behavioral-patterns-uml/Iterator.png)

---

## 👌 Benefits of This Design

- ✅ Preserves encapsulation  
- ✅ Supports multiple independent traversals  
- ✅ Easy to implement custom iteration (pagination, filtering, reverse order)  
- ✅ Improves testability (mock iterators)  
- ✅ Adheres to **Single Responsibility** and **Open/Closed Principle**  

---

## 📦 How It Works

`Client.java`:

1. Gets `OrderCollection orderCollection = new DatabaseOrderRepository();`
2. Retrieves iterator via `orderCollection.iterator()`
3. Calls:

```
while (iterator.hasNext()) {
    Order order = iterator.next();
}
```

4. Internally, iterator maintains its own traversal state  
5. Client never interacts with internal List/DB/API structure  

---

## 🧪 Sample Output (Console)

```
Fetching sequential orders via OrderListIterator...
Order{id=ORD-101, amount=2500.0}
Order{id=ORD-102, amount=5400.0}
Order{id=ORD-103, amount=1200.0}

Fetching orders via PaginatedOrderIterator...
[PAGE 1]
Order{id=ORD-201, amount=3000.0}
Order{id=ORD-202, amount=4100.0}
[PAGE 2]
Order{id=ORD-203, amount=1500.0}
Order{id=ORD-204, amount=2200.0}
```

---

## 🛑 Common Interview Traps

- ❌ Thinking Iterator is for *object creation* (confusing with Factory Pattern)  
- ❌ Not understanding **external vs internal** iteration  
- ❌ Ignoring concurrency semantics (fail-fast vs fail-safe)  
- ❌ Thinking all iterators are sequential (tree/graph iterators exist)  
- ❌ Forgetting `iterator()` must return a **new** iterator per call  

---

## ✅ When to Use

Use Iterator Pattern when:

- You want to hide complex collection internals  
- You need multiple customizable traversal strategies  
- You need lazy traversal (pagination, streaming, batching)  
- You want to separate traversal logic from the collection itself  

Avoid when:

- You only need simple indexing or foreach loops  
- Java Streams provide a better abstraction  
- Traversal must be domain-specific (e.g., "process next order only if pending")  

---

## 🏁 One-Liner Summary

> Iterator Pattern decouples traversal from data structure, enabling safe, flexible, and extensible access to collection elements.

---

