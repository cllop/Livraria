package repository.jdbc;

import java.util.List;

import config.FabricaDeConexao;
import modelo.Usuario;
import repository.RepositorioUsuario;

public class RepositorioUsuarioJDBC extends RepositorioJDBC implements RepositorioUsuario {
	
	public RepositorioUsuarioJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
		
	}
	public void add(Usuario usuario); {
		
	}
	
	public void update(Usuario usuario); {
		
	}
	public List<Usuario> findByNomeDeUsuarioAndSenha(String nome, String senha) {
		
		return null;
	}
	

}
