package com.lld.practice.ParkingLot.strategy.pricing;

import java.time.LocalDateTime;

import com.lld.practice.ParkingLot.enums.VehicleType;

public interface PricingStrategy {
    double calculateFee(VehicleType type, LocalDateTime entryTime, LocalDateTime exitTime);
}