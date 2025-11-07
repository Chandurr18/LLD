package SOLIDPrinciples.InterfaceSegregationPrinciple.Solution;

/**
 * Implements only the interface relevant to its capability.
 */
public class EmailNotification implements EmailService {

    @Override
    public void sendEmail(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}
