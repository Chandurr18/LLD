package DesignPatterns.CreationalPattern.Singleton.Solution;

/**
 * ✅ Thread-safe Lazy Singleton (Double-Checked Locking)
 * Efficient after initialization.
 * Volatile keyword ensures that changes to the instance variable are immediately visible to other threads.
 */
public class DatabaseConnectionDCL {

    private static volatile DatabaseConnectionDCL instance;

    private DatabaseConnectionDCL() {
        System.out.println("DCL DB connection established.");
    }

    public static DatabaseConnectionDCL getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnectionDCL.class) {
                if (instance == null) {
                    instance = new DatabaseConnectionDCL();
                }
            }
        }
        return instance;
    }

    public void query(String sql) {
        System.out.println("DCL executing: " + sql);
    }
}
