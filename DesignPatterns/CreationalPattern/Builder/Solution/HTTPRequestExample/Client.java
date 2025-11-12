package CreationalPattern.Builder.Solution.HTTPRequestExample;

/**
 * Demonstrates real-world Builder usage for HTTP Request creation.
 */
public class Client {
    public static void main(String[] args) {

        // Example 1: POST API call
        HttpRequest postRequest = new HttpRequest.Builder(
                "https://api.example.com/v1/payments", "POST")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer abc123")
                .body("{ \"amount\": 500, \"currency\": \"USD\" }")
                .timeout(5000)
                .followRedirects(true)
                .build();

        postRequest.execute();

        // Example 2: GET API call with minimal configuration
        HttpRequest getRequest = new HttpRequest.Builder(
                "https://api.example.com/v1/users", "GET")
                .header("Accept", "application/json")
                .timeout(2000)
                .build();

        getRequest.execute();

        // Example 3: PUT API call with different configuration
        HttpRequest putRequest = new HttpRequest.Builder(
                "https://api.example.com/v1/settings", "PUT")
                .header("Authorization", "Bearer xyz789")
                .body("{ \"theme\": \"dark\", \"notifications\": true }")
                .followRedirects(false)
                .build();

        putRequest.execute();
    }
}
