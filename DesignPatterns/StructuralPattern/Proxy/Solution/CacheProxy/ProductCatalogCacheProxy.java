package DesignPatterns.StructuralPattern.Proxy.Solution.CacheProxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Cache proxy that keeps recent product details in memory.
 */
public class ProductCatalogCacheProxy implements ProductCatalog {
    private final RealProductCatalog real = new RealProductCatalog();
    private final Map<String, String> cache = new HashMap<>();

    @Override
    public String getDetails(String sku) {
        if (cache.containsKey(sku)) {
            System.out.println("[ProductCatalogCacheProxy] Cache hit for " + sku);
            return cache.get(sku);
        }
        System.out.println("[ProductCatalogCacheProxy] Cache miss for " + sku);
        String details = real.getDetails(sku);
        cache.put(sku, details);
        return details;
    }
}
