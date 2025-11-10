/**
 * ❌ Problem:
 * Every time a new DatabaseConnection is created,
 * a separate connection instance is opened.
 *
 * Issues:
 * - Resource exhaustion (too many DB connections)
 * - Inconsistent data states
 * - Difficult connection management
 */
public class DatabaseConnection {

    public DatabaseConnection() {
        System.out.println("Establishing new database connection...");
    }

    public void query(String sql) {
        System.out.println("Executing SQL: " + sql);
    }
}
