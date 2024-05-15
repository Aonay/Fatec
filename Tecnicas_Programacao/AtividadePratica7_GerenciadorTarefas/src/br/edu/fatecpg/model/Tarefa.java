package br.edu.fatecpg.model;

public class Tarefa {
	private String titulo;
	private String descricao;
	private boolean status;
	
	public Tarefa(String tit,String desc) {
		this.titulo=tit;
		this.descricao=desc;
		this.status=false;
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status ? "Concluida":"Pendente";
	}

	public void marcarConcluida() {
		this.status = true;
	}
	
	public void marcarPendente() {
		this.status = false;
	}

	@Override
	public String toString() {
		return "\nTitulo: " + titulo + "\n" 
				+ "Descrição :" + descricao + "\n"
				+ "Status: "+(status ? "Concluida":"Pendente")+ "\n";
	}
	
	
	
	

}
