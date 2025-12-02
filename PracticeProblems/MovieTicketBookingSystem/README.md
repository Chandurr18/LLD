# 🎬 Movie Ticket Booking System – Low Level Design (LLD)

## 1️⃣ Clarify Requirements

### ✔ Functional Requirements

- 🎞 Manage **movies, theatres, screens, shows & seats**
- 🎫 Users should be able to:

  - 🔍 Search shows by movie
  - 🎟 Select seats
  - 🔒 Lock seats for a brief duration
  - 💳 Make payment
  - ✅ Confirm booking
- ⏱ Seat-lock mechanism:

  - Prevent double-booking
  - Auto-expire in **5 minutes**
- 💰 Dynamic pricing based on seat type
- 📍 Theatre contains multiple screens; each screen has multiple seats

### ✔ Non-Functional Requirements

- 🧵 High **concurrency & thread-safety**

  - Multiple users booking simultaneously
- 🧠 Consistency of seat states (Available / Locked / Booked)
- 📦 Extensible for:

  - New payment gateways
  - New pricing models
  - New seat types
- ⚠ Reliable lock and booking workflow

---

## 2️⃣ Identify Core Entities

- 👤 **User**
- 🎞 **Movie**
- 🍿 **Show**
- 🖥 **Screen**
- 💺 **Seat**
- 🏢 **Theatre**
- 🎟 **Booking**
- 💳 **Payment**
- 🔒 **SeatLockService (Singleton)**
- 💰 **PaymentStrategy (Strategy Pattern)**
- 🔍 **SearchService**

---

## 3️⃣ Define Relationships

- 🏢 Theatre → contains → multiple Screens
- 🖥 Screen → contains → multiple Seats
- 🎞 Movie ↔ Show
- Show → occurs on → Screen
- Show → contains → seatStatus map for seats
- User ↔ Booking
- Booking ↔ Show + Seats + Payment
- BookingService → uses → SeatLockService + PaymentStrategy
- SearchService → filters → Shows by Movie

---

## 4️⃣ Design Patterns Used

### ✔ Singleton Pattern – SeatLockService

- Ensures **single global lock handler**
- Bill Pugh Singleton → thread-safe and lazy-loaded

### ✔ Strategy Pattern – Payment

- PaymentStrategy interface
- DummyPaymentGateway implementation

✔ Why?

- Easily plug in:

  - RazorPay, Stripe, PayTM, Wallet, UPI, etc.
- Avoids modifying booking flow when adding payment methods

### ✔ Encapsulation + Cohesion

- Show maintains seat availability
- BookingService handles booking lifecycle
- SeatLockService manages locking logic

---

## 5️⃣ Entity Descriptions

### 👤 User

| Field | Description |
| ----- | ----------- |
| id    | User ID     |
| name  | User's name |

### 🎞 Movie

| Field    | Description               |
| -------- | ------------------------- |
| id       | Unique movie ID           |
| title    | Name of movie             |
| language | EN/HIN/KAN/etc.           |
| duration | Movie duration in minutes |

---

### 💺 Seat

| Field    | Description              |
| -------- | ------------------------ |
| seatId   | S1, S2...                |
| type     | REGULAR/PREMIUM/RECLINER |
| row, col | Grid position            |

---

### 🖥 Screen

| Field    | Description       |
| -------- | ----------------- |
| screenId | Screen identifier |
| seats    | List of seats     |

---

### 🏢 Theatre

| Field     | Description       |
| --------- | ----------------- |
| theatreId | ID                |
| name      | Theatre name      |
| city      | Location          |
| screens   | Screens available |
| shows     | Shows assigned    |

Methods:

- addScreen(Screen s)
- addShow(Show s)

---

### 🍿 Show

| Field      | Description                       |
| ---------- | --------------------------------- |
| showId     | Unique ID                         |
| movie      | Movie object                      |
| screen     | Screen                            |
| startTime  | Show start time                   |
| seatStatus | ConcurrentMap<SeatId, SeatStatus> |
| pricing    | Map<SeatType → price>             |

Notes:
✔ Initializes all seats as AVAILABLE
✔ Seat statuses are **thread-safe**

---

### 🔒 SeatLockService (Singleton)

| Field          | Description                        |
| -------------- | ---------------------------------- |
| locks          | showId → seatId → expiry timestamp |
| lockDurationMs | 5 min (default)                    |

Methods:

