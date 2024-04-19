package br.edu.fatec.model;

public class Carro extends Veiculo {
	private int qtdPortas;
	private boolean tetoSolar;
	
	public Carro(String placa,String marca,String modelo,int qtdPortas,boolean tetoSolar) {
		super (placa,marca,modelo);
		this.qtdPortas = qtdPortas;
		this.tetoSolar = tetoSolar;
		
	}
	
	
	public int getQtdPortas() {
		return qtdPortas;
	}


	public void setQtdPortas(int qtdPortas) {
		this.qtdPortas = qtdPortas;
	}


	public boolean getTetoSolar() {
		return tetoSolar;
	}


	public void setTetoSolar(boolean tetoSolar) {
		this.tetoSolar = tetoSolar;
	}


	public void drift() {
		System.out.println("Derrapou lindo!");
	}
	
	public String toString() {
		return "\nCarro : \n"
				+ "Placa      => " + this.getPlaca() +"\n"
				+ "Marca      => " + this.getMarca() +"\n"
				+ "Modelo     => " + this.getModelo()+"\n"
				+ "Portas     => " + this.qtdPortas+"\n"
				+ "Teto Solar => " + (this.tetoSolar==true?"Possui" : "Não possui");
	}
	
	

}
