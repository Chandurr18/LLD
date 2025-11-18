/**
 * ProductCatalogService (Problem)
 * Fetches product details from DB every time (no caching).
 */
public class ProductCatalogService {
    public String getProductDetails(String sku) {
        System.out.println("[ProductCatalogService] Querying DB for " + sku);
        return "Details(" + sku + ")";
    }
}
