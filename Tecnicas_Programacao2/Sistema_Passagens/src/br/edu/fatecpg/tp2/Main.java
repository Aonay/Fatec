package br.edu.fatecpg.tp2;

public class Main {

	public static void main(String[] args) {
		
		
		System.out.println("Criando Voo:");
		var voo1= new Voo("GRU1025","Guarulhos-SP","Fortaleza-SP",40,150.00);
		var voo2= new Voo("FOR3312","Fortaleza-SP","Guarulhos-SP",30,300.00);
		
		System.out.println(voo1.toString());
		System.out.println(voo2.toString());
		
		System.out.println("Criando Reserva:");
		voo1.realizarReserva(5);
		System.out.println(voo1.getAssentosDisp());
		voo2.realizarReserva(31);
		
		System.out.println("Realizando pagamento:");
		voo1.realizarPagto("ida", false);
		System.out.println(voo1.imprimirPass());;
		
		System.out.println("Criando lista de voo,adicionando e exibindo:");
		var list1= new Aeroporto();
		list1.addVoo(voo1);
		list1.addVoo(voo2);
		list1.exibirVoos();

	}

}
