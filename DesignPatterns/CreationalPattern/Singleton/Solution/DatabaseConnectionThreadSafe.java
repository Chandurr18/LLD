package CreationalPattern.Singleton.Solution;

/**
 * ❗ Lazy Singleton with thread-safe
 */
public class DatabaseConnectionThreadSafe {

    private static volatile DatabaseConnectionThreadSafe instance;

    private DatabaseConnectionThreadSafe() {
        System.out.println("ThreadSafeSingleton initialized.");
    }

    public static DatabaseConnectionThreadSafe getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnectionThreadSafe.class) {
                if (instance == null) {
                    instance = new DatabaseConnectionThreadSafe();
                }
            }
        }
        return instance;
    }

    public void query(String sql) {
        System.out.println("LAZY executing: " + sql);
    }
}
