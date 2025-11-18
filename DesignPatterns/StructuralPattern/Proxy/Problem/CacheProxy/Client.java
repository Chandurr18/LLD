/**
 * Client (Problem) - calls DB every time; inefficient under load.
 */
public class Client {
    public static void main(String[] args) {
        ProductCatalogService svc = new ProductCatalogService();
        System.out.println(svc.getProductDetails("SKU-001"));
        System.out.println(svc.getProductDetails("SKU-001"));
    }
}
