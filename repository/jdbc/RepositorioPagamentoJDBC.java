package repository.jdbc;

import config.FabricaDeConexao;
import repository.RepositorioPagamento;

public class RepositorioPagamentoJDBC extends RepositorioJDBC implements RepositorioPagamento{

	public RepositorioPagamentoJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

}
