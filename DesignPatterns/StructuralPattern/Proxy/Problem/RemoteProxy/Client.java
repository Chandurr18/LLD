/**
 * Client (Problem) - assumes local processing, no network handling or retries.
 */
public class Client {
    public static void main(String[] args) {
        ImageProcessingService svc = new ImageProcessingService();
        String out = svc.processImage("img-001");
        System.out.println("Result: " + out);
    }
}
