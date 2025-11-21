import java.util.List;

/**
 * Client tightly depends on internal list structure.
 * Any change in repository breaks this code.
 */
public class Client {
    public static void main(String[] args) {
        OrderRepository repo = new OrderRepository();

        // Client manually iterates → no abstraction
        List<Order> list = repo.orders;

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
