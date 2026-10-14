# Requirements

## Extensible

1. What types of vehicles should our system support?
    - The system should be extensible to support different vehicle types such as bikes, cars, trucks, bus etc.,

2. Can a parking spot accomodate any vehicle?
    - No, each parking spot supports a specific vehicle type

3. How to calculate the prices for parking?
    - The system should support multiple pricing strategies like:
        - Time-based (with peak/non-peak pricing)
        - Event-based(concerts, weekends, etc.,)

4. Should system support multiple payment methods?
    - yes, The system must be extensable to accommodate various payment methods
            such as UPI/ Credit Card, Cash etc,.


## Dynamic
1. How many floors and parking spots can the parking lot have?
    - The system should allow dynamic configuration of floors and slots per floor. Each slot must be mapped to a vehicle type

2. How many gates should our system support?
    - The system should support multiple gates and exit gates
    - A ticket should be generated at entry, containing vehicle details, entry timestamp, etc.,
    - At exit, this ticket will be used to calculate the final cost1. What types of vehicles should our system support?
    - The system should be extensible to support different vehicle types such as bikes, cars, trucks, bus etc.,

## Concurrency
1. Are we building a system for just one physical parking lot or do we want to scale it to multiple lots in future?
    - Single

2. Do we need to ensure that no two vehivles get the same parking spot?
    - Yes, The system should use proper locking mechanism or synchronized access to parking slot assignment