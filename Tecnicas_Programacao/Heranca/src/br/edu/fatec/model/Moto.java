package br.edu.fatec.model;

public class Moto extends Veiculo {
	private int qtdCilindradas;
	private boolean tipoTransmissao;
	
	
	public Moto(String placa, String marca, String modelo,int cc,boolean tt) {
		super(placa,marca,modelo);
		this.qtdCilindradas=cc;
		this.tipoTransmissao=tt;
		
	}
	
	
	
	public int getQtdCilindradas() {
		return qtdCilindradas;
	}



	public void setQtdCilindradas(int qtdCilindradas) {
		this.qtdCilindradas = qtdCilindradas;
	}



	public boolean getTipoTransmissao() {
		return tipoTransmissao;
	}



	public void setTipoTransmissao(boolean tipoTransmissao) {
		this.tipoTransmissao = tipoTransmissao;
	}



	public void empinar() {
		System.out.println("Empinou! o/° ");
	}
	
	public String toString() {
		return "\nMoto : \n"
				+ "Placa       => " + this.getPlaca() +"\n"
				+ "Marca       => " + this.getMarca() +"\n"
				+ "Modelo      => " + this.getModelo()+"\n"
				+ "Cilindradas => " + this.qtdCilindradas+"\n"
				+ "Transmissão => " + (this.tipoTransmissao==true?"Automática" : "Manual");
	}

}
