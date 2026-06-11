package controller;

import java.util.Collection;

import domain.entities.Floor;
import domain.entities.ParkingLot;
import domain.entities.ParkingSpot;

public class AdminController {
    private ParkingLot lot;

    public AdminController(ParkingLot lot) {
        this.lot = lot;
    }

    public void addFloor(Floor floor) {
        lot.addFloor(floor);
    }

    public void addSlot(int floorId, ParkingSpot spot) {
        Floor floor = lot.getFloor(floorId);

        floor.addSpot(spot);
    }

    public Collection<Floor> getFloors() {
        return lot.getFloors();
    }
}
