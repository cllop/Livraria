package repository;

import java.util.List;

import modelo.Vendedor;

public interface RepositorioVendedor {
	
	public void add(Vendedor vendedor);
	
	public void updateById(Vendedor vendedor);
	
	public Vendedor find(int id);
	
	public Vendedor findByCpf(Vendedor vendedor);
	
	public List<Vendedor> findByNome();
	
	public List<Vendedor> findByNomeAndSobrenome(Vendedor vendedor);
	

}
