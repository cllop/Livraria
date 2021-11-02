package modelo;

import util.Real;

public class ItemDeVenda {
	private int idVenda;
	private int id;
	private int quantidade;
	private Real preco;
	private Produto produto;
	
	public ItemDeVenda(Produto produto) {
		this.preco = produto.getPreco();
		this.produto = produto;
		this.quantidade = 1;
	}
	
	public ItemDeVenda(int idVenda, int id, int quantidade, Real preco, Produto produto) {
		super();
		this.idVenda = idVenda;
		this.id = id;
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public Real getPreco() {
		return preco;
	}
	public Produto getProduto() {
		return produto;
	}
	
	public int getIdVenda() {
		return idVenda;
	}
	
	public int getId() {
		return id;
	}
}

