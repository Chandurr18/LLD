/**
 * UserActivityService (Problem)
 * Service performs actions but no centralized logging is done.
 */
public class UserActivityService {
    public void recordAction(String userId, String action) {
        System.out.println("[UserActivityService] Action: " + userId + " -> " + action);
    }
}
