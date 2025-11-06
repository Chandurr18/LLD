package SOLIDPrinciples.SingleResponsibilityPrinciple.Solution;

/**
 * Responsible ONLY for sending emails.
 */
public class EmailService {

    public void sendEmail(String to, String content){
        // SMTP configuration logic
        System.out.println("Sending email to: " + to);
        System.out.println("Content: " + content);
    }
}
