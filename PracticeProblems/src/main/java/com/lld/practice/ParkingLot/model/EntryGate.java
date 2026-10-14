package com.lld.practice.ParkingLot.model;

import java.time.LocalDateTime;

import com.lld.practice.ParkingLot.enums.GateType;
import com.lld.practice.ParkingLot.service.ParkingLot;

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