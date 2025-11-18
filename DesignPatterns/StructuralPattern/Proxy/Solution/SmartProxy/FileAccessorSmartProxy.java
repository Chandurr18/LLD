package DesignPatterns.StructuralPattern.Proxy.Solution.SmartProxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Smart proxy that tracks references and auto-closes resources.
 */
public class FileAccessorSmartProxy implements FileAccessor {
    private final RealFileHandle real = new RealFileHandle();
    private final Map<String, Integer> refs = new HashMap<>();

    @Override
    public String readFile(String path) {
        refs.put(path, refs.getOrDefault(path, 0) + 1);
        System.out.println("[FileAccessorSmartProxy] Reference count for " + path + " = " + refs.get(path));
        return real.readFile(path);
    }

    @Override
    public void close(String path) {
        int c = refs.getOrDefault(path, 0) - 1;
        if (c <= 0) {
            refs.remove(path);
            real.close(path);
            System.out.println("[FileAccessorSmartProxy] Auto-closed " + path);
        } else {
            refs.put(path, c);
            System.out.println("[FileAccessorSmartProxy] Decremented refs for " + path + " = " + c);
        }
    }
}
