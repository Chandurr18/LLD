package DesignPatterns.BehavioralPattern.State.Solution;

/**
 * Payment value object used by the transaction context.
 */
public class Payment {
    private final String id;
    private final double amount;

    public Payment(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() { return id; }          
    public double getAmount() { return amount; }  
}
