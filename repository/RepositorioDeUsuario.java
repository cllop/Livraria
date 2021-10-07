package repository;

import java.util.List;

import modelo.Usuario;

public interface RepositorioDeUsuario {
	
	public List<Usuario> findByNomeDeUsuarioAndSenha(String nome,String senha);
		
	
}
