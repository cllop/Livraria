package repository.jdbc;

import config.FabricaDeConexao;
import repository.RepositorioSetor;

public class RepositorioSetorJDBC extends RepositorioJDBC implements RepositorioSetor{

	public RepositorioSetorJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

}
