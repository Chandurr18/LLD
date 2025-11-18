/**
 * ImageProcessingService (Problem)
 * In the bad design client calls a local implementation that actually must be remote.
 */
public class ImageProcessingService {
    public String processImage(String imageId) {
        System.out.println("[ImageProcessingService] Processing image locally: " + imageId);
        return "processed-" + imageId;
    }
}
