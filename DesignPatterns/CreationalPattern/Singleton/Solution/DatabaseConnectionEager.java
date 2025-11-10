package DesignPatterns.CreationalPattern.Singleton.Solution;

/**
 * ✅ Eager Singleton:
 * Instance created during class loading.
 * Simple and thread-safe, but not lazy.
 */
public class DatabaseConnectionEager {

    private static final DatabaseConnectionEager INSTANCE = new DatabaseConnectionEager();

    private DatabaseConnectionEager() {
        System.out.println("Eager DB connection established.");
    }

    public static DatabaseConnectionEager getInstance() {
        return INSTANCE;
    }

    public void query(String sql) {
        System.out.println("EAGER executing: " + sql);
    }
}
