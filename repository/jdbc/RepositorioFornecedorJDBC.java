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
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"INSERT INTO Fornecedor(CNPJ, nome, rua, bairro, CEP, numeroDoImovel, nomeFantasia, ddd, ddi, numeroTelefone) VALUES (?,?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, fornecedor.getCnpj());
			ps.setString(2, fornecedor.getNome());
			ps.setString(3, fornecedor.getRua());
			ps.setString(4, fornecedor.getBairro());
			ps.setLong(5, fornecedor.getCep());
			ps.setShort(6, fornecedor.getNumeroDoImovel());
			ps.setString(7, fornecedor.getNomeFantasia());
			ps.setShort(8, fornecedor.getDdd());
			ps.setShort(9, fornecedor.getDdi());
			ps.setShort(10, fornecedor.getNumeroDoImovel());
			
			ps.execute();
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
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"DELETE FROM Fornecedor WHERE id=?"
					);
			ps.setLong(1, fornecedor.getId());
			ps.execute();
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
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"SELECT * FROM fornecedor WHERE id=?"
					);
			ps.setInt(1, id);
			ps.execute();
			
			ResultSet rs = ps.executeQuery();
			boolean temResultado = rs.next();
			
			if(temResultado) {
				long cnpj = rs.getLong("cnpj");
				String nome = rs.getString("nome");
				String rua = rs.getString("rua");
				String bairro = rs.getString("bairro");
				int cep = rs.getInt("cep");
				short numeroDoImovel = rs.getShort("numeroDoImovel");
				String nomeFantasia = rs.getString("nomeFantasia");
				short ddd = rs.getShort("DDD");
				short ddi = rs.getShort("DDI");
				int numeroTelefone = rs.getInt("numeroTelefone");
				
				return new Fornecedor(id, cnpj, nome, nomeFantasia, rua, bairro, cep, numeroDoImovel, ddd, ddi, numeroTelefone);
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

	public Fornecedor findByNome(String nome) {
		return null;
	}

	public Fornecedor findByCnpj(long cnpj) {
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"SELECT * FROM fornecedor WHERE cnpj=?"
					);
			ps.setLong(1, cnpj);
			ps.execute();
			
			ResultSet rs = ps.executeQuery();
			boolean temResultado = rs.next();
			
			if(temResultado) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String rua = rs.getString("rua");
				String bairro = rs.getString("bairro");
				int cep = rs.getInt("cep");
				short numeroDoImovel = rs.getShort("numeroDoImovel");
				String nomeFantasia = rs.getString("nomeFantasia");
				short ddd = rs.getShort("DDD");
				short ddi = rs.getShort("DDI");
				int numeroTelefone = rs.getInt("numeroTelefone");
				
				return new Fornecedor(id, cnpj, nome, nomeFantasia, rua, bairro, cep, numeroDoImovel, ddd, ddi, numeroTelefone);
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

	public void update(Fornecedor fornecedor) {
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"UPDATE fornecedor SET nomeFantasia=?,rua=?,bairro=?,cep=?,numeroDoImovel=?,ddd=?,ddi=?,numeroTelefone=? WHERE id=?"
					);
			ps.setString(1, fornecedor.getNomeFantasia());
			ps.setString(2, fornecedor.getRua());
			ps.setString(3, fornecedor.getBairro());
			ps.setLong(4, fornecedor.getCep());
			ps.setShort(5, fornecedor.getNumeroDoImovel());
			ps.setInt(6, fornecedor.getId());
			ps.setShort(7, fornecedor.getDdd());
			ps.setShort(8, fornecedor.getDdi());
			ps.setInt(9, fornecedor.getNumeroTelefone());
			
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
