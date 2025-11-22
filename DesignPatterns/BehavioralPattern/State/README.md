# State Pattern — Payment Transaction Example

This example demonstrates the **State Design Pattern** from the **Behavioral Patterns** family using a *payment transaction lifecycle* scenario.

State states that:

> **Allow an object to alter its behavior when its internal state changes. The object will appear to change its class.**

In simple terms:  
➡️ A `PaymentTransaction` delegates state-specific behavior (process, cancel, refund) to state objects representing lifecycle stages (Pending, Processing, Completed, Failed, Refund).  
➡️ When the internal state changes, the behavior changes automatically.

---

## 🚫 Violation (Problem)

A naive implementation uses `if/else` or `switch` based on enums:

```java
if (status == Status.PENDING) { ... }
else if (status == Status.PROCESSING) { ... }
else if (status == Status.COMPLETED) { ... }
```

This causes:

- ❌ Massive conditional complexity  
- ❌ Violates Open/Closed Principle  
- ❌ Hard to extend lifecycle (refunds, chargebacks)  
- ❌ Logic duplicated in multiple places  
- ❌ Clients must know transition rules  

The State Pattern eliminates this.

---

## ✅ State-Compliant Solution

We introduce:

| Concern | Implementation | Description |
|--------|----------------|-------------|
| Context | `PaymentTransaction` | Holds current state and delegates workflow |
| State interface | `PaymentState` | Defines `process()`, `cancel()`, `refund()` |
| Concrete States | `PendingState`, `ProcessingState`, `CompletedState`, `FailedState`, `RefundState` | State-specific behavior |
| Client | `Client.java` | Interacts with the context, not with state logic |

This ensures:

- No conditionals  
- Behavior polymorphism  
- Safe, maintainable state transitions  
- Strong SRP & OCP adherence  

---

## 🧠 UML Reference
![State](../../../assets/uml-images/design-patterns-uml/Behavioral-patterns-uml/State.png)

---

## 👌 Benefits of This Design

- ✅ No giant if-else blocks  
- ✅ State transitions handled by states themselves  
- ✅ Easy to add new lifecycle states  
- ✅ Behavior encapsulated inside state classes  
- ✅ High testability and modularity  

---

## 📦 How It Works

1. `PaymentTransaction` starts in `PendingState`.  
2. Client calls `tx.process()`  
3. Context delegates → `PendingState.process(tx)`  
4. State decides next state → `tx.setState(new ProcessingState())`  
5. Each new state defines what operations are allowed  

The client never checks status manually.

---

## 🧪 Sample Output

```
Creating transaction in Pending state...
PendingState: starting processing -> moving to ProcessingState
Transition: PENDING -> PROCESSING
ProcessingState: processing... -> moving to CompletedState
Transition: PROCESSING -> COMPLETED
Attempting refund...
CompletedState: refund allowed -> moving to RefundState
Transition: COMPLETED -> REFUND
RefundState: refund completed
```

---

## 🛑 Common Interview Traps

- ❌ Confusing State with Strategy  
- ❌ Putting transitions inside Context instead of states  
- ❌ Using enums + State classes together  
- ❌ Not understanding automatic behavior change when state swaps  
- ❌ Forgetting each call to `transaction.process()` behaves differently based on state  

---

## ✅ When to Use

Use State Pattern when:

- Object behavior depends on current state  
- State transitions are complex or frequent  
- Need to remove conditional logic  
- Want SRP/OCP-compliant design  
- Want to add new states easily  

Avoid when:

- Only 2 trivial states exist  
- Logic is too simple for polymorphism  
- State explosion occurs (hundreds of states)

---

## 🏁 One-Liner Summary

> State Pattern encapsulates state-specific behavior into separate classes and lets objects change behavior dynamically when their internal state changes.

---

Happy coding! 🚀

