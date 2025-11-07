package SOLIDPrinciples.InterfaceSegregationPrinciple.Violation;

/**
 * EmailNotification only supports email, but is forced to implement
 * other unrelated methods — violating Interface Segregation Principle.
 */
public class EmailNotification implements NotificationService {

    @Override
    public void sendEmail(String message) {
        System.out.println("Sending EMAIL: " + message);
    }

    @Override
    public void sendSms(String message) {
        throw new UnsupportedOperationException("EmailNotification cannot send SMS!");
    }

    @Override
    public void sendPushNotification(String message) {
        throw new UnsupportedOperationException("EmailNotification cannot send Push Notifications!");
    }
}
