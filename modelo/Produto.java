package modelo;

import java.util.Objects;

import util.Real;

public class Produto {
	private int id;
	private int idSetor;
	private String nome;
	private Real preco;
	private String descricao;
	private int quantidade;

	public Produto(String nome, String descricao, Real preco, int quantidade, int idSetor) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.idSetor = idSetor;
		
	}

	public Produto(int id, String nome, String descricao, Real preco, int quantidade, int idSetor) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.idSetor = idSetor;
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

	public String getDescricao() {
		return descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public int getIdSetor() {
		return idSetor;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", idSetor=" + idSetor + ", nome=" + nome + ", preco=" + preco + ", descricao="
				+ descricao + ", quantidade=" + quantidade + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, id, idSetor, nome, preco, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(descricao, other.descricao) && id == other.id && idSetor == other.idSetor
				&& Objects.equals(nome, other.nome) && Objects.equals(preco, other.preco)
				&& quantidade == other.quantidade;
	}

}
