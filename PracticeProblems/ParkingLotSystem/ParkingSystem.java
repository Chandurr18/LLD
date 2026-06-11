import adapter.PaymentServiceAdapter;
import adapter.RazorPayAdapter;
import controller.AdminController;
import controller.EntryController;
import controller.ExitController;
import controller.dto.EntryResult;
import controller.dto.ExitResult;
import domain.entities.Floor;
import domain.entities.ParkingLot;
import domain.entities.ParkingSpot;
import domain.enums.VehicleType;
import repository.TicketRepository;
import service.PaymentService;
import service.PricingService;
import service.SlotService;
import service.TicketService;
import strategy.FeeCalculator.FeeCalculator;
import strategy.FeeCalculator.HourlyFeeCalculator;
import strategy.SpotAllocation.NearestSpotStrategy;
import strategy.SpotAllocation.SpotAllocationStrategy;

public class ParkingSystem {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(12345);

        // Repositories
        TicketRepository ticketRepository = new TicketRepository();

        // Strategies
        SpotAllocationStrategy spotAllocationStrategy = new NearestSpotStrategy();
        FeeCalculator feeCalculator = new HourlyFeeCalculator();

        // Adapters
        PaymentServiceAdapter paymentServiceAdapter = new RazorPayAdapter();

        // Services
        TicketService ticketService = new TicketService(ticketRepository);
        SlotService slotService = new SlotService(spotAllocationStrategy, parkingLot);
        PricingService pricingService = new PricingService(feeCalculator);
        PaymentService paymentService = new PaymentService(paymentServiceAdapter);

        // Controllers
        AdminController adminController = new AdminController(parkingLot);
        EntryController entryController = new EntryController(ticketService, slotService);
        ExitController exitController = new ExitController(ticketService, pricingService, paymentService,
                slotService);

        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        Floor floor3 = new Floor(3);

        ParkingSpot spot1 = new ParkingSpot(21, VehicleType.BIKE);
        ParkingSpot spot2 = new ParkingSpot(22, VehicleType.CAR);
        ParkingSpot spot3 = new ParkingSpot(23, VehicleType.TRUCK);
        ParkingSpot spot4 = new ParkingSpot(24, VehicleType.BIKE);
        ParkingSpot spot5 = new ParkingSpot(25, VehicleType.CAR);
        ParkingSpot spot6 = new ParkingSpot(26, VehicleType.EV);

        floor1.addSpot(spot1);
        floor1.addSpot(spot2);
        floor1.addSpot(spot3);

        floor2.addSpot(spot4);
        floor2.addSpot(spot5);

        floor3.addSpot(spot6);

        adminController.addFloor(floor1);
        adminController.addFloor(floor2);
        adminController.addFloor(floor3);

        System.out.println();
        EntryResult entryResult1 = entryController.enterVehicle("Vehicle-1", VehicleType.BIKE);
        System.out.println(
                entryResult1.getTicketId() + " | " + entryResult1.getSpotId() + " | "
                        + entryResult1.getMessage());

        System.out.println();
        EntryResult entryResult2 = entryController.enterVehicle("Vehicle-2", VehicleType.BIKE);
        System.out.println(
                entryResult2.getTicketId() + " | " + entryResult2.getSpotId() + " | "
                        + entryResult2.getMessage());

        System.out.println();
        EntryResult entryResult3 = entryController.enterVehicle("Vehicle-3", VehicleType.BIKE);
        System.out.println(
                entryResult3.getTicketId() + " | " + entryResult3.getSpotId() + " | "
                        + entryResult3.getMessage());

        System.out.println();
        ExitResult exitResult1 = exitController.exitVehicle(entryResult1.getTicketId());
        System.out.println(exitResult1.getTicketId() + " | " + exitResult1.getFee() + " | "
                + exitResult1.getMessage());

        System.out.println();
        EntryResult entryResult4 = entryController.enterVehicle("Vehicle-4", VehicleType.BIKE);
        System.out.println(
                entryResult4.getTicketId() + " | " + entryResult4.getSpotId() + " | "
                        + entryResult4.getMessage());

        System.out.println();
        ExitResult exitResult2 = exitController.exitVehicle(entryResult2.getTicketId());
        System.out.println(exitResult2.getTicketId() + " | " + exitResult2.getFee() + " | "
                + exitResult2.getMessage());

        System.out.println();
        ExitResult exitResult3 = exitController.exitVehicle(entryResult3.getTicketId());
        System.out.println(exitResult3.getTicketId() + " | " + exitResult3.getFee() + " | "
                + exitResult3.getMessage());

    }
}
