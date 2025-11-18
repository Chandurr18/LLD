/**
 * Represents an order with weight and distance attributes.
 */
public class Order {
    private double weightKg;
    private double distanceKm;

    public Order(double weightKg, double distanceKm) {
        this.weightKg = weightKg;
        this.distanceKm = distanceKm;
    }

    public double getWeightKg() { return weightKg; }
    public double getDistanceKm() { return distanceKm; }
}
