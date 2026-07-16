# 🚦 Traffic Signal Management System - Low Level Design (LLD)

## 1️⃣ Overview

A scalable and extensible **Traffic Signal Management System** built using Object-Oriented Design principles.

The system simulates an intelligent traffic intersection and supports:

* 🚦 Automatic traffic signal cycling
* 🚗 Vehicle count tracking for each direction
* 🚑 Emergency vehicle priority handling
* ⏱ Configurable signal timings
* 🔄 Pause and resume of signal cycles
* 🛑 Safe state transitions using the State Design Pattern

---

# 2️⃣ Functional Requirements

### ✔ Supported Operations

* 🏢 Create and manage traffic intersections
* 🚦 Control traffic lights for four directions (NORTH, EAST, SOUTH, WEST)
* 🔄 Automatically cycle traffic signals through all directions
* 🚑 Handle emergency vehicle requests
* 🛑 Pause the current cycle during emergencies
* 🚦 Turn all signals RED before granting emergency GREEN
* ▶ Resume normal traffic cycle after emergency completion
* 🚗 Track vehicle count for every direction
* ⏱ Configure green signal duration dynamically
* 🚫 Prevent conflicting traffic signals from becoming GREEN simultaneously

---

# 3️⃣ Non-Functional Requirements

* 🧵 Thread-safe data structures for concurrent operations
* 📈 Scalable to support multiple intersections
* ⚡ Low latency signal management
* 🧩 Easily extensible for:

  * Additional signal strategies
  * Adaptive timing algorithms
  * New traffic management rules
  * Emergency handling enhancements
* ⚠ Proper validation for invalid intersection IDs and timing values

---

# 4️⃣ High Level Architecture

```text
                 🚗 Vehicles
                      |
                      v
             TrafficController
                      |
                      v
             TrafficService
                      |
                      v
             VehicleCounter


            🚦 Intersection Setup
                      |
                      v
          IntersectionController
                      |
                      v
          IntersectionService
                      |
                      v
         IntersectionRepository
                      |
                      v
      Intersection + IntersectionCycle
```

---

# 5️⃣ Emergency Vehicle Flow

```text
          🚑 Emergency Request
                    |
                    v
         EmergencyController
                    |
                    v
          EmergencyService
                    |
                    v
         Pause Current Cycle
                    |
                    v
          Set All Signals RED
                    |
                    v
     Emergency Direction GREEN
                    |
                    v
      Emergency Vehicle Passes
                    |
                    v
         Resume Automatic Cycle
```

---

# 6️⃣ Core Components

## 🏢 Controllers

### IntersectionController

Responsible for intersection management:

* Create intersections
* Retrieve intersection details
* Start automatic signal cycle

---

### TrafficController

Responsible for traffic monitoring:

* Get vehicle count
* Increment vehicle count
* Reset vehicle count

---

### TimingController

Responsible for signal timing configuration:

* Set green signal duration
* Retrieve signal timings

---

### EmergencyController

Responsible for emergency handling:

* Raise emergency request
* End emergency mode
* Delegate emergency operations

---

## ⚙️ Services

### IntersectionService

* Creates intersections
* Starts automatic signal cycle
* Controls signal transitions
* Pauses and resumes traffic cycles

---

### TrafficService

* Maintains vehicle counters
* Tracks vehicles for each direction
* Resets counters after processing

---

### TimingService

* Stores configurable signal timings
* Supports dynamic green duration updates
* Maintains timings for multiple intersections

---

### EmergencyService

* Creates emergency requests
* Pauses traffic cycles
* Sets all signals RED
* Gives GREEN priority to emergency direction
* Restores normal operation after emergency

---

## 7️⃣ Design Patterns Used

### 🎯 State Pattern

Encapsulates traffic signal behavior into separate state objects.

Implementations:

* TrafficLightState
* GreenState
* YellowState
* RedState

Benefits:

* Prevents invalid signal transitions
* Makes state management extensible
* Keeps transition logic isolated

---

### 📦 Repository Pattern

Separates persistence logic from business logic.

Implementation:

* IntersectionRepository

Stores:

* Intersections
* Intersection cycles

---

## 8️⃣ Thread Safety & Concurrency

### 🔐 Repository

Uses:

* `ConcurrentHashMap`

Provides safe concurrent access to:

* Intersections
* Signal cycles
* Timing configurations
* Vehicle counters

---

### 🔢 Emergency Request IDs

Uses:

* `AtomicInteger`

Ensures unique emergency request IDs even under concurrent requests.

---

### 🧵 Timing Management

Signal timings are stored using nested `ConcurrentHashMap` structures, enabling concurrent updates for multiple intersections.

---

## 9️⃣ Extensibility

### Add new signal transition logic

Implement:

```text
TrafficLightState
```

Example:

* FlashingYellowState
* MaintenanceState

---

### Add adaptive timing algorithm

Extend:

```text
TimingService
```

Examples:

* TrafficDensityBasedTiming
* AIBasedTiming
* PeakHourTiming

---

### Add new emergency policies

Extend:

```text
EmergencyService
```

Examples:

* AmbulancePriority
* FireTruckPriority
* PoliceEscortPriority

---

## 🔟 Project Structure

```text
src
│
├── controller
├── domain
│   ├── enums
│   └── state
├── services
├── repository
├── Requirements.md
├── Entities.md
└── TrafficSystem.java
```

---

## 1️⃣1️⃣ Edge Cases Handled

✔ Invalid intersection ID
→ Request is rejected.

✔ Invalid signal duration
→ Green duration must be greater than zero.

✔ Emergency request during automatic cycle
→ Current cycle pauses safely before granting priority.

✔ Prevent conflicting GREEN signals
→ All signals first transition to RED before emergency GREEN.

✔ Resume after emergency
→ Automatic cycle resumes once emergency mode ends.

## 1️⃣2️⃣ Future Improvements

* 🌐 Expose REST APIs
* 🗄 Replace in-memory repository with a database
* 📊 Traffic analytics dashboard
* 🤖 AI-based adaptive signal timing
* 📹 CCTV and sensor integration
* 🚦 Multiple interconnected intersections (Green Wave)
* 📱 Admin dashboard for monitoring
* ☁ Distributed traffic management across cities

---

## 📘 Additional Documentation

For detailed class attributes and methods, refer to:

```text
Entities.md
```

For functional and non-functional requirements:

```text
Requirements.md
```

---

## 🎯 Design Highlights

* ✅ Object-Oriented Design
* ✅ State Pattern for signal transitions
* ✅ Repository Pattern for persistence abstraction
* ✅ ConcurrentHashMap for thread-safe storage
* ✅ AtomicInteger for unique emergency request generation
* ✅ Modular controller-service-repository architecture
* ✅ Easily extensible for future intelligent traffic management features

---

🚀 **Happy Coding!**
