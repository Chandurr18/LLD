package CreationalPattern.Singleton.Solution;

/**
 * ✅ Bill Pugh Singleton (Initialization-on-demand)
 * (aka Holder Singletom)
 * Lazy, thread-safe, and clean. Best class-based approach.
 */
public class DatabaseConnectionBillPugh {

    private DatabaseConnectionBillPugh() {
        System.out.println("Holder DB connection established.");
    }

    private static class Holder {
        private static final DatabaseConnectionBillPugh INSTANCE = new DatabaseConnectionBillPugh();
    }

    public static DatabaseConnectionBillPugh getInstance() {
        return Holder.INSTANCE;
    }

    public void query(String sql) {
        System.out.println("HOLDER executing: " + sql);
    }
}
