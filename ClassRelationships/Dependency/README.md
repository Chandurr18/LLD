# Dependency — Printer and Document Example

Dependency represents a **USES-A** relationship, where one object temporarily depends on another to perform a task.

> ✅ Printer → uses Document  
> ❌ Printer does not store or own Document  

Once the method finishes execution, the relationship ends.

---

## ✅ Characteristics

- Short-lived
- No ownership
- No long-term reference stored
- Independent lifecycles
- Represented with a plain arrow in UML

---

## 💡 Example Flow

1. A `Document` is created.
2. A `Printer` calls `printDocument(document)`.
3. The relationship ends after the method returns.

---

## 🧠 UML

Printer --> Document

---

## 🧩 Code Behavior

- `Printer` only **borrows** `Document`
- `Document` can be reused elsewhere
- `Printer` does **not** store it as a field

---

## 🛑 Common Interview Traps

❌ Thinking dependency stores references long-term  
❌ Confusing with association (stored field)  
❌ Believing lifecycle depends on the printer  
❌ Assuming ownership exists  

---

## ✅ When to Use

- When performing temporary actions
- When there is no need to store the object
- When lifecycles are independent

---

## 🏁 One-Liner Summary

> Dependency is a short-lived USES-A relationship where one object temporarily borrows another without owning it.

---

Happy coding! 🚀
