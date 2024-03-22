package br.edu.fatecpg.tp.main;
 
import java.util.Scanner;

import br.edu.fatecpg.tp.carro.Carro;
 
 
public class Principal {
 
	public static void main(String[] args) {
		
		//INICIO
		
		Scanner scan = new Scanner(System.in);
		
		Carro meuCarro = new Carro();
		
		
		System.out.print("Digita a marca do seu carro: ");
		String marca = scan.nextLine();
		//meuCarro.marca = marca;
		meuCarro.setMarca(marca);
		
		
		System.out.print("Digite o modelo do carro: ");
		String modelo = scan.nextLine();
		//meuCarro.modelo = modelo;
		meuCarro.setModelo(modelo);
		
		System.out.println("Modelo: "+meuCarro.getMarca());
		System.out.println("Marca: "+meuCarro.getModelo());
		
		
		
		meuCarro.girarChave();
		
		System.out.println("Quantos lts vai abastecer?: ");
		double lts = scan.nextDouble();
		meuCarro.abastecer(lts);
		
		System.out.println("Quantidade final tanque: "+meuCarro.getTanque());
		
		
		
		System.out.println("Digite a aceleração: ");
		double acle = scan.nextDouble();
		meuCarro.acelerar(acle);
		
		System.out.println("Digite a aceleração: ");
		acle = scan.nextDouble();
		meuCarro.acelerar(acle);
		
		System.out.println("Digite a aceleração: ");
		acle = scan.nextDouble();
		meuCarro.acelerar(acle);
		
		
		meuCarro.girarChave();
		
		scan.close();
		
		
		//FIM
		
 
	}
 
}