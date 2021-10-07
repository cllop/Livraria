package repository.jdbc;

import config.FabricaDeConexao;
import repository.RepositorioTelefone;

public class RepositorioTelefoneJDBC extends RepositorioJDBC implements RepositorioTelefone{

	public RepositorioTelefoneJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

}
