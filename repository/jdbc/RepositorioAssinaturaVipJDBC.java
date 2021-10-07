package repository.jdbc;

import config.FabricaDeConexao;
import repository.RepositorioAssinaturaVip;

public class RepositorioAssinaturaVipJDBC extends RepositorioJDBC implements RepositorioAssinaturaVip{

	public RepositorioAssinaturaVipJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

}
