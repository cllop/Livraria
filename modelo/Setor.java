package modelo;

import java.util.List;

public class Setor {
	private int id;
	private String nome;
	private List<Produto> produtos;
	
	public Setor(int id, String nome, List<Produto> produtos) {
		this.nome = nome;
		this.id = id;
		this.produtos = produtos;
	}
}

