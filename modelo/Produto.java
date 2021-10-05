package modelo;

import util.Real;

public class Produto {
	private int id;
	private String nome;
	private Real preco;
	private String descriçao;
	private int quantidade;
	
	public Produto(String nome, String descriçao, Real preco, int quantidade) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.descriçao = descriçao;
		this.quantidade = quantidade;
	}

	public Produto(int id, String nome, String descriçao, Real preco, int quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descriçao = descriçao;
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
		return descriçao;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	
	
}
