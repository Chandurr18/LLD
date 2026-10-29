package com.lld.practice.CarRental.factory;

import com.lld.practice.CarRental.enums.VehicleType;
import com.lld.practice.CarRental.model.SUV;
import com.lld.practice.CarRental.model.Sedan;
import com.lld.practice.CarRental.model.Vehicle;

public class VehicleFactory {
    public static Vehicle create(VehicleType type, String licensePlate, double pricePerHour, double  pricePerKm) {
        return switch (type) {
            case SEDAN -> new Sedan(licensePlate, pricePerHour, pricePerKm);
            case SUV -> new SUV(licensePlate, pricePerHour, pricePerKm);
        };
    }
}
