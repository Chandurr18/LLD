package controller;

import controller.dto.EntryResult;
import domain.entities.ParkingSpot;
import domain.entities.Ticket;
import domain.entities.Vehicle;
import domain.enums.VehicleType;
import service.TicketService;
import service.SlotService;


public class EntryController {
    private TicketService ticketService;
    private SlotService slotService;

    public EntryController(TicketService ticketService, SlotService slotService){
        this.ticketService = ticketService;
        this.slotService = slotService;
        System.out.println("[CONTROLLER] EntryController Initialted");
    }

    public EntryResult enterVehicle(String licenseNumber, VehicleType vehicleType){
        System.out.println("[CONTROLLER] vehicle entry request - licenseNumber: " + licenseNumber + ". Type: " + vehicleType);

        try{
            // Create Vehicle
            Vehicle vehicle = new Vehicle(licenseNumber, vehicleType);

            // Allocate Slot
            ParkingSpot spot = slotService.getSpot(vehicle);

            Ticket ticket = ticketService.generateTicket(vehicle, spot);

            System.out.println("[CONTROLLER] vehicile enter successfull - Ticket:" + ticket.getTicketId() + ", Slot: " + spot.getParkingSpotId());

            return new EntryResult(true, ticket.getTicketId(), spot.getParkingSpotId(), "Entry Successfull");

        } catch(Exception e){
            return new EntryResult(false, null, -1, e.getMessage());
        }
    }

    
}
