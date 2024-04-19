package br.edu.fatec.main;

import br.edu.fatec.model.*;

public class Main {

	public static void main(String[] args) {
	//INICIO
		
		Veiculo veic1 = new Veiculo("GGG3030","Honda","FIT");
		System.out.println(veic1);
		
		Carro carr1 = new Carro("HHH4040","Fiat","Idea", 4 ,true);
		System.out.println(carr1);
		carr1.ligar();
		carr1.drift();
		
		Moto moto1 = new Moto("III4023","Yamaha","Monster",500,true);
		System.out.println(moto1);
		moto1.empinar();
		
		Caminhao cami1 = new Caminhao("LLL1209","Volvo","FMX",10,"Baú",5.25,3.00);
		System.out.println(cami1);
		cami1.ativarEixo();
		

	}//FIM

}
