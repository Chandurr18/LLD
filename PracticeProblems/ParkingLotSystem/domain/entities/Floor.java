package domain.entities;

import java.util.ArrayList;
import java.util.List;

import domain.enums.VehicleType;

public class Floor {
    private int floorId;
    private List<ParkingSpot> parkingSpots;

    public Floor(int floorId) {
        parkingSpots = new ArrayList<>();
        this.floorId = floorId;
    }

    public ParkingSpot getFreeSpot(VehicleType vehicleType) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getVehicleType() == vehicleType && spot.isFree()) {
                return spot;
            }
        }
        return null;
    }

    public void addSpot(ParkingSpot spot) {

        parkingSpots.add(spot);
    }

    public int getFloorId() {
        return floorId;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}
