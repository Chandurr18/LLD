package strategy.payment;

import model.Ticket;

public interface PaymentStrategy {
    boolean processPayment(Ticket ticket, double amount);
}