# Composition — House and Room Example

Composition represents a **strong** whole–part relationship where the part **cannot** exist without the whole.

> ✅ House → owns Rooms  
> ❌ Rooms cannot exist meaningfully without a House

If the House is destroyed, its Rooms are destroyed with it.

---

## ✅ Characteristics

- Strong ownership
- Lifecycle dependency
- Typically created inside the whole
- Represented with a **filled diamond** in UML
- One object controls the lifetime of the other

---

## 💡 Example Flow

1. A `House` creates `Room` objects internally.
2. Calling `demolishHouse()`:
   - Removes all `Room` objects
   - Rooms become invalid

---

## 🧠 UML

House ◆----- Room


Filled diamond = Composition.

---

## 🧩 Code Behavior

- `House` constructs `Room` objects itself.
- `Room` has no useful existence outside the `House`.
- Destroying the `House` destroys its `Room`s.

---

## 🛑 Common Interview Traps

❌ Confusing composition with aggregation  
❌ Assuming the part can outlive the whole  
❌ Thinking composition implies shared objects  
❌ Believing Rooms can belong to multiple Houses

---

## ✅ When to Use

- When the lifetime of the part depends on the whole
- When parts are **created inside** the whole
- When parts **cannot** logically exist alone

---

## 🏁 One-Liner Summary

> Composition is a strong OWNS-A relationship where the lifetime of parts is strictly tied to the whole.

---

Happy coding! 🚀
