import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// API USAGE
//    https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP/AMOUNT

public class Conversor {
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private final HttpClient client;
    private final Gson gson;

    public Conversor() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    private Moneda convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad){
        String apiKey = ApiConfig.getApiKey();
        URI direccion = URI.create(BASE_URL + apiKey + "/pair/" + monedaOrigen + "/" + monedaDestino + "/" + cantidad);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Extraer los datos del JSON de respuesta
            JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
            double rate = jsonResponse.get("conversion_rate").getAsDouble();
            double result = jsonResponse.get("conversion_result").getAsDouble();

            return new Moneda(
                    monedaOrigen,
                    monedaDestino,
                    rate,
                    result
            );
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error al realizar la conversión: " + e.getMessage(), e);
        }
    }

    Moneda dolarToPesoArg(double dolar){
        return convertirMoneda("USD", "ARS", dolar);
    }

    Moneda pesoArgToDolar(double pesoArg){
        return convertirMoneda("ARS", "USD", pesoArg);
    }

    Moneda dolarToRealBrasileno(double dolar){
        return convertirMoneda("USD", "BRL", dolar);

    }

    Moneda realBrasilenoToDolar(double realbrasileno){
        return convertirMoneda("BRL", "USD", realbrasileno);
    }

    Moneda dolarToPesoColombiano(double dolar){
        return convertirMoneda("USD", "COP", dolar);
    }

    Moneda pesoColombianoToDolar(double pesoColombiano){
        return convertirMoneda("COP", "USD", pesoColombiano);
    }

    Moneda dolarToPesoMexicano(double dolar){
        return convertirMoneda("USD", "MXN", dolar);
    }

    Moneda pesoMexicanoToDolar(double pesoMexicano){
        return convertirMoneda("MXN", "USD", pesoMexicano);
    }

}
