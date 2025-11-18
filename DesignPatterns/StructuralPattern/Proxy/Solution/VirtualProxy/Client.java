package DesignPatterns.StructuralPattern.Proxy.Solution.VirtualProxy;

/**
 * Client using ReportGenerator abstraction.
 */
public class Client {
    public static void main(String[] args) {
        ReportGenerator gen = new ReportGeneratorProxy();
        System.out.println("Client initialized, no heavy init yet.");
        System.out.println(gen.generateReport("RPT-001"));
    }
}
