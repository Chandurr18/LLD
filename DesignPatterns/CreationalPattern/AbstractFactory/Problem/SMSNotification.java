/**
 * Domestic notification implementation.
 */
public class SMSNotification implements NotificationService {
    @Override
    public void notifyUser(String message) {
        System.out.println("📱 Sending SMS: " + message);
    }
}
