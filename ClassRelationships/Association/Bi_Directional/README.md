# Bi-Directional Association — Author and Book Example

This example demonstrates **Bi-Directional Association**, where two objects hold references to each other and can navigate both ways.

> ✅ Author → knows Book  
> ✅ Book → knows Author  

Both objects can exist independently in memory and have **independent lifecycles**.

---

## ✅ Characteristics

- Navigation works from both ends
- Represented by references in both classes
- No lifecycle ownership
- Long-term relationship

---

## 💡 Example Flow

1. An `Author` is created.
2. A `Book` is created.
3. Calling `author.addBook(book)`:
   - Adds the book to the author's list
   - Sets the author reference inside the book

---

## 🧩 Code Behavior

- `Author` maintains a list of `Book` objects
- `Book` stores its `Author`
- Removal of one does **not** destroy the other

---

## 🧠 UML

Author <----> Book

Arrows on both ends indicate mutual knowledge.

---

## 🛑 Common Interview Traps

- Thinking objects share a lifecycle (they do **not**)
- Confusing it with Aggregation
- Assuming deletion cascades automatically
- Thinking mutual association implies composition

---

## 🧪 When to Use

- When navigation is needed from both objects
- When querying relationships from either direction is required

---

## 🏁 One-Liner Summary

> Bi-Directional Association is a “knows-a” relationship where **both** objects reference each other, yet maintain independent lifecycles.

---

Happy coding! 🚀
