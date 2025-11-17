package StructuralPattern.Composite.Solution;

/**
 * Client demonstrating usage of Composite pattern.
 * Builds a tree of categories and products and invokes showDetails() on the
 * root category.
 */
public class Client {
    public static void main(String[] args) {
        Category electronics = new Category("Electronics");
        Category laptops = new Category("Laptops");
        Category phones = new Category("Phones");

        Product mac = new Product("MacBook Pro", 180000);
        Product dell = new Product("Dell XPS", 150000);
        Product iphone = new Product("iPhone", 90000);
        Product samsung = new Product("Samsung Galaxy", 75000);

        laptops.add(mac);
        laptops.add(dell);

        phones.add(iphone);
        phones.add(samsung);

        electronics.add(laptops);
        electronics.add(phones);

        electronics.showDetails();
    }
}
