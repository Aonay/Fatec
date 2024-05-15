package br.edu.fatecpg.main;

import java.util.ArrayList;
import java.util.List;

import br.edu.fatecpg.model.Gerenciador;
import br.edu.fatecpg.model.Tarefa;

public class Main {

	public static void main(String[] args) {
	// INICIO
		
		Tarefa tarefa1= new Tarefa("Lavar Roupas","Lavar as roupas separando as brancas para lavar separadamente");
		Tarefa tarefa2= new Tarefa("Dobrar Roupas","Dobrar seperando por pessoas da casa");
		Tarefa tarefa3= new Tarefa("Guardar Roupas","Guardar nos respectivos guarda-roupas");
		
		List<Tarefa> tarefas = new ArrayList<>();
		tarefas.add(tarefa1);
		tarefas.add(tarefa2);
		tarefas.add(tarefa3);
		
		Gerenciador ger1= new Gerenciador(tarefas);
		
		ger1.addTarefa(tarefa3);
		ger1.delTarefa(3);//entrando com o numero da tarefa
		ger1.mostrarTarefas();
		
		ger1.delTarefa(3);
		ger1.marcarTarefa(1);
		ger1.mostrarTarefas();
		
		System.out.println(ger1);		
		
		
		
		
		
		
		
		
		

	}// FIM

}
