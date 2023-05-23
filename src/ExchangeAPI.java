import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ExchangeAPI {
    public static void getExchangeRate(String from, String to) {
        String APIkey = "3EDDBB5A-0489-42C2-B575-8693D20CB312";
        String queryParameters = from + "/" + to;
        String endpoint = "https://rest.coinapi.io/v1/exchangerate/";
        String url = endpoint + queryParameters;
        String urlResponse = "";
        try {
            URI myUri = URI.create(url); // creates a URI object from the url string
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(myUri)
                    .header("X-CoinAPI-Key", APIkey)
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            urlResponse = response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(urlResponse);
    }
}
