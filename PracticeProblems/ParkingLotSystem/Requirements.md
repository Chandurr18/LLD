# Functional requirements

### Entry Flow:
- Vehicle arrives at gate
- Generate Ticket and assign Slot based on Vehicle
- Mark Slot as occupied
- Return EntryResult with success/failure status

### Exit Flow: 
- User present Ticket at gate
- Calculate fee based on pricing rules (Flat, Vehicle Based, etc)
- Process payment through Payment Gateway
- Release Slot & generate receipt
- Return ExitResult with success/failure status

### Admin Configuration
- Add/Edit/Delete Floors & Slots
- Define Pricing rules based on vehicletype(both flat and hourly rates)
- Update flat and hourly pricing for vehicle types
- View current parking status


# Non-Functional Requirements
- **Scalability:** Must support multiple parking lots and thousands of slots
- **Consistency:** Strong consistency for slot allocation and release
- **Availability:** High availability or Entry/Exit even during payment gateway failures
- **Latency:** Low latency (<500ms) for Ticket generation & exit processing
- **Extensibility:** Easily add new vehicle types, pricing strategies, or gateways
- **Security:** Role-based access for admin actions.


## Edge Cases:
- Payment Failure during exit - retry and hold slot
- Ticket Lost - allow admin override
- Clock skew - system time validation 
- slot state mismatch - periodic reconcilation