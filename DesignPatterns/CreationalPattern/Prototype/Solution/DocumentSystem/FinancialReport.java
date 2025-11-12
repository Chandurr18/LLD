package CreationalPattern.Prototype.Solution.DocumentSystem;

/**
 * ✅ Concrete Prototype: Financial Report
 * Demonstrates deep cloning of report templates.
 */
public class FinancialReport implements ReportPrototype {

    private String title;
    private String createdBy;
    private String period;
    private String header;
    private String footer;

    public FinancialReport(String title, String createdBy, String period, String header, String footer) {
        this.title = title;
        this.createdBy = createdBy;
        this.period = period;
        this.header = header;
        this.footer = footer;
    }

    @Override
    public ReportPrototype clone() {
        System.out.println("📄 Cloning Financial Report...");
        return new FinancialReport(this.title, this.createdBy, this.period, this.header, this.footer);
    }

    @Override
    public void print() {
        System.out.println("=== " + title + " ===");
        System.out.println("Created By: " + createdBy);
        System.out.println("Period: " + period);
        System.out.println(header);
        System.out.println("... [Report Content] ...");
        System.out.println(footer + "\n");
    }
}
