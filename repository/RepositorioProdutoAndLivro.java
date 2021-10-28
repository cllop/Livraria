package repository;

import java.util.List;

import modelo.Produto;

public interface RepositorioProdutoAndLivro {
	
	public void add(Produto produto);
	public void update(Produto produto);
	public Produto find(int id);
	public List<Produto> findByNome(String nome);
	public Produto findByAutor(String autor);
	public Produto findByCategoria(String categoria);
		
	
}
