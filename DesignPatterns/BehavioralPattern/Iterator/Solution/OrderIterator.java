/**
 * Iterator interface for order traversal.
 */
public interface OrderIterator {
    boolean hasNext();  // Checks if more orders exist
    Order next();       // Returns next order
}
