package model;

import enums.VehicleType;

public class Bike implements  Vehicle {
    protected final String number;

    public Bike(String number){
        this.number = number;
    }

    @Override
    public String getNumber() {
        return this.number;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BIKE;
    }
}
