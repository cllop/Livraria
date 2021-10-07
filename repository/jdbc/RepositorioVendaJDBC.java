package repository.jdbc;

import config.FabricaDeConexao;
import repository.RepositorioVenda;

public class RepositorioVendaJDBC extends RepositorioJDBC implements RepositorioVenda{

	public RepositorioVendaJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

}
