package DesignPatterns.StructuralPattern.Proxy.Solution.VirtualProxy;

/**
 * Virtual proxy delaying RealReportGenerator creation until generateReport() is called.
 */
public class ReportGeneratorProxy implements ReportGenerator {
    private RealReportGenerator real;

    @Override
    public String generateReport(String reportId) {
        if (real == null) {
            System.out.println("[ReportGeneratorProxy] Lazy initializing RealReportGenerator...");
            real = new RealReportGenerator();
        }
        return real.generateReport(reportId);
    }
}
