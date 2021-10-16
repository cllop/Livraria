package modelo;

import util.Real;

public class Produto {
	private int id;
	private String nome;
	private Real preco;
	private String descricao;
	private int quantidade;
	
	public Produto(String nome, String descricao, Real preco, int quantidade) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.quantidade = quantidade;
	}

	public Produto(int id, String nome, String descricao, Real preco, int quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.quantidade = quantidade;
	}
	//setters

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Real getPreco() {
		return preco;
	}

	public String getDescriçao() {
		return descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	
	
}
