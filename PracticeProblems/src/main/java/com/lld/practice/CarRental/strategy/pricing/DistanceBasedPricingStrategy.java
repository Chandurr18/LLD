package com.lld.practice.CarRental.strategy.pricing;

import com.lld.practice.CarRental.model.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;

public class DistanceBasedPricingStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(Vehicle vehicle, LocalDateTime start, LocalDateTime end, double distanceKm) {
        return vehicle.getPricePerHour() * distanceKm;
    }
}
