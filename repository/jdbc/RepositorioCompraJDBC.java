package repository.jdbc;

import config.FabricaDeConexao;
import repository.RepositorioCompra;

public class RepositorioCompraJDBC extends RepositorioJDBC implements RepositorioCompra{

	public RepositorioCompraJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}
	
	

}
