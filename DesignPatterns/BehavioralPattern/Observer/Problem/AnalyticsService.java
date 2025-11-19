/**
 * Analytics system that logs order events for dashboards and KPIs.
 */
public class AnalyticsService {

    public void recordEvent(Order order) {
        System.out.println("[AnalyticsService] Event recorded: Order "
                + order.getOrderId() + " changed to " + order.getStatus());
    }
}
