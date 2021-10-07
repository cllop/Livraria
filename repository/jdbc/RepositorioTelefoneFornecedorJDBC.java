package repository.jdbc;

import config.FabricaDeConexao;
import repository.RepositorioTelefoneFornecedor;

public class RepositorioTelefoneFornecedorJDBC extends RepositorioJDBC implements RepositorioTelefoneFornecedor{

	public RepositorioTelefoneFornecedorJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

}
