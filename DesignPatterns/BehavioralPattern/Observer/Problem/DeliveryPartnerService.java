/**
 * Delivery Partner service that assigns riders or updates routing.
 */
public class DeliveryPartnerService {

    public void updateDeliveryPartner(Order order) {
        System.out.println("[DeliveryPartnerService] Delivery partner updated: Order "
                + order.getOrderId() + " is now " + order.getStatus());
    }
}
