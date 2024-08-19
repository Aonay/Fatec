package br.edu.fatecpg.tp2;

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

        System.out.println("GERENCIADOR DE TAREFAS");
        System.out.println("Digite o numero da opção:");
        System.out.println("1 - Adicionar tarefas");
        System.out.println("2 - Exibir tarefas");
        System.out.println("3 - Editar tarefas");
        System.out.println("4 - Excluir tarefas");
        System.out.println("5 - Marcar concluida");
        System.out.println("6 - SAIR");

        int escolha = scan.nextInt();
        scan.nextLine();

/*        switch (escolha) {
            case 1:
                System.out.print("Nome da tarefa:");
                String nome = scan.nextLine();
                System.out.print("Categoria:");
                String categoria = scan.nextLine();
                Tarefa.criarTarefa(nome, categoria);
                break;

            case 2:
                Tarefa.verTarefa();
                break;
            case 3:
                Tarefa.verTarefa();

                System.out.print("Digite o ID da tarefa que deseja editar: ");
                int idbusc= scan.nextInt();
                scan.nextLine();
                System.out.print("Novo nome: ");
                String nvnome= scan.nextLine();
                System.out.print("Nova categoria: ");
                String nvcat= scan.nextLine();
                Tarefa.editarTarefa(nvnome,nvcat,idbusc);
                break;

            case 4:
                Tarefa.verTarefa();

                System.out.print("Digite o ID da tarefa que deseja Excluir: ");
                int idExc= scan.nextInt();
                scan.nextLine();
                Tarefa.delTarefa(idExc);
                break;




        }*/




        Scripts.marcarTarefa(2);
        Scripts.exibirTarefas();

    }
}
