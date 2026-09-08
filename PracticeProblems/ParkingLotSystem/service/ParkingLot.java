package service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import enums.PaymentMode;
import enums.PricingStrategyType;
import factory.PaymentStrategyFactory;
import factory.PricingStrategyFactory;
import model.ParkingFloor;
import model.ParkingSpot;
import model.Ticket;
import model.Vehicle;
import strategy.payment.PaymentStrategy;
import strategy.pricing.PricingStrategy;

public enum ParkingLot {

    INSTANCE;

    private final Map<String, ParkingFloor> floors;
    private final Map<String, Ticket> activeTickets;
    private PricingStrategy pricingStrategy;

    ParkingLot() {
        floors = new HashMap<>();
        activeTickets = new HashMap<>();
        this.pricingStrategy = PricingStrategyFactory.get(PricingStrategyType.TIME_BASED);
    }

    // Getters
    public Map<String, ParkingFloor> getFloors() {
        return floors;
    }

    public Map<String, Ticket> getActiveTickets() {
        return activeTickets;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    // Setter
    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void addFloor(ParkingFloor floor) {
        floors.put(floor.getId(), floor);
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime) {

        for (ParkingFloor floor : floors.values()) {

            ParkingSpot spot = floor.findAvailableSpot(vehicle.getType());

            if (spot != null) {

                String ticketId = UUID.randomUUID().toString();

                Ticket ticket = new Ticket(ticketId, entryTime, vehicle, floor.getId(), spot.getId());

                activeTickets.put(ticketId, ticket);

                System.out.println(
                        "Vehicle parked. Ticket: " + ticketId);

                return ticket;
            }
        }

        System.out.println(
                "No spot available for vehicle type: "
                        + vehicle.getType());

        return null;
    }

    public void unparkVehicle(
            String ticketId,
            LocalDateTime exitTime,
            PaymentMode paymentMode) {

        Ticket ticket = activeTickets.get(ticketId);

        if (ticket == null) {
            System.out.println("Invalid ticket ID.");
            return;
        }

        double fee = pricingStrategy.calculateFee(
                ticket.getVehicle().getType(),
                ticket.getEntryTime(),
                exitTime);

        PaymentStrategy strategy = PaymentStrategyFactory.get(paymentMode);

        PaymentProcessor processor = new PaymentProcessor(strategy);

        boolean paid = processor.pay(ticket, fee);

        if (!paid) {
            System.out.println(
                    "Vehicle cannot exit. Payment unsuccessful.");
            return;
        }

        ParkingSpot spot = floors.get(ticket.getFloorId())
                .getSpots()
                .get(ticket.getSpotId());

        spot.vacate();

        activeTickets.remove(ticketId);

        System.out.println(
                "Vehicle exited. Fee charged: ₹" + fee);
    }

    public void printStatus() {

        floors.forEach((floorId, floor) -> {

            System.out.println("Floor: " + floorId);

            floor.getSpots().values().forEach(spot -> {

                System.out.println(
                        " Spot " + spot.getId()
                                + " [" + spot.getAllowedType() + "] - "
                                + (spot.isOccupied()
                                        ? "Occupied"
                                        : "Free"));
            });
        });
    }
}