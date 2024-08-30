import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Sql {
    public static void criarTabela() throws SQLException {
        Connection connection=null;
        connection=Conexao.connection();
        String query = "CREATE TABLE IF NOT EXISTS consulta(" +
                " id SERIAL PRIMARY KEY," +
                "cep VARCHAR(9) NOT NULL," +
                "rua VARCHAR(40)," +
                "bairro VARCHAR(20)," +
                "cidade VARCHAR(20)," +
                "uf VARCHAR(2) )";


        try(Statement stmt = connection.createStatement()) {
            stmt.execute(query);
            System.out.println("Tabela Tarefas criada ou ja existia");
        }catch (SQLException e){
            System.out.println("Erro ao tentar CRIAR tabela: " + e.getMessage());
        }

    }
    public static void salvarConsulta(Endereco endereco) throws SQLException {
        Connection connection=null;
        connection=Conexao.connection();

        String query = "INSERT INTO consulta(cep,rua,bairro,cidade,uf) VALUES(?,?,?,?,?)";

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1,endereco.getCep());
            stmt.setString(2,endereco.getRua());
            stmt.setString(3,endereco.getBairro());
            stmt.setString(4,endereco.getCidade());
            stmt.setString(5, endereco.getUf());
            stmt.execute();

            System.out.println("Consulta salva no banco de dados.");

        }catch (SQLException e){
            System.out.println("Erro ao tentar INSERIR no banco de dados: " +e.getMessage());
        }
        connection.close();

    }



}
