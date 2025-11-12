package CreationalPattern.Singleton.Solution;

/**
 * Demonstrates various Singleton implementations.
 */
public class Client {
    public static void main(String[] args) {

        System.out.println("Eager:");
        var e1 = DatabaseConnectionEager.getInstance();
        var e2 = DatabaseConnectionEager.getInstance();
        System.out.println(e1 == e2);

        System.out.println("\nStatic Block:");
        var s1 = DatabaseConnectionStaticBlock.getInstance();
        var s2 = DatabaseConnectionStaticBlock.getInstance();
        System.out.println(s1 == s2);

        System.out.println("\nLazy:");
        var l1 = DatabaseConnectionLazy.getInstance();
        var l2 = DatabaseConnectionLazy.getInstance();
        System.out.println(l1 == l2);

        System.out.println("\nThreadSafe:");
        var t1 = DatabaseConnectionThreadSafe.getInstance();
        var t2 = DatabaseConnectionThreadSafe.getInstance();
        System.out.println(t1 == t2);

        System.out.println("\nDouble-Checked Locking:");
        var d1 = DatabaseConnectionDCL.getInstance();
        var d2 = DatabaseConnectionDCL.getInstance();
        System.out.println(d1 == d2);

        System.out.println("\nBill Pugh:");
        var bp1 = DatabaseConnectionBillPugh.getInstance();
        var bp2 = DatabaseConnectionBillPugh.getInstance();
        System.out.println(bp1 == bp2);

        System.out.println("\nEnum:");
        var en1 = DatabaseConnectionEnum.INSTANCE;
        var en2 = DatabaseConnectionEnum.INSTANCE;
        System.out.println(en1 == en2);

        // Demonstrate query
        bp1.query("SELECT * FROM users;");
    }
}
