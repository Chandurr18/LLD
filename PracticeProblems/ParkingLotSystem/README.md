# 🚗 Parking Lot System - Low Level Design (LLD)

## 1️⃣ Overview

A scalable and extensible Parking Lot Management System built using Object-Oriented Design principles.

The system supports:

* 🚘 Vehicle entry and exit
* 🅿️ Parking spot allocation based on vehicle type
* 🎫 Ticket generation and management
* 💰 Parking fee calculation
* 💳 Payment processing using external providers
* 🔓 Automatic spot release after vehicle exit

---

# 2️⃣ Functional Requirements

### ✔ Supported Operations

* 🏢 Manage multiple floors in a parking lot
* 🅿️ Add parking spots to floors
* 🚗 Support multiple vehicle types (CAR, BIKE, TRUCK, EV)
* 🎯 Assign nearest available parking spot
* 🎫 Generate a ticket during entry
* 💵 Calculate parking fees during exit
* 💳 Process payment through payment adapters
* ♻️ Release the occupied spot after successful exit

---

# 3️⃣ Non-Functional Requirements

* 🧵 Thread-safe parking operations
* 📈 Scalable to multiple floors and thousands of spots
* 🧩 Easily extensible for:

  * New vehicle types
  * New spot allocation strategies
  * New fee calculation algorithms
  * New payment providers
* ⚠️ Proper error handling using custom exceptions

---

# 4️⃣ High Level Architecture

```
               🚘 Vehicle
                     |
                     v
              EntryController
                     |
                     v
                SlotService
                     |
                     v
           SpotAllocationStrategy
                     |
                     v
             NearestSpotStrategy
                     |
                     v
                ParkingSpot
                     |
                     v
               TicketService
                     |
                     v
                  Ticket
```

---

# 5️⃣ Vehicle Exit Flow

```
              🎫 Ticket ID
                     |
                     v
               ExitController
                     |
                     v
               TicketService
                     |
                     v
               PricingService
                     |
                     v
               FeeCalculator
                     |
                     v
               PaymentService
                     |
                     v
             PaymentServiceAdapter
                     |
                     v
            Release Parking Spot
```

---

# 6️⃣ Core Components

## 🏢 Controllers

### AdminController

Responsible for parking lot setup:

* Add floors
* Add parking spots
* View parking layout

### EntryController

Responsible for vehicle entry:

* Create vehicle object
* Request slot allocation
* Generate parking ticket

### ExitController

Responsible for vehicle exit:

* Validate ticket
* Calculate fee
* Process payment
* Release parking spot

---

## ⚙️ Services

### SlotService

* Finds available spots
* Uses allocation strategy
* Releases spots after exit

### TicketService

* Generates unique ticket IDs
* Stores active tickets
* Retrieves tickets

### PricingService

* Calculates parking charges using fee strategies

### PaymentService

* Delegates payment processing to adapters

---

## 7️⃣ Design Patterns Used

### 🎯 Strategy Pattern

Allows changing algorithms without modifying business logic.

Used for:

**Spot Allocation**

* SpotAllocationStrategy
* NearestSpotStrategy

**Fee Calculation**

* FeeCalculator
* HourlyFeeCalculator

---

### 🔌 Adapter Pattern

Provides abstraction over third-party payment systems.

Implementations:

* RazorPayAdapter
* StripePayAdapter

---

### 📦 Repository Pattern

Separates storage logic from services.

Implementation:

* TicketRepository using ConcurrentHashMap

---

## 8️⃣ Thread Safety & Concurrency

### 🔐 ParkingSpot

Critical methods are synchronized:

* park()
* removeVehicle()
* isFree()

Prevents multiple vehicles from occupying the same spot.

---

### 🧵 Ticket Management

TicketRepository uses:

* ConcurrentHashMap

Provides safe access from multiple entry/exit requests.

---

### 🔢 Unique Ticket Generation

TicketService uses:

* AtomicInteger

Guarantees unique ticket IDs even with concurrent requests.

---

## 9️⃣ Extensibility

### Add new spot allocation strategy

Implement:

```
SpotAllocationStrategy
```

Example:

* CheapestSpotStrategy
* RandomSpotStrategy

### Add new pricing algorithm

Implement:

```
FeeCalculator
```

Example:

* WeekendPricingCalculator
* DynamicPricingCalculator

### Add new payment provider

Implement:

```
PaymentServiceAdapter
```

Example:

* PayPalAdapter
* GooglePayAdapter

---

## 🔟 Project Structure

```
src
│
├── controllers
├── entities
├── services
├── repositories
├── strategies
├── adapters
├── dto
├── enums
└── exceptions
```

---

## 1️⃣1️⃣ Edge Cases Handled

✔ No parking spot available
→ Throws NoSlotFoundException

✔ Invalid ticket ID
→ Returns failure response

✔ Multiple vehicles trying to park in the same spot
→ Prevented using synchronized ParkingSpot methods

✔ Concurrent ticket generation
→ Handled using AtomicInteger and ConcurrentHashMap

---

## 1️⃣2️⃣ Future Improvements

* 🌐 Expose REST APIs
* 🗄️ Replace in-memory repository with a database
* 📱 Mobile application support
* 🚦 Real-time parking availability display
* 📊 Analytics and reporting
* 🧾 Multiple pricing models

---

## 📘 Additional Documentation

For detailed class attributes and methods, refer to:

```
Entities.md
```
For functional and non-functional requirements:

```text
Requirements.md
```

---

🚀 **Happy Coding!**
