package strategy.FeeCalculator;

import domain.entities.Ticket;

public interface FeeCalculator {
    double calculate(Ticket ticket);
}