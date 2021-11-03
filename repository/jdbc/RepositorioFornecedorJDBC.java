package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
					"INSERT INTO Fornecedor(CNPJ, nome, rua, bairro, CEP, numeroDoImovel, nomeFantasia, ddd, ddi, numeroTelefone, pais, estado, cidade) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
			ps.setString(11, fornecedor.getPais());
			ps.setString(12, fornecedor.getEstado());
			ps.setString(13, fornecedor.getCidade());

			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível adicionar fornecedor.", e);
		} finally {
			if (!jaExisteConexao) {
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
			ps = con.prepareStatement("DELETE FROM fornecedor WHERE id=?");
			ps.setLong(1, fornecedor.getId());
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível remover fornecedor.", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public Fornecedor find(int id) { // feito
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
			ps = con.prepareStatement("SELECT * FROM fornecedor WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			return lerFornecedor(rs);
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar fornecedor.", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public Fornecedor findByNome(String nome) { // feito
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
			ps = con.prepareStatement("SELECT * FROM fornecedor WHERE nome=?");
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
			return lerFornecedor(rs);
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar fornecedor.", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public Fornecedor findByCnpj(long cnpj) { // feito
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
			ps = con.prepareStatement("SELECT * FROM fornecedor WHERE cnpj=?");
			ps.setLong(1, cnpj);
			ResultSet rs = ps.executeQuery();
			
			return lerFornecedor(rs);
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar fornecedor!", e);
		} finally {
			if (!jaExisteConexao) {
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
					"UPDATE fornecedor SET nomeFantasia=?,rua=?,bairro=?,cep=?,numeroDoImovel=?,ddd=?,ddi=?,numeroTelefone=? WHERE id=?");
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
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível alterar os dados.", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	private List<Fornecedor> lerFornecedores(ResultSet conjuntoDeResultados) throws SQLException {
		List<Fornecedor> fornecedores = new ArrayList<>(conjuntoDeResultados.getRow());

		while (conjuntoDeResultados.next()) {
			long cnpj = conjuntoDeResultados.getLong("cnpj");
			String nome = conjuntoDeResultados.getString("nome");
			String nomeFantasia = conjuntoDeResultados.getString("nomeFantasia");
			String pais = conjuntoDeResultados.getString("pais");
			String estado = conjuntoDeResultados.getString("estado");
			String cidade = conjuntoDeResultados.getString("cidade");
			String rua = conjuntoDeResultados.getString("rua");
			String bairro = conjuntoDeResultados.getString("bairro");
			int cep = conjuntoDeResultados.getInt("cep");
			short numeroDoImovel = conjuntoDeResultados.getShort("numeroDoImovel");
			short ddd = conjuntoDeResultados.getShort("DDD");
			short ddi = conjuntoDeResultados.getShort("DDI");
			int numeroTelefone = conjuntoDeResultados.getInt("numeroTelefone");

			fornecedores.add(new Fornecedor(cnpj, nome, nomeFantasia, pais, estado, cidade, rua, bairro, cep,
					numeroDoImovel, ddd, ddi, numeroTelefone));
		}
		return fornecedores;
	}

	private Fornecedor lerFornecedor(ResultSet conjuntoDeResultados) throws SQLException {
		boolean existeResultado = conjuntoDeResultados.next();

		if (existeResultado) {
			long cnpj = conjuntoDeResultados.getLong("cnpj");
			String nome = conjuntoDeResultados.getString("nome");
			String nomeFantasia = conjuntoDeResultados.getString("nomeFantasia");
			String pais = conjuntoDeResultados.getString("pais");
			String estado = conjuntoDeResultados.getString("estado");
			String cidade = conjuntoDeResultados.getString("cidade");
			String rua = conjuntoDeResultados.getString("rua");
			String bairro = conjuntoDeResultados.getString("bairro");
			int cep = conjuntoDeResultados.getInt("cep");
			short numeroDoImovel = conjuntoDeResultados.getShort("numeroDoImovel");
			short ddd = conjuntoDeResultados.getShort("DDD");
			short ddi = conjuntoDeResultados.getShort("DDI");
			int numeroTelefone = conjuntoDeResultados.getInt("numeroTelefone");

			return new Fornecedor(cnpj, nome, nomeFantasia, pais, estado, cidade, rua, bairro, cep, numeroDoImovel, ddd,
					ddi, numeroTelefone);
		} else {
			throw new RuntimeException("Fornecedor não encontrado.");
		}
	}
	
}
