import java.util.ArrayList;
import java.util.List;

/**
 * ❌ Problem:
 * Exposes internal list of orders directly.
 * Clients iterate manually and become tightly coupled to storage.
 */
public class OrderRepository {

    // Internal list exposed directly → violation
    public List<Order> orders = new ArrayList<>();

    public OrderRepository() {
        orders.add(new Order("ORD-101", 2500));
        orders.add(new Order("ORD-102", 5400));
        orders.add(new Order("ORD-103", 1200));
    }
}
