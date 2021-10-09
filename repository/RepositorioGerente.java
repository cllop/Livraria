package repository;

import java.util.List;

import modelo.Gerente;

public interface RepositorioGerente {

	public Gerente getGerente(long cpf);

	public void add(Gerente gerente);

	public void remove(Gerente gerente);

	public void uptade(Gerente gerente);

	public Gerente find(int id);

	public Gerente findByCpf(long cpf);

	public List<Gerente> findByNomeDeUsuario(String nomeDeUsuario);

}
