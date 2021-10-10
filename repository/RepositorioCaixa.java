package repository;

import java.util.List;

import modelo.Caixa;

public interface RepositorioCaixa {
	public void add(Caixa Caixa);
	
	public void update(Caixa caixa);
	
	public Caixa find(int id);
	
	public List<Caixa> findBynome(String nome);
	
}
