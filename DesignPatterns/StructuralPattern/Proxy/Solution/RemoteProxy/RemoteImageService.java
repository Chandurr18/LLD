package DesignPatterns.StructuralPattern.Proxy.Solution.RemoteProxy;

/**
 * RemoteImageService - in real systems this would be remote; kept for contrast.
 */
public class RemoteImageService implements ImageProcessor {
    @Override
    public String process(String imageId) {
        // Simulated remote processing
        System.out.println("[RemoteImageService] (remote) processing " + imageId);
        return "remote-processed-" + imageId;
    }
}
