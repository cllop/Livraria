package modelo;

import java.util.List;
import java.util.Objects;

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

	@Override
	public String toString() {
		return "Setor [id=" + id + ", nome=" + nome + ", produtos=" + produtos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, produtos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Setor other = (Setor) obj;
		return id == other.id && Objects.equals(nome, other.nome) && Objects.equals(produtos, other.produtos);
	}
	
}

