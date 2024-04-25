import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaMoneda {

    public Moneda CalculaMoneda(String monedaOrigen, String monedaDestino, double monto) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/9274524e1aff440e34ffe5b7/pair/" + monedaOrigen + "/" + monedaDestino + "/" + monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri((direccion)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Ha ocurrido un error");
        }
    }
}
