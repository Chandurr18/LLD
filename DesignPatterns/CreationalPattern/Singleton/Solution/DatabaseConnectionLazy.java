package CreationalPattern.Singleton.Solution;

/**
 * ❗ Lazy Singleton (non-thread-safe)
 * Suitable only for single-threaded contexts.
 */
public class DatabaseConnectionLazy {

    private static DatabaseConnectionLazy instance;

    private DatabaseConnectionLazy() {
        System.out.println("Lazy DB connection established.");
    }

    public static DatabaseConnectionLazy getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionLazy();
        }
        return instance;
    }

    public void query(String sql) {
        System.out.println("LAZY executing: " + sql);
    }
}
