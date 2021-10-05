package modelo;

import util.Real;

public class Produto {
	private int id;
	private String nome;
	private Real preco;
	private String descri�ao;
	private int quantidade;
	
	public Produto(String nome, String descri�ao, Real preco, int quantidade) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.descri�ao = descri�ao;
		this.quantidade = quantidade;
	}

	public Produto(int id, String nome, String descri�ao, Real preco, int quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descri�ao = descri�ao;
		this.quantidade = quantidade;
	}
//gett e setter
	
}
