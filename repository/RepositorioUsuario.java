package repository;

import java.util.List;

import modelo.Usuario;

public interface RepositorioUsuario {

	public List<Usuario> findTodosPerfisByNomeDeUsuarioAndSenha(String nome, String senha);

	public void add(Usuario usuario);

	public void update(Usuario usuario);

	public Usuario find(int id);

	public List<Usuario> findByNome(String nome);

}
