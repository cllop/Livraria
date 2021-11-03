package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Caixa;
import repository.RepositorioCaixa;

public class RepositorioCaixaJDBC extends RepositorioJDBC implements RepositorioCaixa {
	public RepositorioCaixaJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	public void add(Caixa caixa) {
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
			ps = con.prepareStatement("SELECT id FROM usuario WHERE cpf=?");
			ps.setLong(1, caixa.getCpf());
			
			ResultSet rs = ps.executeQuery();
			boolean existeUsuario = rs.next();

			if (existeUsuario) {
				int id = rs.getInt("id");
				ps = con.prepareStatement("INSERT INTO perfilCaixa (id, ativo) VALUES (?, ?)");
				ps.setInt(1, id);
				ps.setBoolean(2, caixa.isAtivo());
				ps.execute();
			} else {
				ps = con.prepareStatement(
						"INSERT INTO usuario (cpf, nome, sobrenome, nomeDeUsuario, pais, estado, cidade, bairro, rua, cep, numeroDaResidencia, ddi, ddd, telefone, senha) "
								+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);

				ps.setLong(1, caixa.getCpf());
				ps.setString(2, caixa.getNome());
				ps.setString(3, caixa.getSobrenome());
				ps.setString(4, caixa.getNomeDeUsuario());
				ps.setString(5, caixa.getPais());
				ps.setString(6, caixa.getEstado());
				ps.setString(7, caixa.getCidade());
				ps.setString(8, caixa.getBairro());
				ps.setString(9, caixa.getRua());
				ps.setInt(10, caixa.getCep());
				ps.setInt(11, caixa.getNumeroDaResidencia());
				ps.setShort(12, caixa.getDdi());
				ps.setShort(13, caixa.getDdd());
				ps.setInt(14, caixa.getTelefone());
				ps.setString(15, caixa.getSenha());
				ps.execute();
				
				ResultSet crid = ps.getGeneratedKeys();
				crid.next();
				int id = crid.getInt(1);
				
				ps = con.prepareStatement("INSERT INTO perfilCaixa (id, ativo) VALUES (?, ?)");
				ps.setInt(1, id);
				ps.setBoolean(2, caixa.isAtivo());
			}
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível cadastrar este caixa.", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void remove(Caixa caixa) {
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
			ps = con.prepareStatement("DELETE FROM perfilcaixa WHERE id=?");
			ps.setLong(1, caixa.getId());
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível remover o caixa.", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void update(Caixa caixa) {
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
					"UPDATE usuario SET nome=?, sobrenome=?, nomeDeUsuario=?, pais=?, estado=?, cidade=?, rua=?, bairro=?, cep=?, numeroDaResidencia=?, ddi=?, ddd=?, numeroTelefone=? WHERE id=?;"
							+ "UPTADE perfilCaixa SET ativo=? WHERE id=?;");
			ps.setString(1, caixa.getNome());
			ps.setString(2, caixa.getSobrenome());
			ps.setString(3, caixa.getNomeDeUsuario());
			ps.setString(4, caixa.getPais());
			ps.setString(5, caixa.getEstado());
			ps.setString(6, caixa.getCidade());
			ps.setString(7, caixa.getRua());
			ps.setString(8, caixa.getBairro());
			ps.setInt(9, caixa.getCep());
			ps.setInt(10, caixa.getNumeroDaResidencia());
			ps.setShort(11, caixa.getDdi());
			ps.setShort(12, caixa.getDdd());
			ps.setInt(13, caixa.getTelefone());
			ps.setBoolean(14, caixa.isAtivo());

			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possivel alterar os dados do caixa.", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public Caixa find(int id) {
		Connection con = super.getConexao();

		boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"SELECT usuario.*, perfilCaixa.id AS idPerfilCaixa, perfilCaixa.ativo FROM perfilcaixa LEFT JOIN usuario ON perfilCaixa.id = usuario.id WHERE perfilCaixa.id= ?;");

			ps.setInt(1, id);

			ResultSet conjuntoDeResultados = ps.executeQuery();

			return lerCaixa(conjuntoDeResultados);
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar este caixa.", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public List<Caixa> findBynome(String nome) {
		Connection con = super.getConexao();
		boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;

		try {
			ps = con.prepareStatement("SELECT * FROM caixa WHERE nome=?;");
			ResultSet conjuntoDeResultados = ps.executeQuery();

			return lerCaixas(conjuntoDeResultados);
		} catch (SQLException e) {
			throw new RuntimeException("Operação não pode ser concluida", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	private static List<Caixa> lerCaixas(ResultSet conjuntoDeResultados) throws SQLException {
		List<Caixa> caixas = new ArrayList<>();

		while (conjuntoDeResultados.next()) {
			caixas.add(apenasLerCaixa(conjuntoDeResultados));
		}

		return caixas;
	}

	private static Caixa lerCaixa(ResultSet conjuntoDeResultados) throws SQLException {
		if (conjuntoDeResultados.next()) {
			return apenasLerCaixa(conjuntoDeResultados);
		} else {
			throw new RuntimeException("Vendedor não encontrado");
		}
	}

	private static Caixa apenasLerCaixa(ResultSet conjuntoDeResultados) throws SQLException {
		int id = conjuntoDeResultados.getInt("id");
		long cpf = conjuntoDeResultados.getLong("cpf");
		String nome = conjuntoDeResultados.getString("nome");
		String sobrenome = conjuntoDeResultados.getString("sobrenome");
		String nomeDeUsuario = conjuntoDeResultados.getString("nomeDeUsuario");
		String senha = conjuntoDeResultados.getString("senha");
		String pais = conjuntoDeResultados.getString("pais");
		String estado = conjuntoDeResultados.getString("estado");
		String cidade = conjuntoDeResultados.getString("cidade");
		String rua = conjuntoDeResultados.getString("rua");
		String bairro = conjuntoDeResultados.getString("bairro");
		int cep = conjuntoDeResultados.getInt("cep");
		short numeroDaResidencia = conjuntoDeResultados.getShort("numeroDaResidencia");
		byte ddi = conjuntoDeResultados.getByte("DDI");
		byte ddd = conjuntoDeResultados.getByte("DDD");
		int telefone = conjuntoDeResultados.getInt("telefone");
		boolean ativo = conjuntoDeResultados.getBoolean("ativo");

		return new Caixa(id, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro, cep,
				numeroDaResidencia, ddi, ddd, telefone, ativo);
	}
}
