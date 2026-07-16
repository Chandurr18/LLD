# Architecture (Parking Lot Example)

- **Domain** → represents the business objects (Vehicle , Ticket , ParkingSpot , Floor)

- **Controller** → Clients comunicate with this controllers (EntryController, ExitController, AdminController etc.,)...

- **Service** → executes business workflows (EntryService, ExitService, PaymentService) etc...

- **Strategy** → chooses an algorithm(AllocationStrategy, PricingStrategy etc)

- **Repository**  → manages entity persistence, in simple words stores data(TicketRepository, ParkingSpotRepository, FloorRepository)

- **Adapter** → talks to external systems or third party libraries or legacy systems
(PaymentAdapter, RazorPayAdapter, etc)
