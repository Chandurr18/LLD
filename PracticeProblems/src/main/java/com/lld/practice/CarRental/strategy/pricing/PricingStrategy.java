package com.lld.practice.CarRental.strategy.pricing;

import com.lld.practice.CarRental.model.Vehicle;

import java.time.LocalDateTime;

public interface PricingStrategy {
    double calculatePrice(Vehicle vehicle, LocalDateTime start, LocalDateTime end, double distanceKm);
}
