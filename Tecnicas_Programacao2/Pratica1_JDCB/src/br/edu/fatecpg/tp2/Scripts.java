package br.edu.fatecpg.tp2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Scripts {

    public static void criarTabela() throws SQLException {
        Connection connection=null;
        connection=Conexao.connection();
        String query = "CREATE TABLE IF NOT EXISTS tarefas( id SERIAL PRIMARY KEY,nome VARCHAR(20) NOT NULL,categoria VARCHAR(15),status BOOLEAN DEFAULT FALSE)";
        try(Statement stmt = connection.createStatement()) {
            stmt.execute(query);
            System.out.println("Tabela Tarefas criada ou ja existia");
        }catch (SQLException e){
            System.out.println("Erro ao tentar CRIAR tabela: " + e.getMessage());
        }

    }
    public static void criarTarefa(String nome,String categoria) throws SQLException {
        Connection connection=null;
        connection=Conexao.connection();

        String query = "INSERT INTO tarefas(nome,categoria) VALUES(?,?)";

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1,nome);
            stmt.setString(2,categoria);
            stmt.execute();

        }catch (SQLException e){
            System.out.println("Erro ao tentar INSERIR no banco de dados: " +e.getMessage());
        }

    }

    public static void exibirTarefas() throws SQLException {
        Connection connection=null;
        connection=Conexao.connection();

        List<Tarefa> tarefas = new ArrayList<>();

        String query = "SELECT * FROM tarefas";

        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            tarefas.add(new Tarefa(rs.getInt("id"),rs.getString("nome"),rs.getString("categoria"),rs.getBoolean("status")));
        }

        tarefas.forEach(System.out::println);

    }

    public static void editarTarefa(String nome,String categoria,int id) throws SQLException {
        Connection connection=null;
        connection=Conexao.connection();

        String query = "UPDATE tarefas SET nome = ?, categoria = ? WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1,nome);
            stmt.setString(2,categoria);
            stmt.setInt(3,id);


            int linhasEditadas = stmt.executeUpdate();
            if (linhasEditadas > 0) {
                System.out.println("Tarefa editada com sucesso");
            } else {
                System.out.println("Nenhuma tarefa encontrada com o id especificado.");
            }

        }catch (SQLException e){
            System.out.println("Erro ao tentar EDITAR no banco de dados: " +e.getMessage());
        }

    }

    public static void excluirTarefa(int id) throws SQLException {
        Connection connection=null;
        connection=Conexao.connection();

        String query = "DELETE from tarefas WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1,id);


            int linhasExcluidas = stmt.executeUpdate();
            if (linhasExcluidas > 0) {
                System.out.println("Tarefa excluida com sucesso!");
            } else {
                System.out.println("Nenhuma tarefa encontrada com o id especificado.");
            }

        }catch (SQLException e){
            System.out.println("Erro ao tentar EXCLUIR no banco de dados: " +e.getMessage());
        }

    }

    public static void marcarTarefa(boolean status,int id) throws SQLException {
        Connection connection=null;
        connection=Conexao.connection();

        String query = "UPDATE tarefas SET status = ? WHERE id =?";

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setBoolean(1,status);
            stmt.setInt(2,id);
            stmt.executeUpdate();
            System.out.println("Concluida");


        }catch (SQLException e){
            System.out.println("Erro ao tentar ALTERAR STATUS no banco de dados: " +e.getMessage());
        }

    }

}
