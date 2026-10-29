package com.lld.practice.CarRental.strategy.booking;

import com.lld.practice.CarRental.enums.PricingStrategyType;
import com.lld.practice.CarRental.model.Vehicle;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class LeastBookedVehicleStrategy implements  BookingStrategy{
    @Override
    public Vehicle bookVehicle(List<Vehicle> vehicles) {
        List<Vehicle> sortedVehicles = vehicles.stream()
                .sorted(Comparator.comparingInt(Vehicle::getBookingCount)).toList();


        // try booking each vehicle atomically
        for(Vehicle vehicle : sortedVehicles) {
            if(vehicle.getIsBooked().compareAndSet(false, true)) {
                return vehicle;
            }
        }

        return null;
    }
}
