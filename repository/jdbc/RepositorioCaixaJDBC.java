package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Caixa;
import modelo.Fornecedor;
import modelo.Vendedor;
import repository.RepositorioCaixa;

public class RepositorioCaixaJDBC extends RepositorioJDBC implements RepositorioCaixa {

	public RepositorioCaixaJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	@Override
	public void add(Caixa Caixa) {
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
			ps = con.prepareStatement("SELECT * FROM perfilcaixa WHERE cpf=?");

			ResultSet rs = ps.executeQuery();
			boolean temResultado = rs.next();

			if (temResultado) {
				int id = rs.getInt("id");

			} else {
				ps = con.prepareStatement(
						"INSERT INTO perfilCaixa (cpf, nome, sobrenome, nomeDeUsuario, bairro, rua, cep, numeroDaResidencia, ddi, ddd, numeroTelefone) "
								+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

				ps.setLong(1, Caixa.getCpf());
				ps.setString(2, Caixa.getNome());
				ps.setString(3, Caixa.getSobrenome());
				ps.setString(4, Caixa.getNomeDeUsuario());
				ps.setString(5, Caixa.getRua());
				ps.setString(6, Caixa.getBairro());
				ps.setInt(7, Caixa.getCep());
				ps.setInt(8, Caixa.getNumeroDaResidencia());

				ps.execute();
			}

			// ver se existe usuario existe com aquele cpf

			// se o usuario existe voce pega o id dele com aquele cpf

			// se o usuario não existe voce cria ele e pega o id dele com aquele cpf

			// cria um perfilcaixa com id de usuario
		} catch (SQLException e) {

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
					"UPDATE perfilcaixa SET nome=?, sobrenome=?, nomeDeUsuario=?, bairro=?, rua=?, cep=?, numeroDaResidencia=?, ddi=?, ddd=?, numeroTelefone=? WHERE id=?");
			ps.setString(1, caixa.getNome());
			ps.setString(2, caixa.getSobrenome());
			ps.setString(3, caixa.getNomeDeUsuario());
			ps.setString(4, caixa.getRua());
			ps.setString(5, caixa.getBairro());
			ps.setInt(6, caixa.getCep());
			ps.setInt(7, caixa.getNumeroDaResidencia());

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

			ps = con.prepareStatement("SELECT * FROM perfilcaixa WHERE id= ?; ");

			ps.setInt(1, id);

			ResultSet conjuntoDeResultados = ps.executeQuery();

			return lerCaixa(conjuntoDeResultados);

		} catch (SQLException execao) {

			throw new RuntimeException("Operação não pode ser comcluida");
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	@Override
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

		} catch (SQLException execao) {

			throw new RuntimeException("Operação não pode ser concluida");
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	private List<Caixa> lerCaixas(ResultSet conjuntoDeResultados) throws SQLException {

		List<Caixa> caixa = new ArrayList<>();

		while (conjuntoDeResultados.next()) {

			int id = conjuntoDeResultados.getInt("id");
			long cpf = conjuntoDeResultados.getLong("cpf");
			String nome = conjuntoDeResultados.getString("nome");
			String sobrenome = conjuntoDeResultados.getString("sobrenome");
			String nomeDeUsuario = conjuntoDeResultados.getString("nomeDeUsuario");
			String rua = conjuntoDeResultados.getString("rua");
			String bairro = conjuntoDeResultados.getString("bairro");
			int cep = conjuntoDeResultados.getInt("cep");
			int numeroDaResidencia = conjuntoDeResultados.getInt("numeroDeResidencia");
			byte ddd = conjuntoDeResultados.getByte("DDD");
			byte ddi = conjuntoDeResultados.getByte("DDI");
			int telefone = conjuntoDeResultados.getInt("numeroTelefone");
			
			caixa.add(new Caixa(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, ddi, ddd, telefone));

		}

		return caixa;
	}

	private Caixa lerCaixa(ResultSet conjuntoDeResultados) throws SQLException {

		if (conjuntoDeResultados.next()) {

			int id = conjuntoDeResultados.getInt("id");
			long cpf = conjuntoDeResultados.getLong("cpf");
			String nome = conjuntoDeResultados.getString("nome");
			String sobrenome = conjuntoDeResultados.getString("sobrenome");
			String nomeDeUsuario = conjuntoDeResultados.getString("nomeDeUsuario");
			String rua = conjuntoDeResultados.getString("rua");
			String bairro = conjuntoDeResultados.getString("bairro");
			int cep = conjuntoDeResultados.getInt("cep");
			int numeroDaResidencia = conjuntoDeResultados.getInt("numeroDeResidencia");
			byte ddd = conjuntoDeResultados.getByte("DDD");
			byte ddi = conjuntoDeResultados.getByte("DDI");
			int telefone = conjuntoDeResultados.getInt("numeroTelefone");

			return new Caixa(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, ddi, ddd, telefone);
		} else {
			throw new RuntimeException("Vendedor não encontrado");
		}

	}
}
