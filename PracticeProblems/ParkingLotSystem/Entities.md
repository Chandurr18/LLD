# Entities Reference

## Core Entities (Domain)

### 1. ParkingLot

* int parkingLotID
* Map<Integer, Floor> floors

Methods:

* addFloor(Floor floor)
* Collection<Floor> getFloors()
* Floor getFloor(int floorId)
* int getId()

---

### 2. Floor

* int floorId
* List<ParkingSpot> parkingSpots

Methods:

* ParkingSpot getFreeSpot(VehicleType vehicleType)
* addSpot(ParkingSpot spot)
* int getFloorId()
* List<ParkingSpot> getParkingSpots()

---

### 3. ParkingSpot

* int parkingSpotId
* VehicleType vehicleType
* Vehicle parkedVehicle

Methods:

* synchronized boolean park(Vehicle vehicle)
* synchronized boolean isFree()
* synchronized void removeVehicle()
* int getParkingSpotId()
* VehicleType getVehicleType()

---

### 4. Vehicle

* String licenseNumber
* VehicleType vehicleType

Methods:

* String getLicenseNumber()
* VehicleType getVehicleType()

---

### 5. Ticket

* String ticketId
* Vehicle vehicle
* ParkingSpot spot
* long entryTime

Methods:

* String getTicketId()
* Vehicle getVehicle()
* ParkingSpot getParkingSpot()
* long getEntryTime()

---

# Controllers

### 6. AdminController

* ParkingLot lot

Methods:

* addFloor(Floor floor)
* addSlot(int floorId, ParkingSpot spot)
* Collection<Floor> getFloors()

---

### 7. EntryController

Dependencies:

* TicketService ticketService
* SlotService slotService

Methods:

* EntryResult enterVehicle(String licenseNumber, VehicleType vehicleType)

---

### 8. ExitController

Dependencies:

* TicketService ticketService
* PricingService pricingService
* PaymentService paymentService
* SlotService slotService

Methods:

* ExitResult exitVehicle(String ticketId)

---

# DTOs

### 9. EntryResult

* boolean isSuccess
* String ticketId
* int spotId
* String message

Methods:

* boolean isSuccess()
* String getTicketId()
* int getSpotId()
* String getMessage()

---

### 10. ExitResult

* boolean isSuccess
* String ticketId
* double fee
* String message

Methods:

* boolean isSuccess()
* String getTicketId()
* double getFee()
* String getMessage()

---

# Services

### 11. SlotService

Dependencies:

* SpotAllocationStrategy strategy
* ParkingLot lot

Methods:

* ParkingSpot getSpot(Vehicle vehicle)
* void releaseSlot(Ticket ticket)

---

### 12. TicketService

Dependencies:

* AtomicInteger tid
* TicketRepository ticketRepository

Methods:

* Ticket generateTicket(Vehicle vehicle, ParkingSpot spot)
* Ticket getTicketByID(String ticketId)
* synchronized void removeActiveTicket(String ticketId)

---

### 13. PricingService

Dependencies:

* FeeCalculator feeCalculator

Methods:

* double calculateFee(Ticket ticket)

---

### 14. PaymentService

Dependencies:

* PaymentServiceAdapter paymentServiceAdapter

Methods:

* boolean processPayment(double amount)

---

# Repository

### 15. TicketRepository

* ConcurrentHashMap<String, Ticket> activeTickets

Methods:

* save(Ticket ticket)
* Ticket getTicketByID(String ticketId)
* removeTicket(String ticketId)

---

# Strategy Pattern

### 16. SpotAllocationStrategy

Methods:

* ParkingSpot findSpot(ParkingLot lot, Vehicle vehicle)

Implementation:

* NearestSpotStrategy

---

### 17. NearestSpotStrategy

Methods:

* ParkingSpot findSpot(ParkingLot lot, Vehicle vehicle)

---

### 18. FeeCalculator

Methods:

* double calculate(Ticket ticket)

Implementation:

* HourlyFeeCalculator

---

### 19. HourlyFeeCalculator

Methods:

* double calculate(Ticket ticket)

---

# Adapter Pattern

### 20. PaymentServiceAdapter

Methods:

* void pay(double amount)

Implementations:

* RazorPayAdapter
* StripePayAdapter

---

# Enums

### 21. VehicleType

Values:

* CAR
* BIKE
* TRUCK
* EV

---

# Exceptions

### 22. NoSlotFoundException

Constructors:

* NoSlotFoundException()
* NoSlotFoundException(String message)

Used when:

* No parking spot is available for the requested vehicle type.
