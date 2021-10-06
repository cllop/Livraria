package repository.jdbc;

import config.FabricaDeConexao;
import modelo.Produto;
import repository.RepositorioLivros;

public class RepositorioLivroJDBC extends RepositorioJDBC implements RepositorioLivros {

	public RepositorioLivroJDBC(FabricaDeConexao fabricadeconexao) {
		super(fabricadeconexao);
	}

	@Override
	public void add(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto findByAutor(String autor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto findByCategoria(String categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
