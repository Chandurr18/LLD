package DesignPatterns.StructuralPattern.Proxy.Solution.SmartProxy;

/**
 * Client demonstrates smart proxy reference counting and auto-close.
 */
public class Client {
    public static void main(String[] args) {
        FileAccessor accessor = new FileAccessorSmartProxy();
        System.out.println(accessor.readFile("/var/log/app.log"));
        // second reference
        System.out.println(accessor.readFile("/var/log/app.log"));
        accessor.close("/var/log/app.log");
        accessor.close("/var/log/app.log"); // should auto-close on last
    }
}
