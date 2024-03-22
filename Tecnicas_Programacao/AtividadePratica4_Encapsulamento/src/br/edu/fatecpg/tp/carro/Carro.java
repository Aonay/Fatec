package br.edu.fatecpg.tp.carro;

public class Carro {
	
	//ATRIBUTOS
	
	private String marca;
	private String modelo;
	private boolean status=false;
	private double velocidade=0;
	private double velMax=180;
	private double capTanque=0;
	
	
	//CONSTRUTOR
	
	public Carro() {
		
	}
	
	public Carro(String marca) {
		this.marca=marca;
	}
	
	public Carro(String marca,String modelo) {
		this.marca=marca;
		this.modelo=modelo;
	}
	
	
	
	//GETTERS E SETTERS
	
	public String getMarca() {
		return marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public double getVelocidade() {
		return velocidade;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
		
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
		
	}
	
	
	//MÉTODOS
	
	public void girarChave() {
		if(this.status==true) {
			System.out.println("Carro Desligou!");
			this.status=false;
		}else {
			System.out.println("Carro Ligou!");
			this.status=true;
		}
		
	}
	
	
	public void abastecer (double lts) {
		if(this.capTanque <50) {
			this.capTanque=lts;
			if(this.capTanque>=50) {
				this.capTanque=50;
				System.out.println("Tanque Cheio!");
			}else {
				System.out.println("Qtd atual do tanque: "+ this.capTanque);
			}
		}else {
			System.out.println("Tanque já está cheio: "+ this.capTanque);}
	}
	
	public double getTanque() {
		return capTanque;
	}
	
	public void acelerar (double acl) {
		if(this.velocidade <velMax) {
			this.velocidade+=acl;
			if(this.velocidade>=velMax) {
				this.velocidade=velMax;
				System.out.println("Velocidade Maxima!");
			}else {
				System.out.println("Velocidade atual: "+ this.velocidade);
			}
		}else {
			System.out.println("Velocidade atual: "+ this.velocidade);}
	}
	
	public void frear (double freio) {
		if(this.velocidade>0) {
			this.velocidade-= freio;
			if(this.velocidade<=0) {
				this.velocidade = 0;
				System.out.println("Carro Parou!");
			}else {
				System.out.println("Velocidade atual: "+this.velocidade);
			}
		}
	
	}
	
 
}