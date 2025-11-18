package DesignPatterns.StructuralPattern.Proxy.Solution.SmartProxy;

/**
 * Subject: FileAccessor provides file read API.
 */
public interface FileAccessor {
    String readFile(String path);
    void close(String path);
}
