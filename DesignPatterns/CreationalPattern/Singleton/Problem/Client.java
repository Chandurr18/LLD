/**
 * Demonstrates multiple independent DatabaseConnection instances.
 * Each new call opens a fresh connection.
 */
public class Client {
    public static void main(String[] args) {

        DatabaseConnection conn1 = new DatabaseConnection();
        DatabaseConnection conn2 = new DatabaseConnection();

        System.out.println("conn1 hash: " + conn1.hashCode());
        System.out.println("conn2 hash: " + conn2.hashCode());
    }
}
