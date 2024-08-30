import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Sql {
    public static void criarTabela() throws SQLException {
        Connection connection=null;
        connection=Conexao.connection();
        String query = "CREATE TABLE IF NOT EXISTS consulta( id SERIAL PRIMARY KEY,cep INTEGER(8) NOT NULL,rua VARCHAR(40),bairro VARCHAR(20),cidade VARCHAR(20),uf INT(2)";
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
    public static void exibirporStatus(boolean status) throws SQLException {
        Connection connection=null;
        connection=Conexao.connection();

        List<Tarefa> tarefas = new ArrayList<>();

        String query = "SELECT * FROM tarefas WHERE status = ?";

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setBoolean(1,status);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            tarefas.add(new Tarefa(rs.getInt("id"),rs.getString("nome"),rs.getString("categoria"),rs.getBoolean("status")));
        }

        tarefas.forEach(System.out::println);

    }

    public static void exibirporCategoria(String categoria) throws SQLException {
        Connection connection=null;
        connection=Conexao.connection();

        List<Tarefa> tarefas = new ArrayList<>();

        String query = "SELECT * FROM tarefas WHERE categoria = ?";

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1,categoria);
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

    public static void marcarTarefa(int id) throws SQLException {
        Connection connection = null;
        connection = Conexao.connection();

        String querySelect = "SELECT status FROM tarefas WHERE id = ?";
        String queryUpdate = "UPDATE tarefas SET status = ? WHERE id = ?";

        try {

            PreparedStatement stmtSelect = connection.prepareStatement(querySelect);
            stmtSelect.setInt(1, id);
            ResultSet rs = stmtSelect.executeQuery();

            boolean status = false;
            if (rs.next()) {
                status = rs.getBoolean("status");
            }


            status = !status;


            PreparedStatement stmtUpdate = connection.prepareStatement(queryUpdate);
            stmtUpdate.setBoolean(1, status);
            stmtUpdate.setInt(2, id);
            stmtUpdate.executeUpdate();

            System.out.println("Status da tarefa atualizado com sucesso.");



        }catch (SQLException e){
            System.out.println("Erro ao tentar ALTERAR STATUS no banco de dados: " +e.getMessage());
        }

    }


}
