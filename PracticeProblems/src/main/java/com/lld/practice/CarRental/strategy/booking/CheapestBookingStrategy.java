package com.lld.practice.CarRental.strategy.booking;

import com.lld.practice.CarRental.enums.PricingStrategyType;
import com.lld.practice.CarRental.model.Vehicle;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CheapestBookingStrategy implements  BookingStrategy{
    private final PricingStrategyType pricingStrategyType;

    @Override
    public Vehicle bookVehicle(List<Vehicle> vehicles) {
        List<Vehicle> sortedVehicles = vehicles.stream()
                .sorted((v1, v2) -> {
                    double val1 = pricingStrategyType == PricingStrategyType.TIME_BASED ? v1.getPricePerHour() : v1.getPricePerKm();
                    double val2 = pricingStrategyType == PricingStrategyType.TIME_BASED ? v2.getPricePerHour() : v2.getPricePerKm();
                    return Double.compare(val1, val2);
                }).toList();


        // try booking each vehicle atomically
        for(Vehicle vehicle : sortedVehicles) {
            if(vehicle.getIsBooked().compareAndSet(false, true)) {
                return vehicle;
            }
        }

        return null;
    }
}
