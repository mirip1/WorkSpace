package main;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class LoginExample {
  public static void main(String[] args) throws Exception {
    String apiUrl = "https://iesemilioprados.com/wp-json/wp/v2/users"; // Replace with the target WordPress site URL
    String username = "prueba";
    String password = "123";
    String email = "a@gmail.com";

    // Create an HTTP client
    CloseableHttpClient httpClient = HttpClients.createDefault();

    // Create a new POST request
    HttpPost httpPost = new HttpPost(apiUrl);

    // Set the request headers
    httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
    httpPost.setHeader(HttpHeaders.ACCEPT, "application/json");

    // Create the JSON payload for the user creation
    String payload = "{\"username\":\"" + username+ "\",\"email\":\"" + email + "\",\"password\":\"" + password + "\"}";

    // Set the JSON payload in the request body
    httpPost.setEntity(new StringEntity(payload));

    // Execute the request and get the response
    CloseableHttpResponse response = httpClient.execute(httpPost);
    String responseBody = EntityUtils.toString(response.getEntity());

    // Print the response
    System.out.println(responseBody);

    // Close the response
    response.close();
}
}
