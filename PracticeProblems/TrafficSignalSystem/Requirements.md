# Functional requirements

- The system should control traffic signals at a single intersection (4 traffic lights as a unit)
- The system should manage automatic cycling through phases (NORTH → EAST → SOUTH → WEST)
- The system should handle emergency vehicle priority requests by PAUSING the automatic cycle 
- During emergency: ALL signals turn RED, emergency direction gets GREEN, then resume cycle from pause 
- The system should track vehicle count at each approach
- The system should prevent conflicting signals from being active simultaneously
- The system should have configurable signal durations (RED, YELLOW, GREEN) for each direction
- The system should allow dynamic adjustment of signal durations based on traffic conditions

# Non-Functional Requirements
- **Scalability:** Must support multiple parking lots and thousands of slots
- **Consistency:** Strong consistency for slot allocation and release
- **Availability:** High availability or Entry/Exit even during payment gateway failures
- **Latency:** Low latency (<500ms) for Ticket generation & exit processing
- **Extensibility:** Easily add new vehicle types, pricing strategies, or gateways
- **Security:** Role-based access for admin actions. 


## Edge Cases:
- Emergency vehicle request during signal change
    - Duration based (preferred)
    - manual on/off
- Invalid signal state transitions (handled by State Pattern)
- Cycle pause/resume during emergency
    - resume from left over time (15s remaining off 30secs, start from 15secs)
    - resume from 0 (for simpliciity prefer this)