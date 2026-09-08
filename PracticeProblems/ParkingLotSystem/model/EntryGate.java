package model;

import java.time.LocalDateTime;

import enums.GateType;
import service.ParkingLot;

public class EntryGate extends Gate {

    public EntryGate(String id) {
        super(id);
    }

    @Override
    public GateType getType() {
        return GateType.ENTRY;
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime) {
        return ParkingLot.INSTANCE.parkVehicle(vehicle, entryTime);
    }
}