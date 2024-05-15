package br.edu.fatecpg.model;

import java.util.ArrayList;
import java.util.List;

public class ListaPedido {
	
	List<Pedido> pedidos = new ArrayList<>();
	
	public ListaPedido(){
		
	}
	
	public ListaPedido(List<Pedido> pedidos) {
		this.pedidos=pedidos;
	}
	
	public void addPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
	public void addPedido(List<Pedido> listaPedidos) {
		this.pedidos.addAll(listaPedidos);
	}
	
	public void delPedido(int id) {
		boolean encontrado = false;
		for(Pedido pedido : pedidos) {
			if(pedido.getNumId()==id) {
				this.pedidos.remove(pedido);
				encontrado = true;
				break;
			}
			
		}
		if(!encontrado) {
			System.out.println("Pedido com ID: " + id + " não econtrado!");
		}
	}
	
	
	public void exibirEmAdamento() {
		boolean andamento = false;
		for(Pedido pedido:pedidos) {
			if(pedido.isStatus()==true) {
				System.out.println(pedido);
				andamento=true;
			}
		}
		if(!andamento) {
			System.out.println("Não há pedidos em andamento");
		}
	}
	
	
	public void concluirPedido(int id) {
		boolean encontrado = false;
		for(Pedido pedido : pedidos) {
			if(pedido.getNumId()==id) {
				pedido.marcarEntregue();
				encontrado = true;
				break;
			}
			
		}
		if(!encontrado) {
			System.out.println("Pedido com ID: " + id + " não econtrado!");
		}
	}

	@Override
	public String toString() {
		return "Todos os Pedidos: \n\n" + pedidos + "\n";
	}
	
	
	
	
	
	
	
}
