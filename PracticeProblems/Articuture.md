# Architecture

- **Domain** → represents the business objects (Vehicle , Ticket , ParkingSpot , Floor)

- **Controller** → Clients comunicate with this controllers (EntryController, ExitController, AdminController etc.,)...

- **Service** → executes business workflows, client only interacts with these services (EntryService, ExitService, PaymentService) etc...

- **Strategy** → chooses an algorithm(AllocationStrategy, PricingStrategy etc)

- **Repository**  → manages entity persistence(TicketRepository, ParkingSpotRepository, FloorRepository)

- **Adapter** → talks to external systems (PaymentAdapter, RazorPayAdapter, etc)
