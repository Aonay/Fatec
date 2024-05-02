package br.edu.fatec.model;

public class Endereco {
	
	private String cep;
	private String rua;
	private int num;
	
	public Endereco(String cep, String rua, int num) {
		this.cep = cep;
		this.rua = rua;
		this.num = num;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", rua=" + rua + ", num=" + num + "]";
	}

}
