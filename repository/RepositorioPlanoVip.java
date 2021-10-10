package repository;

import java.util.List;

import modelo.PlanoVip;

public interface RepositorioPlanoVip {
	
	public void add(PlanoVip planoVip);
	
	public List <PlanoVip> getAll();
	
	public PlanoVip findByNome(String nome);
	
	
}
