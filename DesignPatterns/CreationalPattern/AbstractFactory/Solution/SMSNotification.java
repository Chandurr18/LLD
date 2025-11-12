package CreationalPattern.AbstractFactory.Solution;

public class SMSNotification implements NotificationService {
    @Override
    public void notifyUser(String message) {
        System.out.println("📱 Domestic SMS: " + message);
    }
}
