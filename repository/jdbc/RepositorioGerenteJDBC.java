package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Gerente;
import repository.RepositorioGerente;

public class RepositorioGerenteJDBC extends RepositorioJDBC implements RepositorioGerente {
	public RepositorioGerenteJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	public void add(Gerente gerente) {
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
			ps.setLong(1, gerente.getCpf());

			ResultSet rs = ps.executeQuery();
			boolean existeUsuario = rs.next();

			if (existeUsuario) {
				int id = rs.getInt("id");
				ps = con.prepareStatement("INSERT INTO perfilGerente (id, ativo, superGerente) VALUES (?,?,?)");
				ps.setInt(1, id);
				ps.setBoolean(2, gerente.isAtivo());
				ps.setBoolean(3, gerente.isSuperGerente());
				ps.execute();
			} else {
				ps = con.prepareStatement(
						"INSERT INTO usuario (cpf, nome, sobrenome, nomeDeUsuario, pais, estado, cidade, bairro, rua, cep, numeroDaResidencia, ddi, ddd, telefone) "
								+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
								+ "INSERT INTO perfilGerente (id, ativo, superGerente) VALUES (LAST_INSERT_ID(), ?, ?)");

				ps.setLong(1, gerente.getCpf());
				ps.setString(2, gerente.getNome());
				ps.setString(3, gerente.getSobrenome());
				ps.setString(4, gerente.getNomeDeUsuario());
				ps.setString(5, gerente.getPais());
				ps.setString(6, gerente.getEstado());
				ps.setString(7, gerente.getCidade());
				ps.setString(8, gerente.getBairro());
				ps.setString(9, gerente.getRua());
				ps.setInt(10, gerente.getCep());
				ps.setInt(11, gerente.getNumeroDaResidencia());
				ps.setShort(12, gerente.getDdi());
				ps.setShort(13, gerente.getDdd());
				ps.setInt(14, gerente.getTelefone());
				ps.setBoolean(15, gerente.isAtivo());
				ps.setBoolean(16, gerente.isSuperGerente());

				ps.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível cadastrar este gerente.", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void remove(Gerente gerente) {
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
			ps = con.prepareStatement("DELETE INTO gerente WHERE id=?");
			ps.setInt(1, gerente.getId());

		} catch (SQLException e) {

			throw new RuntimeException("Nï¿½o foi possï¿½vel remover gerente.", e);

		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void update(Gerente gerente) {
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
			ps = con.prepareStatement("UPDATE gerente SET ativo=?, superGerente=? WHERE id=?");
			ps.setBoolean(1, gerente.isAtivo());
			ps.setBoolean(2, gerente.isSuperGerente());
			ps.setInt(3, gerente.getId());
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Nï¿½o foi possï¿½vel alterar os dados do gerente!", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public Gerente find(int id) {
		Connection con = super.getConexao();
		
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(
					"SELECT usuario.*, perfilGerente.id AS idPerfilGerente, perfilGerente.ativo FROM perfilGerente LEFT JOIN usuario ON perfilGerente.id = usuario.id WHERE id= ?;");
			
			ps.setInt(1, id);
			ResultSet conjuntoDeResultados = ps.executeQuery();
			
			return lerGerente(conjuntoDeResultados);
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar gerente.", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public Gerente findByCpf(long cpf) {
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
					"SELECT * FROM usuario INNER JOIN gerente ON usuario.id = gerente.id WHERE gerente.id=");
			ps.setLong(1, cpf);

			ResultSet rs = ps.executeQuery();

			return lerGerente(rs);

		} catch (SQLException e) {
			throw new RuntimeException("Nï¿½o foi possï¿½vel encontrar gerente!", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public List<Gerente> findByNome(String nome) {
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
					"SELECT * FROM usuario INNER JOIN gerente ON usuario.id = gerente.id WHERE gerente.id=?");
			ps.setString(1, nome);

			ResultSet rs = ps.executeQuery();

			return lerGerentes(rs);

		} catch (SQLException e) {

			throw new RuntimeException("Nï¿½o foi possï¿½vel encontrar gerente!", e);

		} finally {

			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	private static Gerente lerGerente(ResultSet conjuntoDeResultados) throws SQLException {
		if (conjuntoDeResultados.next()) {
			return apenasLerGerente(conjuntoDeResultados);
		} else {
			throw new RuntimeException("Gerente não encontrado");
		}
	}

	public List<Gerente> lerGerentes(ResultSet conjuntoDeResultados) throws SQLException {
		List<Gerente> gerentes = new ArrayList<>();

		while (conjuntoDeResultados.next()) {
			gerentes.add(apenasLerGerente(conjuntoDeResultados));
		}

		return gerentes;
	}

	private static Gerente apenasLerGerente(ResultSet conjuntoDeResultados) throws SQLException {
		int id = conjuntoDeResultados.getInt("id");
		long cpf = conjuntoDeResultados.getLong("cpf");
		String nome = conjuntoDeResultados.getString("nome");
		String sobrenome = conjuntoDeResultados.getString("sobrenome");
		String nomeDeUsuario = conjuntoDeResultados.getString("nomeDeUsuario");
		String senha = conjuntoDeResultados.getString("senha");
		String pais = conjuntoDeResultados.getString("pais");
		String cidade = conjuntoDeResultados.getString("cidade");
		String estado = conjuntoDeResultados.getString("estado");
		String rua = conjuntoDeResultados.getString("rua");
		String bairro = conjuntoDeResultados.getString("bairro");
		int cep = conjuntoDeResultados.getInt("cep");
		Short numeroDaResidencia = conjuntoDeResultados.getShort("numeroDaResidencia");
		byte ddi = conjuntoDeResultados.getByte("ddi");
		byte ddd = conjuntoDeResultados.getByte("ddd");
		int telefone = conjuntoDeResultados.getInt("telefone");
		boolean ativo = conjuntoDeResultados.getBoolean("ativo");
		boolean superGerente = conjuntoDeResultados.getBoolean("superGerente");
		
		return new Gerente(id, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro, cep,
				numeroDaResidencia, ddi, ddd, telefone, ativo, superGerente);
	}

}
