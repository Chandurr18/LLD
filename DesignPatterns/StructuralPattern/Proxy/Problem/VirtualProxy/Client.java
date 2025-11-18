/**
 * Client (Problem) - always constructs HeavyReportGenerator even if not used.
 */
public class Client {
    public static void main(String[] args) {
        HeavyReportGenerator gen = new HeavyReportGenerator(); // heavy init even if not used
        System.out.println("Client ready, now generating...");
        String pdf = gen.generateReport("RPT-001");
        System.out.println("Produced: " + pdf);
    }
}
