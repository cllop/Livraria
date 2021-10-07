package repository.jdbc;

import config.FabricaDeConexao;
import repository.RepositorioCaixa;

public class RepositorioCaixaJDBC extends RepositorioJDBC implements RepositorioCaixa{

	public RepositorioCaixaJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

}
