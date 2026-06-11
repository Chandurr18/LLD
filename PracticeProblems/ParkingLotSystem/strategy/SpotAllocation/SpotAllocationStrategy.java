package strategy.SpotAllocation;

import domain.entities.ParkingLot;
import domain.entities.ParkingSpot;
import domain.entities.Vehicle;

public interface SpotAllocationStrategy {
    ParkingSpot findSpot(ParkingLot lot, Vehicle vehicle);
}