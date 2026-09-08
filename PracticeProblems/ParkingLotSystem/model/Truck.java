package model;

import enums.VehicleType;

public class Truck implements Vehicle {
    protected final String number;

    public Truck(String number){
        this.number = number;
    }

    @Override
    public String getNumber() {
        return this.number;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
