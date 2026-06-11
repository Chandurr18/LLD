package service;

import domain.entities.ParkingLot;
import domain.entities.ParkingSpot;
import domain.entities.Ticket;
import domain.entities.Vehicle;
import domain.exceptions.NoSlotFoundException;
import strategy.SpotAllocation.SpotAllocationStrategy;

public class SlotService {
    private final SpotAllocationStrategy strategy;
    private ParkingLot lot;

    public SlotService(SpotAllocationStrategy strategy, ParkingLot lot) {
        this.strategy = strategy;
        this.lot = lot;
    }

    public ParkingSpot getSpot(Vehicle vehicle) {
        ParkingSpot spot = strategy.findSpot(lot, vehicle);

        if (spot == null)
            throw new NoSlotFoundException("No Available slot for given vehicle type: " + vehicle.getVehicleType());

        return spot;
    }

    public void releaseSlot(Ticket ticket) {
        ParkingSpot spot = ticket.getParkingSpot();
        spot.removeVehicle();
    }
}
