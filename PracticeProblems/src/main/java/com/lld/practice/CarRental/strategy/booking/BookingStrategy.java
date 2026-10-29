package com.lld.practice.CarRental.strategy.booking;

import com.lld.practice.CarRental.model.Vehicle;

import java.util.List;

public interface BookingStrategy {
    Vehicle bookVehicle(List<Vehicle> vehicles);
}
