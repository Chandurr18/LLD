/**
 * Iterator that traverses orders sequentially.
 */
public class OrderListIterator implements OrderIterator {

    private final DatabaseOrderRepository repository; // Source repository
    private int index = 0;                            // Current traversal position

    public OrderListIterator(DatabaseOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean hasNext() {
        return index < repository.size();  // True if more orders exist
    }

    @Override
    public Order next() {
        return repository.get(index++);    // Returns next order
    }
}
