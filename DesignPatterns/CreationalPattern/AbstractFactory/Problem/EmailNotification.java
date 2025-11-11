/**
 * International notification implementation.
 */
public class EmailNotification implements NotificationService {
    @Override
    public void notifyUser(String message) {
        System.out.println("📧 Sending Email: " + message);
    }
}
