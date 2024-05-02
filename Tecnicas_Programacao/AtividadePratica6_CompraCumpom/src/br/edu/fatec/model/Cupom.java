package br.edu.fatec.model;

public class Cupom {
	private String nome;
	private double valorDesc;
	
	public Cupom(String nome,double valorDesc) {
		this.nome=nome;
		this.valorDesc=valorDesc;
	}
	
	public double aplicarDesconto(double valor) {
		return valor-valorDesc;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorDesc() {
		return valorDesc;
	}

	public void setValorDesc(double valorDesc) {
		this.valorDesc = valorDesc;
	}

	@Override
	public String toString() {
		return "Cupom [nome=" + nome + ", valorDesc=" + valorDesc + "]";
	}
	
	

}
