package repository.jdbc;

import config.FabricaDeConexao;
import repository.RepositorioTelefoneUsuario;

public class RepositorioTelefoneUsuarioJDBC extends RepositorioJDBC implements RepositorioTelefoneUsuario{

	public RepositorioTelefoneUsuarioJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

}
