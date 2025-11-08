# YAGNI (You Aren't Gonna Need It) — Don't Build What You Don't Need

> **Definition:** YAGNI advises developers to avoid implementing features until they are actually required.  
> Build only what's necessary now; avoid speculative features or premature optimization.

YAGNI helps keep the codebase simple, reduces waste, and speeds up delivery.

---

## 🚫 Common Mistake

Engineers often preemptively build features "for future use," leading to extra code, complexity, and maintenance overhead.

```java
// Violation: Building speculative class and hooks for future features
public class OrderService {
    public void placeOrder(Order order) {
        // Basic order placement logic
        saveOrder(order);

        // Hook for future "rewardPoints" feature (not used yet)
        RewardPointsService rewardPointsService = new RewardPointsService();
        rewardPointsService.applyPoints(order);
    }
}

public class RewardPointsService {
    public void applyPoints(Order order) {
        // Complex logic not yet required
    }
}
```

🔴 **Issue:** The codebase now contains unused components and added complexity.  
Maintaining speculative code slows development and increases the risk of bugs.

---

## ✅ Correct Approach

Implement features when there's a clear, demonstrable need. Keep code minimal and add extension points only when they are required.

```java
// YAGNI-compliant approach: implement the core now, add features later
public class OrderService {
    public void placeOrder(Order order) {
        saveOrder(order);
        // No reward points until it's a required feature
    }
}

// When reward points become a requirement, add it with tests and refactor appropriately
```

✅ This keeps the codebase focused, reduces cognitive load, and minimizes technical debt.

---

## 💡 Core Idea

- Avoid speculative work; implement features **when proven necessary**.  
- Prefer simple, working solutions over planned extensibility.  
- Use YAGNI together with tests and feedback from real usage.  
- Refactor when requirements evolve — that's cheaper than guessing.

---

## 🧠 Real-World Analogy

Don't buy a larger house "just in case" you'll have more kids — rent or renovate when the need is real.  
Speculating leads to wasted resources.

---

## 💬 When to Apply

Use YAGNI when:
- The feature idea is speculative and not backed by user need or metrics.  
- Adding the feature now increases complexity without immediate value.  
- You're tempted to design extensive extension points "for future-proofing."

Avoid strict YAGNI when:
- Regulatory or security requirements mandate future support.  
- The cost of retrofitting later is significantly higher than building now (rare, but possible).

---

## 🧠 Interview Angle

Common questions:
- “What does YAGNI mean and why is it useful?”  
- “How do you balance YAGNI with designing for extensibility?”  
- “Give an example where removing speculative features improved your project.”

✅ Explain that YAGNI is balanced with good engineering judgment — use metrics, feedback, and pragmatic design.

---

## 🏁 One-Liner Summary

> **YAGNI** reminds us: don’t build features you don’t need today — focus on delivering immediate value and keep the codebase lean.

---

Happy coding! 🚀
