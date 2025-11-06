# Uni-Directional Association — Driver and Car Example

This example demonstrates **Uni-Directional Association**, where one object **knows** or holds a reference to another, but not vice-versa.

> ✅ Car → knows Driver  
> ❌ Driver → does NOT know Car

Both objects have **independent lifecycles** and can exist without each other.

---

## ✅ Characteristics

- Long-term relationship
- Stored as a reference field
- Independent object lifecycles
- Navigation is **one-way**

---

## 💡 Example Flow

1. A `Driver` object is created.
2. A `Car` object is associated with that driver.
3. `Car.driveCar()` delegates to `Driver.drive()`.

---

## 🧩 Code Behavior

- `Car` holds a reference to `Driver`
- `Driver` has no idea `Car` exists
- Removing `Car` does NOT remove `Driver`

---

## 🧠 UML

Car -----> Driver


Arrow direction indicates **knowledge**.

---

## ❌ Common Interview Traps

- Thinking this is composition (it's not)
- Thinking lifecycle depends on Car (it doesn't)
- Assuming bidirectional navigation

---

## 🏁 One-Liner Summary

> Uni-Directional Association is a “knows-a” relationship where only one object references the other, and both exist independently.

---

Happy coding! 🚀
