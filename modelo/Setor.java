package modelo;

import java.util.List;

public class Setor {
	private int id;
	private String nome;
	private List<Produto> produtos;
	
<<<<<<< HEAD
	public Setor(int id, String nome, List<Produto> produtos) {
=======
	public Setor( int id, String nome, List<Produto> produtos) {
>>>>>>> main
		this.nome = nome;
		this.id = id;
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

