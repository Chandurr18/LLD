# Single Responsibility Principle (SRP) — Employee Payroll Example

This example demonstrates the Single Responsibility Principle (SRP) from the SOLID design principles using a payroll domain scenario.

SRP states that:

> **A class should have one, and only one, reason to change.**

---

## 🚫 Violation (Problem)

In the violation example, the `Employee` class handles **multiple responsibilities**:

- Salary calculation (business logic)
- Saving to the database (persistence)
- Generating payslip (reporting)
- Sending emails (communication)

This causes the class to change whenever:

- Business rules update
- Database technology changes
- Payslip format updates
- Email template/server changes

This leads to:

- Tight coupling
- Harder testing
- Low cohesion
- Fragile code

---

## ✅ SRP-Compliant Solution

Responsibilities are separated into dedicated classes:

| Responsibility | Class | Reason to Change |
|--------------|-------|------------------|
| Represent data + salary logic | `Employee` | Business rule changes |
| Save employee to DB | `EmployeeRepository` | Storage changes |
| Generate payslip content | `PaySlipGenerator` | Report format changes |
| Send the payslip via email | `EmailService` | Email protocol/template |

Now each class has **exactly one** reason to change.

---

## 👌 Benefits of This Design

- Higher cohesion
- Reduced coupling
- Smaller, focused classes
- Easier unit testing
- Better maintainability
- Cleaner separation of concerns

---

## 📦 How It Works

`Main.java` shows usage by:

1. Creating an `Employee`
2. Calculating salary
3. Generating a payslip
4. Saving data to DB
5. Emailing the payslip

Each action is delegated to the correct class.

---

## 🧪 Testability Win

You can now test:

- Salary logic without email
- Email logic without DB
- Report formatting without touching employee logic

This was not possible in the violation example.

---

## 🧠 Key Takeaway

If a class has **multiple reasons to change**, split it.

---

## 🏁 One-Liner Summary

> SRP improves maintainability by ensuring every class focuses on a **single** responsibility, reducing unintended side effects.

---

Happy coding! 🚀