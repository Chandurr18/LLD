package HouseExample;

/**
 * Demonstrates constructor telescoping problem.
 */
public class Client {
    public static void main(String[] args) {
        // Difficult to read and maintain
        House villa = new House(true, true, 2, "Tiled", true, false);
        House apartment = new House(false, false, 10, "Concrete", false, true);

        System.out.println(villa);
        System.out.println(apartment);
    }
}
