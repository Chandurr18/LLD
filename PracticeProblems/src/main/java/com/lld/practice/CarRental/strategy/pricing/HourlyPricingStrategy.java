package com.lld.practice.CarRental.strategy.pricing;

import com.lld.practice.CarRental.model.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPricingStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(Vehicle vehicle, LocalDateTime start, LocalDateTime end, double distanceKm) {
        long minutes = Duration.between(end, start).toMinutes();
        long hours = (long) Math.ceil(minutes / 60.0);
        return vehicle.getPricePerHour() * hours;
    }
}
