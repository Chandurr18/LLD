/**
 * Customer notification service (email/SMS/push).
 * In the Problem version, this is called directly by OrderService.
 */
public class CustomerNotificationService {

    public void notifyCustomer(Order order) {
        System.out.println("[CustomerNotificationService] Customer notified: Order " 
                + order.getOrderId() + " is now " + order.getStatus());
    }
}
