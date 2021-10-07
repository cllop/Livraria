package repository.jdbc;

import java.sql.Connection;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Fornecedor;
import repository.RepositorioFornecedor;

public class RepositorioFornecedorJDBC extends RepositorioJDBC implements RepositorioFornecedor {

	public RepositorioFornecedorJDBC(FabricaDeConexao fabricaDeConexao) {
		super(fabricaDeConexao);

	}

	public Fornecedor getFornecedor(long cnpj) {

		return null;
	}

	public void add(Fornecedor fornecedor) {
		Connection con = super.getConnection();
		Boolean jaExisteConexao;
		if(con == null){ 
		   	 jaExisteConexao = false;
		    	super.createConnection();
		}else{
			jaExisteConexao = true;
		}
		PrepareStatement ps = con.prepareStatement("INSERT INTO Fornecedor('CNPJ','nome','rua','bairro','CEP','NumeroDoImovel') VALUES (?,?,?,?,?,?)");
		ps.setLong(1, fornecedor.getCNPJ);
		ps.setString(2, fornecedor.getNome);
		ps.setString(3, fornecedor.getRua);
		ps.setString(4, fornecedor.getBairro());
		ps.setLong(5, fornecedor.getCEP());
		ps.setShort(6, fornecedor.getNumeroDoImovel());
	}

	public void remove(Fornecedor fornecedor) {
		this.remove(fornecedor.getId());
	}
	
	public void remove(int id) {
		
	}

	public Fornecedor find(int id) {

		return null;
	}

	public List<Fornecedor> findByNome(String nome) {

		return null;
	}

	public Fornecedor findByCnpj(long cnpj) {

		return null;
	}

	public void uptade(Fornecedor fornecedor) {

	}
	
	
	
	

}
