package SOLIDPrinciples.InterfaceSegregationPrinciple.Solution;

/**
 * Interface for email notifications only.
 */
public interface EmailService {
    void sendEmail(String message);
}
