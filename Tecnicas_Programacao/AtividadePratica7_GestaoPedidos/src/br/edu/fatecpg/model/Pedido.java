package br.edu.fatecpg.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int numId;
	private List<String> itens = new ArrayList<>();
	private boolean status;
	
	public Pedido(int numId, List<String> itens) {
		this.numId = numId;
		this.itens = itens;
		this.status = true;
	}

	public int getNumId() {
		return numId;
	}

	public void setNumId(int numId) {
		this.numId = numId;
	}

	public List<String> getItens() {
		return itens;
	}

	public void setItens(List<String> itens) {
		this.itens = itens;
	}

	public String getStatus() {
		return status?"Em andamento":"Entregue";
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void marcarEntregue() {
		this.status = false;
	}

	@Override
	public String toString() {
		return "Pedido N:" + numId +"\n"
				+ "Itens :" + itens +"\n"
				+ "Status :" + getStatus() +"\n";
	}
	
	
	
	
	
	
	

}
