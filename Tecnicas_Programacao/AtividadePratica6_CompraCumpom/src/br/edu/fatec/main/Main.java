package br.edu.fatec.main;

import java.util.Scanner;

import br.edu.fatec.model.Compra;
import br.edu.fatec.model.Cupom;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		var scan = new Scanner(System.in);
		
		System.out.println("Digite codigo: ");
		int codigo = scan.nextInt();
		scan.nextLine();
		System.out.println("Digite o nome: ");
		String nome = scan.nextLine();
		System.out.println("Digite o valor: ");
		double valor = scan.nextDouble();
		scan.nextLine();
		
		var comp1=new Compra(codigo,nome,valor);
		
		System.out.println("Digite o cupom: ");
		String nCupom = scan.nextLine();
		System.out.println("Digite o valor: ");
		double valorDesc = scan.nextDouble();
		
		var cup1=new Cupom(nCupom,valorDesc);
		
		comp1.setCupom(cup1);
		
		System.out.println("Valor Final: "+comp1.calcvalorfinal());

	}

}
