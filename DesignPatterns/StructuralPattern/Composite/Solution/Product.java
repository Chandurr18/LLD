package StructuralPattern.Composite.Solution;

/**
 * Leaf class representing an individual product in the catalog.
 * Implements CatalogComponent so it can be treated uniformly with categories.
 */
public class Product implements CatalogComponent {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void showDetails() {
        System.out.println("Product: " + name + " | ₹" + price);
    }
}
