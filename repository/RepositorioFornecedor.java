package repository;

import java.util.List;

import modelo.Fornecedor;

public interface RepositorioFornecedor {
	
	public void add(Fornecedor fornecedor);
	
	public void remove(Fornecedor fornecedor);
	
	public void update(Fornecedor fornecedor);
	
	public Fornecedor find(int id);
	
	public Fornecedor findByNome(String nome);
	
	public Fornecedor findByCnpj(long cnpj);

}
