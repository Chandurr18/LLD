package StructuralPattern.Composite.Problem;

/**
 * Demonstrates tight coupling and manual traversal without Composite.
 * The client must know about both Product and Category and handle traversal explicitly.
 */
public class Client {
    public static void main(String[] args) {
        Category laptops = new Category("Laptops");
        Category phones = new Category("Phones");

        Product mac = new Product("MacBook Pro", 180000);
        Product dell = new Product("Dell XPS", 150000);
        Product iphone = new Product("iPhone", 90000);
        Product samsung = new Product("Samsung Galaxy", 75000);

        laptops.addProduct(mac);
        laptops.addProduct(dell);

        phones.addProduct(iphone);
        phones.addProduct(samsung);

        // Client manually prints categories and products - not uniform
        laptops.printCategory();
        phones.printCategory();
    }
}
