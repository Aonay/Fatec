package br.edu.fatecpg.model;

import java.util.ArrayList;
import java.util.List;



public class Gerenciador {
	private List<Tarefa> tarefas = new ArrayList<>();
	
	
	public Gerenciador() {
		
	}
	
	public Gerenciador(List<Tarefa> tarefas) {
		this.tarefas=tarefas;
		
	}
	
	public void addTarefa(Tarefa tarefa) {
		this.tarefas.add(tarefa);
	}
	
	public void addTarefa(List<Tarefa> listaTarefas) {
		this.tarefas.addAll(listaTarefas);
		
	}
	
	public void delTarefa(int num) {
		this.tarefas.remove(this.tarefas.get(num-1));
	}
	
	public void marcarTarefa(int num) {
		this.tarefas.get(num-1).marcarConcluida();
		
		
	}
	
	public void mostrarTarefas(){//mostrar tarefas com indice do arrayList
	      this.tarefas.forEach(t -> System.out.println( "Tarefa n:" + (tarefas.indexOf(t)+1)+ " " + t));
	    }
	

	@Override
	public String toString() {
		return "Gerenciador [tarefas=" + tarefas + "]";
	}
	
	
	
	
	
	
	

}
