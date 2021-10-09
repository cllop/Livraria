package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Fornecedor;
import repository.RepositorioFornecedor;

public class RepositorioFornecedorJDBC extends RepositorioJDBC implements RepositorioFornecedor {

	public RepositorioFornecedorJDBC(FabricaDeConexao fabricaDeConexao) {
		super(fabricaDeConexao);

	}

	public void add(Fornecedor fornecedor) {
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"INSERT INTO Fornecedor('CNPJ','nome','rua','bairro','CEP','numeroDoImovel','nomeFantasia') VALUES (?,?,?,?,?,?,?)");
			ps.setLong(1, fornecedor.getCnpj());
			ps.setString(2, fornecedor.getNome());
			ps.setString(3, fornecedor.getRua());
			ps.setString(4, fornecedor.getBairro());
			ps.setLong(5, fornecedor.getCep());
			ps.setShort(6, fornecedor.getNumeroDoImovel());
			ps.setString(7, fornecedor.getNomeFantasia());
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível adicionar fornecedor.", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void remove(Fornecedor fornecedor) {
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"DELETE FROM Fornecedor WHERE id=?"
					);
			ps.setLong(1, fornecedor.getId());
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível remover fornecedor.", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public Fornecedor find(int id) {		
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"SELECT * FROM fornecedor WHERE id=?"
					);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			boolean temResultado = rs.next();
			
			if(temResultado) {
				long cnpj = rs.getLong(2);
				String nome = rs.getString(3);
				String rua = rs.getString(4);
				String bairro = rs.getString(5);
				int cep = rs.getInt(6);
				short numeroDoImovel = rs.getShort(7);
				String nomeFantasia = rs.getString(8);
				
				return new Fornecedor(id, cnpj, nome, nomeFantasia, rua, bairro, cep, numeroDoImovel);
			}else {
				throw new RuntimeException("Fornecedor não cadastrado.");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar fornecedor.", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public List<Fornecedor> findByNome(String nome) {
		
		return null;
	}

	public Fornecedor findByCnpj(long cnpj) {
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"SELECT * FROM fornecedor WHERE cnpj=?"
					);
			ps.setLong(1, cnpj);
			
			ResultSet rs = ps.executeQuery();
			boolean temResultado = rs.next();
			
			if(temResultado) {
				int id = rs.getInt(1);
				String nome = rs.getString(3);
				String rua = rs.getString(4);
				String bairro = rs.getString(5);
				int cep = rs.getInt(6);
				short numeroDoImovel = rs.getShort(7);
				String nomeFantasia = rs.getString(8);
				
				return new Fornecedor(id, cnpj, nome, nomeFantasia, rua, bairro, cep, numeroDoImovel);
			}else {
				throw new RuntimeException("Fornecedor não cadastrado.");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar fornecedor!", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void uptade(Fornecedor fornecedor) {
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"UPTADE fornecedor SET nomeFantasia=?,rua=?,bairro=?,cep=?,numeroDoImovel=? WHERE id=?"
					);
			ps.setString(1, fornecedor.getNomeFantasia());
			ps.setString(2, fornecedor.getRua());
			ps.setString(3, fornecedor.getBairro());
			ps.setLong(4, fornecedor.getCep());
			ps.setShort(5, fornecedor.getNumeroDoImovel());
			ps.setInt(6, fornecedor.getId());
			ps.execute();
		}catch (SQLException e){
			throw new RuntimeException("Não foi possível alterar os dados.", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}
	
}
