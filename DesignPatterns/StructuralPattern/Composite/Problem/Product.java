package StructuralPattern.Composite.Problem;

/**
 * Product (Bad Design) - Plain product class without any Component abstraction.
 * This file demonstrates a naive design where products and categories are not treated uniformly.
 */
public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    public void printDetails() {
        System.out.println("Product: " + name + " | ₹" + price);
    }
}
