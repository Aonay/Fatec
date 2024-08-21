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
    public static void verPorStatus(boolean status) throws SQLException {
        Scripts.exibirporStatus(status);
    }
    public static void verPorCategoria(String nome) throws SQLException {
        Scripts.exibirporCategoria(nome);
    }

    public static void delTarefa(int id) throws SQLException {
        Scripts.excluirTarefa(id);
    }

    public static void marcTarefa(int id) throws SQLException {
        Scripts.marcarTarefa(id);
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

    public static String getStatus(boolean status){
        if(status==false){
            return "PENDENTE";
        }else{
            return "CONCLUIDO";
        }
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %-2d │ Nome: %-20s │ Categoria: %-10s │ Status: %-10s\n%s",
                id,
                nome,
                categoria,
                Tarefa.getStatus(status),
                "────────────────────────────────────────────────────────────────────────────────────"
        );
    }
}
