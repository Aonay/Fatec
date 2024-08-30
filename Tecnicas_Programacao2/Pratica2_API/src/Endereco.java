import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Endereco {
    public int id;
    public String cep;
    @SerializedName("logradouro")
    public String rua;
    public String bairro;
    @SerializedName("localidade")
    public String cidade;
    public String uf;

    public Endereco(int id, String cep, String rua, String bairro,String cidade, String uf) {
        this.id=id;
        this.cep=cep;
        this.rua=rua;
        this.bairro=bairro;
        this.cidade=cidade;
        this.uf=uf;
    }


    public static void menu(){

        System.out.println("╔════════════════════════════════╗");
        System.out.println("║        CONSULTAR ENDEREÇO      ║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║   Digite o numero da opção:    ║");
        System.out.println("║ 1 - Consultar via CEP          ║");
        System.out.println("║ 2 - Exibir CEP consultado      ║");
        System.out.println("║ 3 - SAIR                       ║");
        System.out.println("╚════════════════════════════════╝");

    }
    public static void consultarCep(){
        Connection connection = null;

        try{
            connection = Conexao.connection();

            Gson gson = new Gson();

            var buscaEnd = new ConsomeApi();

            Scanner scan = new Scanner(System.in);

            try {

                System.out.println("Digite o cep: ");
                int cep = scan.nextInt();
                String json1 = buscaEnd.retorneEnd(cep);
                Endereco endereco = gson.fromJson(json1, Endereco.class);
                Sql.salvarConsulta(endereco);
                String json2 = buscaEnd.retorneDataHora();
                Data data = gson.fromJson(json2, Data.class);
                System.out.println(endereco);
                FileWriter consulta = new FileWriter("consulta.txt", true);
                consulta.write(endereco.logString() + data.toString() + "\n");
                consulta.close();

            }catch (IOException | InterruptedException e){
                System.out.println("Erro ao tentar usar API"+e.getMessage());

            }

        }catch (SQLException e){
            System.out.println("Erro de conexão: " + e.getMessage());
        }

    }

    public static void exibirConsultas() throws SQLException {
        Connection connection=null;
        connection=Conexao.connection();

        List<Endereco> consultas = new ArrayList<>();

        String query = "SELECT * FROM consulta";

        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            consultas.add(new Endereco(rs.getInt("id"),rs.getString("cep"),
                    rs.getString("rua"),rs.getString("bairro"),
                    rs.getString("cidade"),rs.getString("uf")));
        }

        consultas.forEach(System.out::println);

    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String logString(){
        return "[ CEP: "+cep;
    }



    @Override
    public String toString() {
        return "Endereco{" +
                "CEP: '" + cep + '\'' +
                ", Rua: '" + rua + '\'' +
                ", Bairro: '" + bairro + '\'' +
                ", Cidade: '" + cidade + '\'' +
                ", Estado: '" + uf + '\'' +
                '}';
    }
}
