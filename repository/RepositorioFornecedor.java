package repository;

import java.util.List;

import modelo.Fornecedor;

public interface RepositorioFornecedor {
	
	public void add(Fornecedor fornecedor);
	
	public Fornecedor find(int id);
	
	public List<Fornecedor> findByNome(String nome);
	
	public Fornecedor findByCnpj(long cnpj);
	
}
