package repository;

import java.util.List;

import modelo.Fornecedor;

public interface RepositorioFornecedor {
	
	public Fornecedor getFornecedor(long cnpj);
	
	public void add(Fornecedor fornecedor);
	
	public void remove(Fornecedor fornecedor);
	
	public void uptade(Fornecedor fornecedor);
	
	public Fornecedor find(int id);
	
	public List<Fornecedor> findByNome(String nome);
	
	public Fornecedor findByCnpj(long cnpj);

}
