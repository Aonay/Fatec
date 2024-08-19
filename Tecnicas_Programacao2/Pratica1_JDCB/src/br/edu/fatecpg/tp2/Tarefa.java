package br.edu.fatecpg.tp2;

import java.sql.SQLException;

public class Tarefa {

    private int id;
    private String nome;
    private String categoria;
    private boolean status;

    public Tarefa(int id,String nome, String categoria,boolean status){
        this.id=id;
        this.nome = nome;
        this.categoria=categoria;
        this.status=status;


    }

    public static void criarTarefa(String nome,String categoria) throws SQLException {
        Scripts.criarTarefa(nome,categoria);
    }

    public static  void editarTarefa(String nome,String categoria,int id) throws SQLException {
        Scripts.editarTarefa(nome,categoria,id);
    }

    public static void verTarefa() throws SQLException {
        Scripts.exibirTarefas();
    }

    public static void delTarefa(int id) throws SQLException {
        Scripts.excluirTarefa(id);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", status=" + status +
                '}';
    }
}
