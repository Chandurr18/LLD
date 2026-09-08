package model;

import java.util.concurrent.atomic.AtomicBoolean;

import enums.VehicleType;

public class ParkingSpot {

    private final String id;
    private final VehicleType allowedType;

    private AtomicBoolean occupied = new AtomicBoolean(false);

    public ParkingSpot(String id, VehicleType allowedType) {
        this.id = id;
        this.allowedType = allowedType;
    }

    public String getId() {
        return id;
    }

    public VehicleType getAllowedType() {
        return allowedType;
    }

    public boolean tryOccupy() {
        return occupied.compareAndSet(false, true);
    }

    public void vacate() {
        occupied.set(false);
    }

    public boolean isOccupied() {
        return occupied.get();
    }
}
