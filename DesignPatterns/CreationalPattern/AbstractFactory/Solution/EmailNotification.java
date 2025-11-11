package DesignPatterns.CreationalPattern.AbstractFactory.Solution;

public class EmailNotification implements NotificationService {
    @Override
    public void notifyUser(String message) {
        System.out.println("📧 International Email: " + message);
    }
}
