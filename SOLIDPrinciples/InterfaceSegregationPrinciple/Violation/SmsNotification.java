package SOLIDPrinciples.InterfaceSegregationPrinciple.Violation;

/**
 * SmsNotification only supports SMS but is forced to implement
 * email and push methods it doesn't need.
 */
public class SmsNotification implements NotificationService {

    @Override
    public void sendEmail(String message) {
        throw new UnsupportedOperationException("SmsNotification cannot send Email!");
    }

    @Override
    public void sendSms(String message) {
        System.out.println("Sending SMS: " + message);
    }

    @Override
    public void sendPushNotification(String message) {
        throw new UnsupportedOperationException("SmsNotification cannot send Push Notifications!");
    }
}
