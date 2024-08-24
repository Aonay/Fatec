import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaEndereco {
    //metodo que conseme api para trazer endereco:
    public String consomeApi(int cep) throws IOException, InterruptedException {
        //Cliente ,Request,Response
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/"+cep+"/json/"))
                .build();

        HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();



    }

}//fim
