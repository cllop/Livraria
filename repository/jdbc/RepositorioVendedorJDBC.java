package repository.jdbc;

import config.FabricaDeConexao;
import repository.RepositorioVendedor;

public class RepositorioVendedorJDBC extends RepositorioJDBC implements RepositorioVendedor{

	public RepositorioVendedorJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

}
