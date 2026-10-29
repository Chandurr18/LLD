package com.lld.practice.CarRental.model;

import com.lld.practice.CarRental.enums.VehicleType;

public class SUV extends Vehicle{
    public SUV(String licensePlate, double pricePerHour, double pricePerkm) {
        super(licensePlate, pricePerHour, pricePerkm, VehicleType.SUV);
    }
}
