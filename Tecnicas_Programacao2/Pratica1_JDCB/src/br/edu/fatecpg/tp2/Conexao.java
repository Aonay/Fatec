package br.edu.fatecpg.tp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection connection()throws SQLException {
        var jdbcURL = "jdbc:postgresql://localhost:5432/db_fatec";
        var user = "postgres";
        var pass = "fatec777";
        return DriverManager.getConnection(jdbcURL,user,pass);

    }

}
