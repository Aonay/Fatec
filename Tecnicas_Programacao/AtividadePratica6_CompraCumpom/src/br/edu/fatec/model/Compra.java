package br.edu.fatec.model;

public class Compra {
	
	private int codigo;
	private String nome;
	private double valor;
	private Cupom cupom;
	
	public Compra(int codigo,String nome,double valor) {
		this.codigo=codigo;
		this.nome=nome;
		this.valor=valor;
		
		
	}
	
	public void setCupom(Cupom cupom) {
		this.cupom=cupom;
		
	}
	
	public double calcvalorfinal() {
		if (cupom != null) {
            return cupom.aplicarDesconto(valor);
        } else {
            return valor; // Se não houver cupom, retorna o valor total sem desconto
        }
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Cupom getCupom() {
		return cupom;
	}

	

	@Override
	public String toString() {
		return "Compra [codigo=" + codigo + ", nome=" + nome + ", valor=" + valor + ", cupom=" + cupom + "]";
	}
	
	
	
	
	
	

}
