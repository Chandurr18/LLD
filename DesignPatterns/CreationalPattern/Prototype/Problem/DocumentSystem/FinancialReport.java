package CreationalPattern.Prototype.Problem.DocumentSystem;

/**
 * ❌ Problem:
 * Creating multiple FinancialReport instances is expensive.
 *
 * Issues:
 * - Heavy object construction for each instance (metadata, templates)
 * - Repeated setup cost for header/footer
 * - Difficult to manage new report variants
 */
public class FinancialReport {

    private String title;
    private String createdBy;
    private String period;
    private String header;
    private String footer;

    public FinancialReport(String title, String createdBy, String period) {
        this.title = title;
        this.createdBy = createdBy;
        this.period = period;

        // Simulating heavy initialization
        this.header = loadHeaderTemplate();
        this.footer = loadFooterTemplate();
    }

    private String loadHeaderTemplate() {
        System.out.println("⏳ Loading company header template...");
        return "[Company Confidential Report]";
    }

    private String loadFooterTemplate() {
        System.out.println("⏳ Loading legal footer template...");
        return "[All rights reserved]";
    }

    @Override
    public String toString() {
        return "Report: " + title + " (" + period + ") by " + createdBy +
               "\n" + header + "\n" + footer + "\n";
    }
}
