package br.edu.fatecpg.tp2;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        Connection connection = null;

        try{
            connection = Conexao.connection();
            System.out.println("Conexão bem sucedida!");
        }catch (SQLException e){
            System.out.println("Erro de conexão: " + e.getMessage());
        }

        Scripts.criarTabela();


        boolean menu = true;
        while (menu){
            System.out.println("╔════════════════════════════════╗");
            System.out.println("║     GERENCIADOR DE TAREFAS     ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║   Digite o numero da opção:    ║");
            System.out.println("║ 1 - Adicionar tarefas          ║");
            System.out.println("║ 2 - Exibir tarefas             ║");
            System.out.println("║ 3 - Editar tarefas             ║");
            System.out.println("║ 4 - Excluir tarefas            ║");
            System.out.println("║ 5 - Alterar Status             ║");
            System.out.println("║ 6 - SAIR                       ║");
            System.out.println("╚════════════════════════════════╝");


            int escolha = scan.nextInt();
            scan.nextLine();

            switch (escolha) {
                case 1:
                    boolean criartarefa=true;
                    while (criartarefa){
                        System.out.print("Nome da tarefa:");
                        String nome = scan.nextLine();
                        System.out.print("Categoria:");
                        String categoria = scan.nextLine();
                        Tarefa.criarTarefa(nome, categoria);
                        System.out.print("Criar outra? S/N:");
                        String cont = scan.nextLine();
                            if (cont.equals("n")){
                                criartarefa=false;
                            }
                    }
                    break;

                case 2:
                    Tarefa.verTarefa();
                    boolean vertarefa = true;
                    while (vertarefa) {
                        System.out.println("Digite: ");
                        System.out.println("1 - Para ver por Status ");
                        System.out.println("2 - Para ver por Categoria");
                        System.out.print("3 - VOLTAR                     : ");
                        int filtro = scan.nextInt();
                        scan.nextLine();
                        switch (filtro) {
                            case 1:
                                System.out.print("Ver PENDENTES ou CONCLUIDAS? p/c : ");
                                String resp = scan.nextLine();
                                if (resp.equals("p")) {
                                    boolean status = false;
                                    Tarefa.verPorStatus(status);
                                } else {
                                    boolean status = true;
                                    Tarefa.verPorStatus(status);
                                }
                                break;
                            case 2:
                                System.out.print("Qual categoria deseja exbir? : ");
                                String cat = scan.nextLine();
                                Tarefa.verPorCategoria(cat);
                                break;
                            case 3:
                                vertarefa = false;

                        }
                    }

                    break;
                case 3:
                    Tarefa.verTarefa();

                    boolean editarefa = true;
                    while (editarefa) {

                        System.out.print("Digite o ID da tarefa que deseja editar: ");
                        int idbusc = scan.nextInt();
                        scan.nextLine();
                        System.out.print("Novo nome: ");
                        String nvnome = scan.nextLine();
                        System.out.print("Nova categoria: ");
                        String nvcat = scan.nextLine();
                        Tarefa.editarTarefa(nvnome, nvcat, idbusc);
                        System.out.println("Deseja editar outra tarefa? s/n");
                        String editresp= scan.nextLine();
                        if(editresp.equals("n")){
                            editarefa=false;
                        }
                    }
                    break;

                case 4:
                    Tarefa.verTarefa();

                    System.out.print("Digite o ID da tarefa que deseja Excluir: ");
                    int idExc = scan.nextInt();
                    scan.nextLine();
                    Tarefa.delTarefa(idExc);
                    break;

                case 5:
                    Tarefa.verTarefa();

                    System.out.print("Digite o ID da tarefa marcar: ");
                    int idMarc = scan.nextInt();
                    scan.nextLine();
                    Tarefa.marcTarefa(idMarc);
                    break;

                case 6:
                    menu=false;


            }
        }

    }
}
