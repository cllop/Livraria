package repository.jdbc;

import java.util.List;

import config.FabricaDeConexao;
import modelo.Fornecedor;
import repository.RepositorioFornecedor;

public class RepositorioFornecedorJDBC extends RepositorioJDBC implements RepositorioFornecedor{
	
	public RepositorioFornecedorJDBC(FabricaDeConexao fabricaDeConexao) {
		super(fabricaDeConexao);
		
	}
	
	public Fornecedor getFornecedor(long cnpj) {
		
		return null;
	}
	
	public void add(Fornecedor fornecedor) {
		
	}
	
	public void remove(Fornecedor fornecedor) {
		
	}
	
	public Fornecedor find(int id) {
		
		return null;
	}
	
	public List<Fornecedor> findByNome(String nome){
		
		return null;
	}
	
	public Fornecedor findByCnpj(long cnpj) {
		
		return null;
	}

	public void uptade(Fornecedor fornecedor) {
		
	}

}
