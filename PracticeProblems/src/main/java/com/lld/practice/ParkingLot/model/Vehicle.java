package com.lld.practice.ParkingLot.model;

import com.lld.practice.ParkingLot.enums.VehicleType;

public interface Vehicle {
    public String getNumber();

    public VehicleType getType();
}