package com.lld.practice.CarRental.model;

import com.lld.practice.CarRental.enums.VehicleStatus;
import com.lld.practice.CarRental.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicBoolean;

@Getter
@Setter
public abstract class Vehicle {
    private String licensePlate;
    private VehicleStatus status;
    private double pricePerHour;
    private double pricePerKm;
    private VehicleType type;
    private int bookingCount = 0;
    private final AtomicBoolean isBooked = new AtomicBoolean(false);

    public Vehicle(String licensePlate, double pricePerHour, double pricePerkm, VehicleType type) {
        this.licensePlate = licensePlate;
        this.pricePerHour = pricePerHour;
        this.pricePerKm = pricePerkm;
        this.status = VehicleStatus.AVAILABLE;
        this.type = type;
    }

    public void incrementBookingCount() { this.bookingCount++; }
}
