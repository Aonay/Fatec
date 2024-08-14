package br.edu.fatecpg.tp2;

public class Voo {
	
	private String numVoo;
	private String origem;
	private String destino;
	private int assentosDisp;
	private double valor;
	
	public Voo(String num, String origem,String destino,int assentos,double valor) {
		this.numVoo = num;
		this.origem = origem;
		this.destino = destino;
		this.assentosDisp = assentos;
		this.valor = valor;
			
	}
	
	public boolean verificarDisp(int num) {
		if(this.assentosDisp<num) {
			return false;
		}else {
			return true;
		}
	}
	
	public void realizarReserva(int num) {
		if(verificarDisp(num)!=true) {
			System.out.println("Numero de assentos indisponíveis");
			System.out.println("Disnopiveis: "+this.assentosDisp);
		}else {
			this.assentosDisp-=num;
			System.out.println(num+" Assentos reservados com sucesso!");
		}
	}
	
	public void realizarPagto(String tipoViagem, boolean pontosTuristicos) {
		double taxa = 50.00;
		double total = this.valor;
		
		if(tipoViagem.equals("ida e volta")) {
			total*=2;
		}
		if(pontosTuristicos){
			total+=taxa;
		}
		System.out.println("Valor Total: "+total);
	}
	
	public String imprimirPass() {
		return "Dados da passagem:"
				+ "// No Voo: "+this.numVoo
				+ "// Origem: " +this.origem
				+ "// Destino: " + this.destino;
				
		
	}

	public String getNumVoo() {
		return numVoo;
	}

	public void setNumVoo(String numVoo) {
		this.numVoo = numVoo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getAssentosDisp() {
		return assentosDisp;
	}

	public void setAssentosDisp(int assentosDisp) {
		this.assentosDisp = assentosDisp;
	}

	@Override
	public String toString() {
		return " -- "
				+ "Numero do Voo: "	+ numVoo 
				+ "// Origem: " 		+ origem 
				+ "// Destino: " 		+ destino 
				+ "// Assentos Disp.: "	+ assentosDisp 
				+ "// R$: " 			+ valor;
	}
	
	
	

}
