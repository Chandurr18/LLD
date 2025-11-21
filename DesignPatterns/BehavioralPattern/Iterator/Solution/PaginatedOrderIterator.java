import java.util.Arrays;
import java.util.List;

/**
 * Iterator simulating paginated order fetching.
 */
public class PaginatedOrderIterator implements OrderIterator {

    private final List<Order> page1 = Arrays.asList(
            new Order("ORD-201", 3000),
            new Order("ORD-202", 4100)
    );

    private final List<Order> page2 = Arrays.asList(
            new Order("ORD-203", 1500),
            new Order("ORD-204", 2200)
    );

    private int page = 1;   // Current page
    private int index = 0;  // Index within the page

    @Override
    public boolean hasNext() {
        return (page == 1 && index < page1.size()) ||
               (page == 2 && index < page2.size());  // Checks remaining items
    }

    @Override
    public Order next() {
        if (page == 1 && index < page1.size()) {
            return page1.get(index++);  // Return from page 1
        }

        if (page == 1 && index == page1.size()) {
            page = 2;   // Move to page 2
            index = 0;
        }

        return page2.get(index++);  // Return from page 2
    }
}
