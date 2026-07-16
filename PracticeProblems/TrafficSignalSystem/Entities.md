# Entities

## 1. Intersection
Represents a traffic intersection containing four traffic lights.

- id: int
- name: String
- trafficLights: Map<Direction, TrafficLight>
- isEmergencyMode: boolean
- emergencyDirection: Direction
- isCyclePaused: boolean

---

## 2. IntersectionCycle
Maintains the current signal cycle for an intersection.

- intersectionId: int
- currentPhase: int (0 = NORTH, 1 = EAST, 2 = SOUTH, 3 = WEST)
- isPaused: boolean
- pausedAtPhase: int
- phaseStartTime: long
- pauseStartTime: long
- totalPauseTime: long

---

## 3. TrafficLight
Represents a signal for one direction.

- direction: Direction
- currentState: TrafficLightState

---

## 4. SignalTiming
Stores configurable timing for each direction.

- intersectionId: int
- direction: Direction
- greenDuration: int

Constants:
- YELLOW_DURATION = 3 seconds

---

## 5. VehicleCounter
Tracks the number of vehicles waiting in a direction.

- direction: Direction
- count: int
- lastUpdate: long

---

## 6. EmergencyRequest
Represents an emergency vehicle priority request.

- id: int
- intersectionId: int
- direction: Direction
- requestTime: long
- duration: int
- isActive: boolean

---

## Supporting Enums / State Objects

### Direction (Enum)
- NORTH
- EAST
- SOUTH
- WEST

### TrafficLightState (State Pattern)
Implementations:
- RedState
- YellowState
- GreenState