import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) throws IOException, InterruptedException, SQLException {
        Connection connection = null;
        Scanner scan = new Scanner(System.in);

        boolean flag = true;
        while(flag){
            Endereco.menu();

            int escolha = scan.nextInt();
            scan.nextLine();

            switch (escolha){
                case 1:
                    boolean consulta = true;
                            while(consulta){
                                Endereco.consultarCep();
                                System.out.print("Gostaria de consultar outro? S/N: ");
                                String cont = scan.nextLine();
                                if (cont.equals("n")){
                                    consulta=false;
                                }
                            }
                            break;
                case 2:
                    Endereco.exibirConsultas();
                    break;
                case 3:
                    System.out.println("Encerrando sistema...");
                    flag=false;






            }

        }



    }//fim
}
