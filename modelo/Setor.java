package modelo;

import java.util.List;

public class Setor {
	private int id;
	private String nome;
	private List<Produto> produtos;
	
	public Setor(String nome, int id, List<Produto> produtos) {
		this.nome = nome;
		this.id = id;
		this.produtos = produtos;
	}
}

