package strategy.SpotAllocation;

import domain.entities.Floor;
import domain.entities.ParkingLot;
import domain.entities.ParkingSpot;
import domain.entities.Vehicle;

public class NearestSpotStrategy implements SpotAllocationStrategy {
    @Override
    public ParkingSpot findSpot(ParkingLot lot, Vehicle vehicle) {
        
        for (Floor floor : lot.getFloors()) {
            ParkingSpot spot = floor.getFreeSpot(vehicle.getVehicleType());
            if (spot != null && spot.park(vehicle))
                return spot;
        }
        return null;
    }
}
