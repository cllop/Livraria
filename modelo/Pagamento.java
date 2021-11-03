package modelo;

import util.Real;

public class Pagamento {

	private int id;
	private Real valor;
	
	
	public Pagamento(int id, Real valor) {
		super();
		this.valor = valor;
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public Real getValor() {
		return valor;
	}
	
	
		
}
