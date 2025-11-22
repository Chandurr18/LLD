package DesignPatterns.BehavioralPattern.State.Problem;

/**
 * Simple payment value object used in the naive implementation.
 */
public class Payment {
    private final String id;
    private final double amount;
    public enum Status { PENDING, PROCESSING, COMPLETED, FAILED, REFUNDED }

    public Payment(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }
}
