package repository.jdbc;

import config.FabricaDeConexao;
import repository.RepositorioProdutoCategoria;

public class RepositorioProdutoCategoriaJDBC extends RepositorioJDBC implements RepositorioProdutoCategoria{

	public RepositorioProdutoCategoriaJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

}
