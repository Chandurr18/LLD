# **Splitwise – Low-Level Design (LLD)**

## 1️⃣ Clarify Requirements

### ✔ Functional Requirements
- Users can create groups.
- Users can add expenses inside a group or outside (person-to-person).
- Supported splits:
  * **Equal Split**
  * **Exact Amount Split**
  * **Percentage Split**
- System should tell how much each user owes or is owed.
- Show balances per user and per group.

### ✔ Non-Functional Requirements
- High read frequency (balance checks).
- Accuracy required: no floating precision errors (use BigDecimal).
- Extensible for new split types (shares, weighted percentage etc.).

---

## 2️⃣ Identify Core Entities
- User                                      
- Group                                     
- Expense                                   
- Split (interface)                         
- EqualSplit / ExactSplit / PercentageSplit 
- BalanceSheet / Ledger                     

---

## 3️⃣ Define Relationships
- **User ↔ Group** : Many-to-Many
- **Group → Expense** : One-to-Many
- **Expense → Split objects** : One-to-Many
- **Ledger → User Balances** : Maintains mapping

---

## 4️⃣ Choose Design Pattern

### ✔ Strategy Pattern
Reason: Each expense has variable split logic. Strategy lets us add new split types without touching core Expense code.

```
SplitStrategy (interface)
|— EqualSplitStrategy
|— ExactSplitStrategy
|— PercentageSplitStrategy
```

### ✔ Factory Pattern for creating split strategies.
Reason: Split creation logic varies per split type.
Instead of writing multiple `if-else` or `switch` statements across the code, we centralized object creation in a **Factory** so we can introduce new split strategies without modifying core logic.

```
SplitStrategyFactory (factory)
|— returns EqualSplitStrategy
|— returns ExactSplitStrategy
|— returns PercentageSplitStrategy
```
---

## 5️⃣ Entity Descriptions

### 👤 User
| Field  | Description                |
| ------ | -------------------------- |
| userId | Unique identifier for user |
| name   | Full name                  |
| email  | Email address              |

Methods:
- Getters only

### 👥 Group
| Field    | Description                                    |
| -------- | ---------------------------------------------- |
| groupId  | Unique identifier for group                    |
| name     | Name of the group (Trip, Friends, Office etc.) |
| users    | List of users belonging to this group          |
| expenses | List of expenses created in this group         |

Methods:
- addMember(User user)
- addExpense(Expense expense)

### 💸 Expense
| Field         | Description                      |
| ------------- | -------------------------------- |
| expenseId     | Unique identifier                |
| paidBy        | User who paid                    |
| amount        | Total amount of the expense      |
| splits        | How the amount is divided        |
| splitStrategy | Strategy used to calculate split |

Methods:
* validateSplits()
* applySplit()

### 🔀 SplitStrategy (Interface)
| Method                          | Description                                  |
| ------------------------------- | -------------------------------------------- |
| calculateSplit(Expense expense) | Returns calculated List<Split> based on rule |

Concrete Strategies:
- EqualSplitStrategy
- ExactSplitStrategy
- PercentageSplitStrategy


### ✂ Split
| Field  | Description              |
| ------ | ------------------------ |
| user   | User who owes            |
| amount | Amount owed by that user |


### 📘 Ledger / BalanceSheet
| Field    | Description                                                 |
| -------- | ----------------------------------------------------------- |
| balances | Map<User, Map<User, BigDecimal>> user1 owes user2 -> amount |

Methods:
* addBalance(u1, u2, amount)
* getUserBalance(user)
* getGroupBalance(group)

---

## 6️⃣ Important Flows

### **A. Add Expense**
1. Client sends → paidBy, totalAmount, groupId(optional), splitStrategy + metadata.
2. Expense object created.
3. Expense calls strategy → calculates splits.
4. Ledger updated (payer + receivers).
5. Add to group history.

### **B. Show Balance**
- Query ledger:
  * For user: iterates balances[user]
  * For group: filter balances only among group members.

---

## 7️⃣ Concurrency & Scalability
- Reads >> Writes → Use **ReadWriteLock** on Ledger.
- If microservices:
  * Event-driven queue for expense updates.
  * Ledger becomes **eventually consistent**.
- Avoid floating-point → BigDecimal mandatory.

---

## 8️⃣ Extensibility & Tradeoffs
| Feature                 | Easy to Extend?     |
| ----------------------- | ------------------- |
| New Split Type          | Yes (Strategy)      |
| Add currency conversion | Add decorator       |
| Add payment settlement  | Requires new domain |

### Tradeoffs:
| Approach            | Pros        | Cons         |
| ------------------- | ----------- | ------------ |
| Maintain ledger map | Fast reads  | Memory grows |
| Compute on demand   | Less memory | Slow queries |

Decision: **Maintain ledger**.

---

## 9️⃣ Edge Cases + Error Handling
| Case                           | Handling                   |
| ------------------------------ | -------------------------- |
| Sum of exact splits ≠ total    | throw validation exception |
| Percentage not equal to 100    | validation                 |
| User not in group              | reject expense             |
| Negative values                | reject                     |
| Duplicate splits for same user | merge or reject            |

---

## 🔟 Possible Improvements
- OCR receipt parsing → AI add expense.
- Support multiple currencies.
- Undo expense via soft delete + reverse event.

---

Happy coding! 🚀