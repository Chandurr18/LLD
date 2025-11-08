# Design Principles — Core Guidelines for Writing Maintainable, Scalable, and Clean Software

> This folder contains a curated collection of **industry-grade software design principles** that guide developers in building systems that are easy to understand, modify, and extend.

Each principle is explained with:
- ✅ A clear **definition**
- 🚫 A **common mistake** (anti-pattern)
- ✅ A **correct example** (real-world, domain-relevant snippet)
- 💡 Key **takeaways**
- 🧠 **Interview relevance**

These principles complement the **SOLID** principles and form the foundation for **clean, extensible, and production-ready design**.

---

## 📘 Why Design Principles Matter

Software complexity grows faster than you expect — good principles help you manage it.

Design principles ensure your code is:
- **Readable** → Easy to understand and review  
- **Maintainable** → Simple to update or extend  
- **Testable** → Easy to isolate and verify behavior  
- **Scalable** → Capable of handling growth and change  

These principles are **language-agnostic** and can be applied in Java, C#, Python, or any OOP environment.

---

## 🧩 Principles Covered

| Principle | Summary | Key Benefit |
|------------|----------|--------------|
| **KISS** (Keep It Simple, Stupid) | Prefer simplicity over unnecessary complexity | Reduces overengineering |
| **DRY** (Don’t Repeat Yourself) | Eliminate duplicated logic; centralize behavior | Consistency, maintainability |
| **YAGNI** (You Aren’t Gonna Need It) | Don’t build features until they’re actually needed | Focus, agility |
| **Composition Over Inheritance** | Combine behavior using composition rather than subclassing | Flexibility, modularity |
| **Encapsulate What Varies** | Isolate change-prone code behind stable interfaces | Stability, extensibility |
| **Fail Fast** | Detect and report errors early to avoid hidden issues | Reliability, safety |
| **Favor Immutability** | Make objects unchangeable after creation | Thread-safety, predictability |
| **High Cohesion & Low Coupling** | Group related behavior together and minimize interdependency | Modularity, maintainability |
| **Law of Demeter** | Classes should communicate only with their direct collaborators | Encapsulation, decoupling |
| **Program to Interfaces** | Depend on abstractions, not concrete implementations | Testability, flexibility |
| **Separation of Concerns (SoC)** | Divide the system into independent modules with distinct roles | Clarity, scalability |
| **Principle of Least Astonishment (POLA)** | Design systems that behave as users expect | Predictability, usability |

---

## 🧠 How to Use This Folder

Each subfolder represents a design principle and contains a single `README.md` file (no separate Code files).  
Every README includes:
- A concise explanation of the principle  
- Example snippets (violation vs. correct design)  
- Practical guidelines for when and how to apply the principle  
- Interview tips and one-liner summaries  

You can use this folder as:
- A **reference library** while learning or revising LLD concepts  
- A **quick interview refresher** before system design rounds  
- A **documentation asset** in your professional portfolio or GitHub repo

---

## 🏗️ Relation to Other Sections

This folder complements the following sections of the repo:

| Folder | Purpose |
|---------|----------|
| `SOLIDPrinciples/` | Core object-oriented design principles (Single Responsibility, Dependency Inversion, etc.) |
| `ClassRelationships/` | Foundational OOP relationships (Association, Aggregation, Composition, Dependency) |
| `DesignPatterns/` | Reusable solutions to common design problems (Factory, Strategy, Observer, etc.) |

Together, these make up a complete **Low-Level Design (LLD) Reference Repository**.

---

## 💬 Recommended Reading Order

To maximize understanding, read the design principles in this order:

1. **KISS** → Start simple  
2. **DRY** → Eliminate duplication  
3. **YAGNI** → Don’t overbuild  
4. **Composition Over Inheritance** → Prefer flexibility  
5. **Encapsulate What Varies** → Isolate change  
6. **Fail Fast** → Catch issues early  
7. **Favor Immutability** → Keep data consistent  
8. **High Cohesion & Low Coupling** → Design modularly  
9. **Law of Demeter** → Keep boundaries clean  
10. **Program to Interfaces** → Depend on abstractions  
11. **Separation of Concerns (SoC)** → Architect in layers  
12. **Principle of Least Astonishment (POLA)** → Build predictable systems  

---

## 🏁 One-Liner Summary

> These design principles help you write software that’s **simple, modular, and adaptable to change** — the hallmark of professional engineering.

---

Happy Learning & Designing! 🚀
