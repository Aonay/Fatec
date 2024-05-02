package br.edu.fatec.model;


public class Diciplina {
	private String nome;
	private String sigla;
	private int codigo;
	private Aluno aluno;
	
	
	public Diciplina(String nome,String sigla,int codigo) {
		this.nome=nome;
		this.sigla=sigla;
		this.codigo=codigo;
			
	}
	
	

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	


	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	@Override
	public String toString() {
		return "Diciplina [nome=" + nome + ", sigla=" + sigla + ", codigo=" + codigo + ", aluno=" + aluno + "]";
	}


	
	
	

}
