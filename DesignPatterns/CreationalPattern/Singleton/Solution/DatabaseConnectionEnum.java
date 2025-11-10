package DesignPatterns.CreationalPattern.Singleton.Solution;

/**
 * ✅ Enum Singleton:
 * Simplest and safest. Handles serialization and reflection internally.
 * Best Practise in Industry.
 */
public enum DatabaseConnectionEnum {
    INSTANCE;

    DatabaseConnectionEnum(){
        System.out.println("Enum DB connection established.");
    }

    public void query(String sql) {
        System.out.println("ENUM executing: " + sql);
    }
}
