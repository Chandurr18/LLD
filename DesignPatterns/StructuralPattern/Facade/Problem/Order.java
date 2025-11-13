package StructuralPattern.Facade.Problem;

/**
 * Simple Order model used for demonstration.
 */
public class Order {
    private String orderId;
    private String product;
    private int quantity;
    private double amount;

    public Order(String orderId, String product, int quantity, double amount) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getOrderId() { return orderId; }
    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getAmount() { return amount; }
}
