package repository.jdbc;

import config.FabricaDeConexao;
import repository.RepositorioFuncionario;

public class RepositorioFuncionarioJDBC extends RepositorioJDBC implements RepositorioFuncionario{

	public RepositorioFuncionarioJDBC(FabricaDeConexao fabricaDeConexoes) {
		super(fabricaDeConexoes);
	}

}
