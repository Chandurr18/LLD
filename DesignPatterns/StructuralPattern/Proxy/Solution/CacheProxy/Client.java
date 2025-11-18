package DesignPatterns.StructuralPattern.Proxy.Solution.CacheProxy;

/**
 * Client demonstrates caching behavior.
 */
public class Client {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalogCacheProxy();
        System.out.println(catalog.getDetails("SKU-001"));
        System.out.println(catalog.getDetails("SKU-001"));
    }
}
