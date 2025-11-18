package DesignPatterns.StructuralPattern.Proxy.Solution.VirtualProxy;

/**
 * RealReportGenerator - heavy initialization (simulated).
 */
public class RealReportGenerator implements ReportGenerator {
    public RealReportGenerator() {
        System.out.println("[RealReportGenerator] Initializing heavy PDF engine...");
    }

    @Override
    public String generateReport(String reportId) {
        System.out.println("[RealReportGenerator] Generating report " + reportId);
        return "PDF(" + reportId + ")";
    }
}
