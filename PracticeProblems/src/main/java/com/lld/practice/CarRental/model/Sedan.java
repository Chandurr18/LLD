package com.lld.practice.CarRental.model;

import com.lld.practice.CarRental.enums.VehicleType;
import com.lld.practice.CarRental.factory.VehicleFactory;

public class Sedan extends Vehicle {
    public Sedan(String licensePlate, double pricePerHour, double pricePerkm) {
        super(licensePlate, pricePerHour, pricePerkm, VehicleType.SEDAN);
    }
}
