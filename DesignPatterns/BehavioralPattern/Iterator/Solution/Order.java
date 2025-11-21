/**
 * Represents an Order entity in the system.
 */
public class Order {
    private final String id;      // Unique order ID
    private final double amount;  // Order payment amount

    public Order(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() { return id; }          // Returns order ID
    public double getAmount() { return amount; }  // Returns order amount

    @Override
    public String toString() {
        return "Order{id=" + id + ", amount=" + amount + "}";
    }
}
