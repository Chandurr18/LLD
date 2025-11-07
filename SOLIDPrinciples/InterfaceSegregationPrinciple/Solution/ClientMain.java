package SOLIDPrinciples.InterfaceSegregationPrinciple.Solution;

/**
 * Demonstrates violation of Interface Segregation Principle.
 */
public class ClientMain {
    public static void main(String[] args) {
        EmailService emailService = new EmailNotification();
        SmsService smsService = new SmsNotification();
        PushService pushService = new PushNotification();

        emailService.sendEmail("Welcome to the platform!");
        smsService.sendSms("Your OTP is 987654");
        pushService.sendPushNotification("You have a new message!");
    }
}
