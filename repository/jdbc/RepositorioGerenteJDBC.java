package repository.jdbc;

import config.FabricaDeConexao;
import repository.RepositorioGerente;

public class RepositorioGerenteJDBC extends RepositorioJDBC implements RepositorioGerente{

	public RepositorioGerenteJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

}
