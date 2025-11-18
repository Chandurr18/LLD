package DesignPatterns.StructuralPattern.Proxy.Solution.VirtualProxy;

/**
 * Subject: ReportGenerator
 * Provides report generation API; implemented by Real generator and VirtualProxy.
 */
public interface ReportGenerator {
    String generateReport(String reportId);
}
