package com.lld.practice.ParkingLot.factory;

import com.lld.practice.ParkingLot.enums.PricingStrategyType;
import com.lld.practice.ParkingLot.strategy.pricing.EventBasedPricing;
import com.lld.practice.ParkingLot.strategy.pricing.PricingStrategy;
import com.lld.practice.ParkingLot.strategy.pricing.TimeBasedPricing;

public class PricingStrategyFactory {
    public static PricingStrategy get(PricingStrategyType type) {
        return switch (type) {
            case TIME_BASED -> new TimeBasedPricing();
            case EVENT_BASED -> new EventBasedPricing();
        };
    }
}
