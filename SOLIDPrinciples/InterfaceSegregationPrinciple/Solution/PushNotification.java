package SOLIDPrinciples.InterfaceSegregationPrinciple.Solution;

/**
 * Implements only Push interface.
 */
public class PushNotification implements PushService {

    @Override
    public void sendPushNotification(String message) {
        System.out.println("Sending PUSH notification: " + message);
    }
}
