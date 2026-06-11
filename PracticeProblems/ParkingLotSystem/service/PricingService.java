package service;

import domain.entities.Ticket;
import strategy.FeeCalculator.FeeCalculator;

public class PricingService {
    private final FeeCalculator feeCalculator;

    public PricingService(FeeCalculator feeCalculator) {
        this.feeCalculator = feeCalculator;
    }

    public double calculateFee(Ticket ticket) {
        double fee = feeCalculator.calculate(ticket);
        return fee;
    }
}
