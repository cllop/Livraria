package repository.jdbc;

import config.FabricaDeConexao;
import repository.RepositorioPlanoVip;

public class RepositorioPlanoVipJDBC extends RepositorioJDBC implements RepositorioPlanoVip{

	public RepositorioPlanoVipJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

}
