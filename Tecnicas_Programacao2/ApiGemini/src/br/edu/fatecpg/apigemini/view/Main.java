package br.edu.fatecpg.apigemini.view;

import br.edu.fatecpg.apigemini.service.ConsomeApi;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);

        boolean menu = true;
        while (menu) {
            System.out.println("╔════════════════════════════════╗");
            System.out.println("║        CONSULTA IMDB     		 ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║   Digite o numero da opção:    ║");
            System.out.println("║ 1 - Fazer pergunta ao Gemini   ║");
            System.out.println("║ 2 - SAIR                       ║");
            System.out.println("╚════════════════════════════════╝");


            int op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1:
                    boolean rpt = true;
                    while (rpt) {
                        System.out.println("Digite sua pergunta:");
                        String pergunta = scan.nextLine();
                        try {
                            String resposta = ConsomeApi.fazerPergunta(pergunta);
                            System.out.println(resposta);
                        } catch (IOException e) {
                            System.err.println("Erro: " + e.getMessage());
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt(); // Restaura o estado de interrupção
                            System.err.println("A operação foi interrompida.");
                        }

                        System.out.println("Deseja tentar novamente? s/n");
                        String resp = scan.nextLine();
                        if (resp.equalsIgnoreCase("n")) {
                            rpt = false;
                        }

                    }
                    break;

                case 2:
                    System.out.println("Encerrando aplicação...");
                    menu = false;
            }
    }
}
}
