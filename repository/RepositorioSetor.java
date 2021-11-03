package repository;

import modelo.Setor;

public interface RepositorioSetor {

	public Setor find(int id);

	public void add(Setor model);
	
}
