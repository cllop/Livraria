package repository.jdbc;

import config.FabricaDeConexao;
import repository.RepositorioCliente;

public class RepositorioClienteJDBC extends RepositorioJDBC implements RepositorioCliente{

	public RepositorioClienteJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

}
