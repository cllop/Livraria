package repository;

import modelo.Produto;

public interface RepositorioProdutoAndLivro {
	
	public void add(Produto produto);
	public Produto find(int id);
	public Produto findByNome(String nome);
	public Produto findByAutor(String autor);
	public Produto findByCategoria(String categoria);
		
	
}