- lockSeats(show, seats, user)
- releaseSeats(show, seats)
- markSeatsBooked(show, seats)

🔐 All critical methods are **synchronized**

---

### 🎟 Booking

| Field     | Description                               |
| --------- | ----------------------------------------- |
| bookingId | Unique ID                                 |
| user      | User                                      |
| show      | Show                                      |
| seats     | Seats selected                            |
| status    | PENDING / CONFIRMED / CANCELLED / EXPIRED |
| payment   | Payment result                            |

---

### 💳 Payment & Strategy

| Class               | Responsibility        |
| ------------------- | --------------------- |
| Payment             | Holds success/failure |
| PaymentStrategy     | Interface             |
| DummyPaymentGateway | Always succeeds       |

---

### 🧾 BookingService

| Field           | Description                 |
| --------------- | --------------------------- |
| lockService     | Seat locking                |
| paymentStrategy | Payment integration         |
| bookings        | Thread-safe map             |
| idGen           | Atomic booking ID generator |

Methods:

- createBooking(user, show, seats)
- confirmBooking(bookingId)

---

### 🔍 SearchService

| Field    | Description      |
| -------- | ---------------- |
| movies   | List of movies   |
| theatres | List of theatres |
| shows    | List of shows    |

Method:

- searchShows(movieId)

---

## 6️⃣ Important Flows

### 🎟 **A. Seat Lock + Booking Creation**

User selects seats →
BookingService.createBooking() →
SeatLockService.lockSeats() →
If all seats AVAILABLE:
✔ seats marked LOCKED
✔ booking created with PENDING status

Else → ❌ throw “Seats not available”

---

### 💳 **B. Payment + Booking Confirmation**

BookingService.confirmBooking() →
PaymentStrategy.pay() →
If payment.success:
✔ Booking → CONFIRMED
✔ SeatLockService.markSeatsBooked()

Else:
❌ Booking → CANCELLED
❌ release seat locks

---

### 🔍 **C. Searching Flow**

User searches movie →
SearchService.searchShows(movieId) →
Return all matching shows

---

### 🔄 **D. Concurrency Flow**

- Seat-locking must be atomic
- Booking creation is synchronized
- Confirm booking is synchronized
- seatStatus & bookings use ConcurrentHashMap
- ID generation uses AtomicInteger

---

## 7️⃣ Concurrency & Thread-Safety

### ✔ Critical synchronized operations:

- SeatLockService.lockSeats()
- SeatLockService.releaseSeats()
- BookingService.createBooking()
- BookingService.confirmBooking()

### ✔ Thread-safe structures:

- ConcurrentHashMap for seat statuses
- ConcurrentHashMap for bookings
- AtomicInteger for unique booking IDs

### ✔ Why needed?

- Multiple users selecting same seats
- Prevent race conditions during lock/confirm
- Avoid double-booking

⚠ Seat lock expiry cleanup not implemented → could be an improvement

---

## 8️⃣ Extensibility & Tradeoffs

### 🧩 Extensibility

- Add more seat types
- Add dynamic pricing (weekend, demand-based)
- Add multiple payment gateways
- Add seat-lock expiry scheduler
- Add discounts, coupons, tax engine
- Add more search filters (city, language, time)

---

### ⚖ Tradeoffs

| Choice                                 | Pros              | Cons                               |
| -------------------------------------- | ----------------- | ---------------------------------- |
| Synchronized BookingService            | Very safe         | Low scalability                    |
| Seat-level locking via show.seatStatus | Minimal conflicts | Large shows may have 100s of seats |
| Bill Pugh Singleton                    | Best-in-class     | Hard to mock                       |
| DummyPaymentGateway                    | Simple            | Not realistic                      |
| 5-min fixed lock                       | Easy              | Not dynamic                        |

---

## 9️⃣ Edge Cases & Error Handling

✔ Seat already locked/booked → throw exception
✔ Booking not found → error
✔ Payment failed → release seats
✔ Multiple users choose same seat → only 1 succeeds due to lock
✔ Show missing or seat ID invalid → fail booking
✔ Lock expiry may leave stale locks (future enhancement)

---

## 🔟 Possible Improvements

- Add seat-lock expiry cleanup thread
- Add logging
- Add real payment gateways
- Add retry mechanism for payments
- Add notification system (SMS/Email on confirmation)
- Support group pricing, combos, concessions
- Add DB storage (JPA/SQL)

---

Happy coding & movie booking! 🎥🍿🚀
