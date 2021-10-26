package modelo;

import util.Real;

public class ItemDeVenda {
	private int quantidade;
	private Real preco;
	private Produto produto;
	
	public ItemDeVenda(Produto produto) {
		this.preco = produto.getPreco();
		this.produto = produto;
		this.quantidade = 1;
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
	
}

