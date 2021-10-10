package modelo;

import util.Real;

public class PlanoVip extends AssinaturaVip {
	private int id;
	private Real preco;
	private String descricao;
	private boolean ativo;
	private String nome;
	
	public Real getPreco() {
		return preco;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	
	public String getNome() {
		return nome;
	}
}
