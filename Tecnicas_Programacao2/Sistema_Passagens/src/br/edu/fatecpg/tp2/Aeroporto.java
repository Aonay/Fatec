package br.edu.fatecpg.tp2;

import java.util.ArrayList;
import java.util.List;

public class Aeroporto {
	
	private  List<Voo> listavoos= new ArrayList<>();
	
	public Aeroporto() {
		
	}
	
	public Aeroporto(List<Voo> listavoos) {
		this.listavoos=listavoos;
		
	}
	
	public void addVoo(Voo voo) {
		this.listavoos.add(voo);
		
	}
	
	public void delVoo(String numVoo) {
		boolean encontrado = false;
		for(Voo voo : listavoos) {
			if(voo.getNumVoo().equals(numVoo)) {
				this.listavoos.remove(voo);
				encontrado = true;
				break;
			}
		}
		if(!encontrado) {
			System.out.println("Voo: " + numVoo + " não econtrado!");
		}
	}

	public void buscVoo(String destino) {
		boolean encontrado = false;
		int cont=0;
		for(Voo voo : listavoos) {
			if(voo.getNumVoo().equals(destino)) {
				
				System.out.println(voo.toString());
				encontrado = true;
				
			}
		}
		if(cont>0) {
			System.out.println(cont+"voo encontrados");
		}
		if(!encontrado) {
			System.out.println("Voo com Destino: " +destino + " não econtrado!");
		}
	}

	
	public void exibirVoos() {
		 for (Voo voo: listavoos) {
			 System.out.println(voo.toString());
		 }
	}
	
	
	

}
