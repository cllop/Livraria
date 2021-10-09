package repository.jdbc;

import java.util.List;

import config.FabricaDeConexao;
import modelo.Usuario;
import repository.RepositorioDeUsuario;

public class RepositorioUsuarioJDBC extends RepositorioJDBC implements RepositorioDeUsuario {
	
	public RepositorioUsuarioJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
		
	}

	public List<Usuario> findByNomeDeUsuarioAndSenha(String nome, String senha) {
		
		return null;
	}
	

}
