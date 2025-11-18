package DesignPatterns.StructuralPattern.Proxy.Solution.RemoteProxy;

/**
 * Client using remote proxy transparently.
 */
public class Client {
    public static void main(String[] args) {
        ImageProcessor proc = new RemoteImageProxy();
        System.out.println(proc.process("img-100"));
    }
}
