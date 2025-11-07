package SOLIDPrinciples.InterfaceSegregationPrinciple.Violation;

/**
 * This interface violates ISP by forcing all notification types
 * to implement methods they don't use.
 */
public interface NotificationService {
    void sendEmail(String message);
    void sendSms(String message);
    void sendPushNotification(String message);
}
