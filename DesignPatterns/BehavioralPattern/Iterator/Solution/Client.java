/**
 * Demonstrates iteration using different iterator implementations.
 */
public class Client {
    public static void main(String[] args) {

        System.out.println("Fetching sequential orders via OrderListIterator...");
        OrderCollection repo = new DatabaseOrderRepository();
        OrderIterator it1 = repo.iterator();  // Sequential iterator

        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        System.out.println("\nFetching orders via PaginatedOrderIterator...");
        OrderIterator it2 = new PaginatedOrderIterator(); // Paginated iterator

        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
    }
}
