package SOLIDPrinciples.InterfaceSegregationPrinciple.Solution;

/**
 * Interface for SMS notifications only.
 */
public interface SmsService {
    void sendSms(String message);
}
