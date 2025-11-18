package BehavioralPattern.Strategy.Solution;

/**
 * Represents an order containing weight and distance.
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
