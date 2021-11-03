package repository;

import java.util.List;

import modelo.Produto;

public interface RepositorioProduto {
	
	public void add(Produto produto);
	
	public void update(Produto produto);
	
	public Produto find(int id);
	
	public List<Produto> findByNome(String nome);
	
	public Produto findByCategoria(String categoria);
	
	public void remove(Produto produto);
	
}
