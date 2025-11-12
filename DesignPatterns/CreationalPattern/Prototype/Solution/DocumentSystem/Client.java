package CreationalPattern.Prototype.Solution.DocumentSystem;

/**
 * Demonstrates Prototype Pattern using a Report Registry.
 */
public class Client {
    public static void main(String[] args) {

        // Step 1: Create registry and register base templates
        ReportRegistry registry = new ReportRegistry();

        FinancialReport baseFinance = new FinancialReport(
            "Financial Report Template", "Finance Dept", "Template",
            "[Company Header]", "[Confidential Footer]"
        );
        registry.register("FinancialReport", baseFinance);

        // Step 2: Clone and customize
        FinancialReport q1Report = (FinancialReport) registry.getClone("FinancialReport");
        q1Report = new FinancialReport("Q1 Report", "Finance Dept", "2025-Q1",
                                       "[Company Header]", "[Confidential Footer]");

        FinancialReport q2Report = (FinancialReport) registry.getClone("FinancialReport");
        q2Report = new FinancialReport("Q2 Report", "Finance Dept", "2025-Q2",
                                       "[Company Header]", "[Confidential Footer]");

        // Step 3: Print cloned reports
        q1Report.print();
        q2Report.print();
    }
}
