package strategy.FeeCalculator;

import domain.entities.Ticket;

public class HourlyFeeCalculator implements FeeCalculator {

    @Override
    public double calculate(Ticket ticket) {
        long durationMs = System.currentTimeMillis() - ticket.getEntryTime();
        long hours = Math.max(1, durationMs / (1000 * 60 * 60));
        return hours * 10; // flat 10/hour
    }

}
