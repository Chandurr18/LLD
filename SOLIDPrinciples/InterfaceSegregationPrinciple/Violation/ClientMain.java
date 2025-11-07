package SOLIDPrinciples.InterfaceSegregationPrinciple.Violation;

/**
 * Demonstrates violation of Interface Segregation Principle.
 */
public class ClientMain {
    public static void main(String[] args) {
        NotificationService emailService = new EmailNotification();
        emailService.sendEmail("Welcome to LLD!");
        emailService.sendSms("This will fail!"); // ❌ Not supported
    }
}
