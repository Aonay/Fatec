package br.edu.fatecpg.main;

import java.util.ArrayList;
import java.util.List;

import br.edu.fatecpg.model.ListaPedido;
import br.edu.fatecpg.model.Pedido;

public class Main {

	public static void main(String[] args) {
		
		List<String> itens1 = new ArrayList<>();
		itens1.add("Refrirerante");
		itens1.add("Macarronada");
		itens1.add("Pudim");
		
		Pedido pedido1 = new Pedido(1,itens1);
		Pedido pedido2 = new Pedido(2,itens1);
		Pedido pedido3 = new Pedido(3,itens1);
		Pedido pedido4 = new Pedido(4,itens1);
		Pedido pedido5 = new Pedido(5,itens1);
		
		List<Pedido> listaPedidos = new ArrayList<>();
		listaPedidos.add(pedido1);
		listaPedidos.add(pedido2);
		listaPedidos.add(pedido3);
		
		
		ListaPedido listaVendas = new ListaPedido(listaPedidos);
		
		listaVendas.exibirEmAdamento();
		
		listaVendas.addPedido(pedido4);
		listaVendas.addPedido(pedido5);
		
		listaVendas.exibirEmAdamento();
		
		listaVendas.delPedido(2);
		listaVendas.delPedido(3);
		listaVendas.delPedido(4);
		
		listaVendas.exibirEmAdamento();
		
		listaVendas.concluirPedido(5);
		listaVendas.concluirPedido(1);
		
		listaVendas.exibirEmAdamento();

		
		
		
		
		

	}

}
