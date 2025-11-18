package DesignPatterns.StructuralPattern.Proxy.Solution.RemoteProxy;

/**
 * Remote proxy that simulates network calls, retries, and error handling.
 */
public class RemoteImageProxy implements ImageProcessor {
    private final RemoteImageService remote = new RemoteImageService();

    @Override
    public String process(String imageId) {
        System.out.println("[RemoteImageProxy] Sending request to remote service for " + imageId);
        // simulate retry/backoff logic (simplified)
        try {
            return remote.process(imageId);
        } catch (Exception e) {
            System.out.println("[RemoteImageProxy] Remote call failed, retrying once...");
            return remote.process(imageId);
        }
    }
}
