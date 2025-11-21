import java.util.ArrayList;
import java.util.List;

/**
 * Concrete aggregate holding a list of orders.
 */
public class DatabaseOrderRepository implements OrderCollection {

    private final List<Order> orders = new ArrayList<>(); // Internal order list

    public DatabaseOrderRepository() {
        orders.add(new Order("ORD-101", 2500));
        orders.add(new Order("ORD-102", 5400));
        orders.add(new Order("ORD-103", 1200));
    }

    public int size() { return orders.size(); }          // Returns count of orders
    public Order get(int index) { return orders.get(index); } // Returns order by index

    @Override
    public OrderIterator iterator() {
        return new OrderListIterator(this);  // Returns a sequential iterator
    }
}
