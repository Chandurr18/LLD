# 🚗 Parking Lot System – Low Level Design (LLD)

## 1️⃣ Clarify Requirements

### ✔ Functional Requirements
- 🏢 Manage a **multi-floor parking lot**
- 🅿️ Each floor has multiple parking spots of types:
  - 🚗 CAR
  - 🏍️ BIKE
  - 🚚 TRUCK
- 🎯 System must:
  - 🔍 Assign the **nearest available spot** based on vehicle type
  - 🎫 Generate ticket on entry
  - 💰 Calculate fees on exit
  - ♻️ Release spot after exit
  - 🚪 Support multiple **entry/exit gates**
- 🚘 Allowed vehicle types: CAR, BIKE, TRUCK
- 💵 Fee Strategy: Hourly flat rate (extensible)

### ✔ Non-Functional Requirements
- 🧵 **Thread-safety** for multiple gates
- 📦 Extensible for:
  - New vehicle types
  - New pricing strategies
  - New allocation strategies
- 📈 Scalable across floors
- 🔐 Fault-tolerant with good error handling

---

## 2️⃣ Identify Core Entities
- 🚘 Vehicle  
- 🅿️ ParkingSpot  
- 🏢 Floor  
- 🎫 Ticket  
- 🏭 ParkingLot (Singleton)  
- 🚪 EntryGate / ExitGate  
- 🎯 Spot Allocation Strategy  
- 💵 Fee Calculation Strategy  

---

## 3️⃣ Define Relationships
- 🅿️ ParkingLot → contains → multiple Floors  
- 🏢 Floor → contains → multiple ParkingSpots  
- 🚘 Vehicle ↔ ParkingSpot (one assigned spot)  
- 🎫 Ticket maps:
  - Vehicle ↔ Spot
  - Tracks entry time  
- EntryGate → ParkingLot.generateTicket()  
- ExitGate → ParkingLot.processExit()  
- ParkingLot uses:
  - SpotAllocationStrategy  
  - FeeCalculator  

---

## 4️⃣ Design Patterns Used

### ✔ Singleton Pattern – ParkingLot
- Ensures **single instance**
- Uses **Bill Pugh Singleton** (thread-safe, lazy)

### ✔ Strategy Pattern
Used for:
- 🎯 Spot Allocation (Nearest, Cheapest, Priority...)
- 💵 Fee Calculation (Hourly, Per-minute, Weekend discount...)

✔ Why?  
- 🔁 Easily switch & extend strategies

### ✔ Encapsulation + Cohesion
- Ticket → handles time  
- Spot → knows occupancy  
- Floor → searches spots  

---

## 5️⃣ Entity Descriptions

### 🚘 Vehicle
| Field | Description |
|-------|-------------|
| licenseNumber | Unique identifier |
| type | CAR/BIKE/TRUCK |

### 🅿️ ParkingSpot
| Field | Description |
|-------|-------------|
| id | Spot ID |
| type | Vehicle type allowed |
| parkedVehicle | Vehicle currently parked |

🔐 **Synchronized Methods**
- isFree()  
- park(Vehicle v)  
- removeVehicle()  
- Ensures atomic spot assignment.

### 🏢 Floor
| Field | Description |
|-------|-------------|
| id | Floor ID |
| spots | List of parking spots |

Method:
- getFreeSpot(VehicleType type) – returns first free matching spot.

### 🎫 Ticket
| Field | Description |
|-------|-------------|
| ticketId | Unique ID |
| vehicle | Vehicle assigned |
| spot | ParkingSpot assigned |
| entryTime | Time stamp |

### 🏭 ParkingLot (Singleton)
| Field | Description |
|-------|-------------|
| floors | All floors |
| strategy | Spot allocation strategy |
| feeCalculator | Pricing strategy |
| activeTickets | ConcurrentMap of tickets |
| tid | Atomic integer for ticket IDs |

Methods:
- generateTicket(Vehicle v)
- processExit(String ticketId)
- addFloor(Floor f)

### 🚪 EntryGate / ExitGate
- Simple façade classes calling ParkingLot APIs.

### 🔍 Strategies
- NearestSpotStrategy : Loops floors → finds first free spot.
- HourlyFeeCalculator (10 units/hr)

---

## 6️⃣ Important Flows

### 🚗 **A. Vehicle Entry**
EntryGate → ParkingLot.generateTicket() → SpotAllocationStrategy.findSpot() → Floor.getFreeSpot() → ParkingSpot.park() → Create Ticke → Add to activeTickets

### 🚙 **B. Vehicle Exit**
ExitGate → ParkingLot.processExit(ticketId) 
→ Fetch Ticket from activeTickets 
→ FeeCalculation .calculate() 
→ ParkingSpot.removeVehicle() 
→ Remove Ticket  

### 🔁 **C. Concurrency Flow**
Thread-safe areas:
- ParkingSpot (synchronized)
- activeTickets (ConcurrentHashMap)
- AtomicInteger for ticket IDs
- synchronized generateTicket() / processExit()

---

## 7️⃣ Concurrency & Thread-Safety
✔ ParkingSpot 
- All methods synchronized → ensures no double-parking.

✔ ParkingLot 
- Ticket generation & exit are synchronized.
- Tickets stored in ConcurrentHashMap, avoids race conditions.

✔ AtomicInteger
- Guarantees unique ticket IDs even in multi-threaded environments.

✔ Strategy classes
- Stateless → thread-safe.

⚠ Floor.spots List
- Not thread-protected but spot-level locking ensures safety.
---

## 8️⃣ Extensibility & Tradeoffs

### 🧩 Extensibility
- Add new Spot Allocation Strategies (e.g., random, best fit).  
- Add new Pricing Straategies - fee calculators (per minute, dynamic surge pricing).  
- Add new vehicle types (Electric Car, Bus).
- Add reservations, guidance, mobile app.

### ⚖ Tradeoffs

| Choice | Pros | Cons |
|--------|------|------|
| Synchronized ParkingLot | Simple, Safe | High contention |
| NearestSpotStrategy | Fast, deterministic | Not load-balanced |
| Bill Pugh Singleton | Very safe | Harder to mock for testing|
| Spot-level locking | No global lock | Many threads may compete for same spot |

---

## 9️⃣ Edge Cases & Error Handling
✔ No available spot → throws NoSpotAvailableException  
✔ Invalid ticket → return -1  
✔ Vehicle type mismatch → reject parking 
✔ Zero-time parking → min 1 hour charged  
✔ Race conditions → prevented with synchronized blocks

---

## 🔟 Possible Improvements
- Add logging  
- Unit tests  
- Separate DTOs  
- Add DB layer  
- Observer pattern for spot updates  

---

Happy coding! 🚀
