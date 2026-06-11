package domain.entities;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int parkingLotID;
    private Map<Integer, Floor> floors;

    public ParkingLot(int parkingLotId) {
        this.floors = new HashMap<>();
        this.parkingLotID = parkingLotId;
    }

    public void addFloor(Floor floor) {
        floors.put(floor.getFloorId(), floor);
    }

    public Collection<Floor> getFloors() {
        return floors.values();
    }

    public Floor getFloor(int floorId) {
        return floors.get(floorId);
    }

    public int getId() {
        return parkingLotID;
    }
}
