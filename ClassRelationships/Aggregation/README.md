# Aggregation — Department and Professor Example

Aggregation is a **HAS-A** relationship where the "whole" holds references to "parts", but parts can still exist independently.

> ✅ Department → has Professors  
> ✅ Professors can exist without a Department  

---

## ✅ Characteristics

- Weak ownership
- Independent object lifecycles
- Represented by a **hollow** diamond in UML
- Typically stored as collections
- Long-term relationship

---

## 💡 Example Flow

1. Professors (`p1`, `p2`) are created.
2. A `Department` aggregates them.
3. If `Department` is removed:
   - The `Professor` objects continue to exist.

---

## 🧠 UML

Department <>----- Professor

Hollow diamond = Aggregation (weak relationship).

---

## 🧩 Code Behavior

- `Department` keeps a list of `Professor`
- `Professor` does **not** depend on `Department` to exist
- No lifecycle control

---

## 🛑 Common Interview Traps

❌ Thinking aggregation deletes the part  
❌ Confusing it with composition  
❌ Believing lifecycle dependency exists  
❌ Thinking child cannot belong to multiple parents

(Professor can belong to multiple departments)

---

## ✅ When to Use

- When parts must outlive the container
- When objects may be shared
- When lifecycle is independent

---

## 🏁 One-Liner Summary

> Aggregation is a weak HAS-A relationship where the part can outlive the whole.

---

Happy coding! 🚀
