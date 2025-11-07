package SOLIDPrinciples.InterfaceSegregationPrinciple.Solution;

/**
 * Implements only SMS interface.
 */
public class SmsNotification implements SmsService {

    @Override
    public void sendSms(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
