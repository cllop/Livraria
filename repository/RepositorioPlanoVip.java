package repository;

import java.util.List;

import modelo.PlanoVip;
import modelo.Venda;

public interface RepositorioPlanoVip {
	
	public void add(PlanoVip planoVip);
	
	public List <PlanoVip> getAll();
	
	public PlanoVip findByNome(String nome);
	
	public PlanoVip find(int id);
	
}
