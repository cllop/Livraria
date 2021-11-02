package modelo;

import java.util.List;

public class Setor {
	private int id;
	private String nome;
	private List<Produto> produtos;
	

	public Setor(int id, String nome, List<Produto> produtos) {
		this.id = id;
		this.nome = nome;
		this.produtos = produtos;
	}

	public Setor( String nome, List<Produto> produtos) {
		this.nome = nome;
		this.produtos = produtos;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
}

