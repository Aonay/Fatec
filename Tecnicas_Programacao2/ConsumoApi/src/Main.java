import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) throws IOException, InterruptedException {
        Gson gson = new Gson();
        System.out.println("Olá Mundo!");
        var buscaEnd = new BuscaEndereco();

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o cep: ");
        int cep = scan.nextInt();
        String json =buscaEnd.consomeApi(cep);
        System.out.println(json);
        Endereco enderecoFatec = gson.fromJson(json,Endereco.class);
        System.out.println(enderecoFatec);

    }//fim
}
