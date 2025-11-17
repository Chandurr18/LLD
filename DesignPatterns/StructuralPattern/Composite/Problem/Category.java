package StructuralPattern.Composite.Problem;

/**
 * Category (Bad Design) - Holds products only and exposes product list directly.
 * This design couples client code to the category implementation and requires special handling for categories.
 */
import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Product> products = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public void addProduct(Product p) { products.add(p); }
    public void removeProduct(Product p) { products.remove(p); }

    public List<Product> getProducts() { return products; }
    public String getName() { return name; }

    public void printCategory() {
        System.out.println("Category: " + name);
        for (Product p : products) {
            p.printDetails();
        }
    }
}
