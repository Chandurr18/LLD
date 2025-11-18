package DesignPatterns.StructuralPattern.Proxy.Solution.CacheProxy;

/**
 * RealProductCatalog - hits DB/remote API for product details.
 */
public class RealProductCatalog implements ProductCatalog {
    @Override
    public String getDetails(String sku) {
        System.out.println("[RealProductCatalog] Fetching details for " + sku);
        return "Details(" + sku + ")";
    }
}
