package HTTPRequestExample;
/**
 * Demonstrates the telescoping constructor problem in real-world scenario.
 */
public class Client {
    public static void main(String[] args) {
        // Hard to read and maintain
        HttpRequest postRequest1 = new HttpRequest(
                "https://api.paymentgateway.com/transactions",
                "POST",
                "{ \"amount\": 100.0, \"currency\": \"USD\" }",
                3000,
                true,
                "application/json",
                "Bearer xyz-123-token"
        );

        HttpRequest postRequest2 = new HttpRequest(
                "https://api.paymentgateway.com/transactions",
                "POST",
                "{ \"amount\": 100.0, \"currency\": \"USD\" }",
                3000,
                "application/json",
                "Bearer xyz-123-token"
        );

        System.out.println("Post Request 1 : \n" + postRequest1);
        System.out.println();
        System.out.println("Post Request 2 :\n" + postRequest2);
    }
}
