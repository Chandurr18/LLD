/**
 * HeavyReportGenerator (Problem)
 * Simulates a heavyweight PDF renderer that always initializes during construction.
 */
public class HeavyReportGenerator {
    public HeavyReportGenerator() {
        System.out.println("[HeavyReportGenerator] Initializing large PDF engine... (heavy)");
        // simulate heavy init
    }

    public String generateReport(String reportId) {
        System.out.println("[HeavyReportGenerator] Generating report " + reportId);
        return "PDF(" + reportId + ")";
    }
}
