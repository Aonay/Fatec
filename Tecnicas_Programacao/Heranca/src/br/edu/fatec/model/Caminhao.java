package br.edu.fatec.model;

public class Caminhao extends Veiculo {
	private int nEixos;
	private String carroceria;
	private double comprimento;
	private double altura;
	
	public Caminhao(String placa,String marca,String modelo,int nEixos,String carroceria,double comp,double alt){
		super(placa,marca,modelo);
		this.nEixos = nEixos;
		this.carroceria = carroceria;
		this.comprimento = comp;
		this.altura = alt;
		
	}
	
	
	
	public int getnEixos() {
		return nEixos;
	}



	public void setnEixos(int nEixos) {
		this.nEixos = nEixos;
	}



	public String getCarroceria() {
		return carroceria;
	}



	public void setCarroceria(String carroceria) {
		this.carroceria = carroceria;
	}



	public double getComprimento() {
		return comprimento;
	}



	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}



	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}



	public void ativarEixo() {
		System.out.println("Eixos extras ativados!");
	}
	
	public String toString() {
		return "\nCaminhão : \n"
				+ "Placa       => " + this.getPlaca() +"\n"
				+ "Marca       => " + this.getMarca() +"\n"
				+ "Modelo      => " + this.getModelo()+"\n"
				+ "Qtd Eixos   => " + this.nEixos+"\n"
				+ "TCarroceria => " + this.carroceria+"\n"
				+ "Comprimento => " + this.comprimento+"\n"
				+ "Altura      => " + this.altura;
				
	}
	

}
