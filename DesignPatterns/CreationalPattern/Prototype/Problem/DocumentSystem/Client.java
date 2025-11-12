package CreationalPattern.Prototype.Problem.DocumentSystem;

/**
 * Demonstrates a problem when creating multiple heavy report objects manually.
 * Every report initialization re-computes heavy metadata and formatting.
 */
public class Client {
    public static void main(String[] args) {

        FinancialReport q1 = new FinancialReport("Q1 Report", "Finance Dept", "2025-Q1");
        FinancialReport q2 = new FinancialReport("Q2 Report", "Finance Dept", "2025-Q2");

        System.out.println(q1);
        System.out.println(q2);
    }
}
