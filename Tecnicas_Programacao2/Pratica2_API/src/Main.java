import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) throws IOException, InterruptedException {
        Gson gson = new Gson();
        System.out.println("Olá Mundo!");
        var buscaEnd = new ConsomeApi();


        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o cep: ");
        int cep = scan.nextInt();
        String json1 =buscaEnd.retorneEnd(cep);
        System.out.println(json1);
        Endereco endereco = gson.fromJson(json1,Endereco.class);
        String json2 =buscaEnd.retorneDataHora();
        Data data = gson.fromJson(json2,Data.class);
        System.out.println(endereco);
        System.out.println(data);
        FileWriter  consulta = new FileWriter("consulta.txt",true);
        consulta.write(endereco.logString()+data.toString());
        consulta.close();


    }//fim
}
