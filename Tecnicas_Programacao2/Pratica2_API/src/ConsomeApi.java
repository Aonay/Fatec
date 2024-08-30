import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsomeApi {
    //metodo que conseme api para trazer endereco:
    public String responseHttp(String uri) throws IOException, InterruptedException {
        //Cliente ,Request,Response
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    public String retorneEnd(int cep) throws IOException, InterruptedException {
        return this.responseHttp("https://viacep.com.br/ws/"+cep+"/json/");
    }
    public String retorneDataHora() throws IOException, InterruptedException {
        return this.responseHttp("https://worldtimeapi.org/api/timezone/America/Sao_Paulo");
    }

}//fim
