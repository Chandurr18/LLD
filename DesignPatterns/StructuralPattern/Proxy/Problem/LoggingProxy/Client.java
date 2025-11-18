/**
 * Client (Problem) - scattered logging or none.
 */
public class Client {
    public static void main(String[] args) {
        UserActivityService svc = new UserActivityService();
        svc.recordAction("user-1", "LOGIN");
        svc.recordAction("user-1", "VIEW_DASHBOARD");
    }
}
