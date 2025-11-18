package DesignPatterns.StructuralPattern.Proxy.Solution.SmartProxy;

/**
 * RealFileHandle - opens file and reads content.
 */
public class RealFileHandle implements FileAccessor {
    @Override
    public String readFile(String path) {
        System.out.println("[RealFileHandle] Opening and reading: " + path);
        return "content-of-" + path;
    }

    @Override
    public void close(String path) {
        System.out.println("[RealFileHandle] Closing: " + path);
    }
}
