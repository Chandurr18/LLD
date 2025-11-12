package CreationalPattern.Prototype.Solution.DocumentSystem;

import java.util.HashMap;
import java.util.Map;

/**
 * 🧩 Registry holding report prototypes.
 * Acts as a cache for cloning standard templates.
 */
public class ReportRegistry {

    private Map<String, ReportPrototype> reportMap = new HashMap<>();

    public void register(String key, ReportPrototype prototype) {
        reportMap.put(key, prototype);
    }

    public ReportPrototype getClone(String key) {
        ReportPrototype prototype = reportMap.get(key);
        if (prototype != null) {
            return prototype.clone();
        }
        throw new IllegalArgumentException("No prototype registered for key: " + key);
    }
}
