package SOLIDPrinciples.InterfaceSegregationPrinciple.Solution;

/**
 * Interface for Push notifications only.
 */
public interface PushService {
    void sendPushNotification(String message);
}
