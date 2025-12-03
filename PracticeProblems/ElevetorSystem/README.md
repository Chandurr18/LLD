# 🚀 Elevator System — Low-Level Design (LLD)

## 1️⃣ Requirements

### ✔ Functional Requirements
- System manages **multiple elevators** and **multiple floors**.
- Two types of requests:
  - **HallRequest** (external UP/DOWN call)
  - **CabinRequest** (internal request from inside elevator)
- Elevators must:
  - Move up/down floor-by-floor.
  - Stop at requested floors.
  - Open and close doors.
  - Continue serving more requests afterward.
- System must:
  - Choose the **best elevator** using a scheduling strategy.
  - Print real-time elevator status.

### ✔ Non-Functional Requirements
* Thread-safe queues & movement.
- Real-time simulation using sleep timers.
- Extensible strategy pattern.
- Supports multiple elevators without blocking each other.
- Easily extendable for advanced features.

---

## 2️⃣ Identify Core Entities

- 🏢 **ElevatorSystem**
- 🧠 **Scheduler** (interface)
- 📌 **NearestCarScheduler** (implementation)
- 🛗 **Elevator** (physical car)
- 🎛️ **ElevatorController** (one thread per elevator)
- 🔘 **Request** (interface)
  - `HallRequest`
  - `CabinRequest`
- 🔼🔽 **Direction** enum
- ⚙ **ElevatorState** enum

---

## 3️⃣ Relationships
- `ElevatorSystem` contains **multiple ElevatorController instances**.
- Each `ElevatorController` **controls exactly one Elevator**.
- `Scheduler.assignElevator()` selects which controller handles a HallRequest.
- Requests use the **Command Pattern** to call `execute(controller)`.
- Movement, queue management, and door servicing are inside `ElevatorController`.

---

## 4️⃣ Design Patterns in Use
### ✔ Strategy Pattern
`Scheduler` chooses best elevator.
You implemented **NearestCarScheduler**.

### ✔ Command Pattern
`Request.execute(controller)` adds itself into the controller.

### ✔ Producer–Consumer Pattern
Each elevator controller is a dedicated **thread** waiting on a lock/condition variable.

### ✔ Priority Queue Scheduling
- Up requests → served using **min-heap**
- Down requests → served using **max-heap**

---

## 5️⃣ Entity Descriptions

### 🔼🔽 Direction Enum
| Value | Meaning                  |
| ----- | ------------------------ |
| UP    | Elevator moving upward   |
| DOWN  | Elevator moving downward |
| IDLE  | Not moving               |

### ⚙ ElevatorState Enum
| Value   | Meaning                      |
| ------- | ---------------------------- |
| MOVING  | in transit                   |
| STOPPED | doors open / floor servicing |
| IDLE    | no pending work              |


### 🔘 Request (interface)
| Field     | Description                             |
| --------- | --------------------------------------- |
| floor     | target floor                            |
| direction | hall-request direction (null for cabin) |
| execute() | tells controller to add the request     |

#### HallRequest
Used for UP/DOWN button on floors.

#### CabinRequest
Used for selecting a floor inside elevator.

### 🛗 Elevator (physical car)
Represents the real elevator cabin.
| Field        | Description         |
| ------------ | ------------------- |
| id           | elevator ID         |
| currentFloor | current position    |
| direction    | UP/DOWN/IDLE        |
| state        | MOVING/STOPPED/IDLE |

Methods:
* `moveUpOne()`
- `moveDownOne()`
- `openDoor()` *(simulated sleep)*
- `closeDoor()` *(simulated sleep)*

### 🎛️ ElevatorController (thread + scheduling)
This is the **core** scheduling/execution engine.
| Fields    | Description              |
| --------- | ------------------------ |
| upQueue   | `PriorityQueue` min-heap |
| downQueue | `PriorityQueue` max-heap |
| lock      | ReentrantLock            |
| hasWork   | Condition                |
| worker    | Controller thread        |
| elevator  | physical elevator        |

#### Key Responsibilities
- Accept hall & cabin requests.
- Maintain ordered queues.
- Determine movement direction.
- Move elevator floor-by-floor.
- Handle servicing (door open/close).
- Stay idle when no work exists.

#### Real Movement Logic in Code
- If elevator is IDLE:
  - pick UP queue first, else DOWN queue.
- While moving:
  - step 1 floor every 400ms
- When reaching target:
  - remove from queue
  - open door → wait → close door

---

### 🧠 **Scheduler (Strategy Pattern)**
| Interface / Class   | Description                                  |
| ------------------- | -------------------------------------------- |
| Scheduler           | Strategy interface for picking best elevator |
| NearestCarScheduler | Chooses elevator closest + aligned direction |

Methods:
- **assignElevator(Request req, List<ElevatorController> ctrls)**
  Returns best elevator controller for the hall request.

---

### 🏢 ElevatorSystem (top-level API)
| Field       | Description                          |
| ----------- | ------------------------------------ |
| controllers | List of all elevator controllers     |
| scheduler   | Current elevator allocation strategy |

Methods:
- **submitHallRequest(Request req)** – Assigns request via scheduler
- **submitInternalRequest(int elevatorId, int floor)** – Cabin request
- **step()** – Optional simulation tick
- **printStatus()** - prints all elevator states
- **shutdown()** - stops all controller threads
Used in **ElevatorSystemApp.main**.

---

## 6️⃣ Important Flows

### 🛗 A. Hall Request Flow

User presses UP/DOWN →
Create `HallRequest` →
`scheduler.assignElevator()` →
`ElevatorController.addHallRequest()` →
Controller thread wakes up →
Elevator moves →
Stops → open/close doors → continue.

---

### 🎛️ B. Cabin Request Flow

Button pressed inside elevator →
Create `CabinRequest` →
Added to up/down queue →
Controller processes it alongside existing hall requests.

---

### 🔁 C. Elevator Movement Flow (as per code)
Controller thread:
1. Waits until any queue has work.
2. Chooses direction (UP priority if idle).
3. Gets next target from queue.
4. Moves floor-by-floor (`400ms` per floor).
5. Services target:
   - STOPPED → openDoor → wait → closeDoor
6. Remove floor from both queues.
7. If all queues empty → go IDLE.

---

## 7️⃣ Concurrency & Thread Safety
✔ Each elevator runs in **its own worker thread**
✔ Lock + Condition used for:

- queue updates
- wake/sleep logic
  ✔ Thread-safe shutdown logic
  ✔ Timed waits prevent deadlock (`await(200ms)`)

---

## 8️⃣ Extensibility (Supported by Current Design)

You can easily add:
- New scheduler strategies
- Peak hour mode
- Multi-speed elevators
- Emergency/fire override
- Load sensors
- Energy optimization
- Predictive scheduling

All without changing core logic.

---

## 9️⃣ Edge Cases Covered by Design

- Elevator idle until new request arrives.
- If user presses opposite direction, still added to correct queue.
- Controller prevents illegal idle movement.
- Handles rapid consecutive requests.
- Graceful shutdown of threads.

---

Happy coding 🚀