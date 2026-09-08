package factory;

import enums.PricingStrategyType;
import strategy.pricing.EventBasedPricing;
import strategy.pricing.PricingStrategy;
import strategy.pricing.TimeBasedPricing;

public class PricingStrategyFactory {
    public static PricingStrategy get(PricingStrategyType type) {
        return switch (type) {
            case TIME_BASED -> new TimeBasedPricing();
            case EVENT_BASED -> new EventBasedPricing();
        };
    }
}
