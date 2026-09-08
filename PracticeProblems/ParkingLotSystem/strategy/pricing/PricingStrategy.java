package strategy.pricing;

import java.time.LocalDateTime;

import enums.VehicleType;

public interface PricingStrategy {
    double calculateFee(VehicleType type, LocalDateTime entryTime, LocalDateTime exitTime);
}