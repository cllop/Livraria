package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Vendedor;
import repository.RepositorioVendedor;

public class RepositorioVendedorJDBC extends RepositorioJDBC implements RepositorioVendedor {

	public RepositorioVendedorJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	public void add(Vendedor vendedor) {
		Connection conexao = super.getConexao();

		boolean conecxaoJaExistia;
		if (conexao == null) {
			conecxaoJaExistia = false;
			conexao = super.criarConexao();
		} else {
			conecxaoJaExistia = true;
		}

		PreparedStatement ps = null;

		try {
			ps = conexao.prepareStatement("Select id FROM usuario WHERE cpf=?");
			ps.setLong(1, vendedor.getCpf());

			ResultSet conjuntoDeResultados = ps.executeQuery();

			if (conjuntoDeResultados.next()) {
				int id = conjuntoDeResultados.getInt("id");
				ps = conexao.prepareStatement("INSERT INTO vendedor (id, ativo) VALUES (?, ?)");
				ps.setInt(1, id);
				ps.setBoolean(2, vendedor.isAtivo());
				ps.execute();
			} else {
				ps = conexao.prepareStatement(
						"INSERT INTO usuario (cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, pais, cidade, estado, ddd, ddi, telefone, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
						Statement.RETURN_GENERATED_KEYS);

				ps.setLong(1, vendedor.getCpf());
				ps.setString(2, vendedor.getNome());
				ps.setString(3, vendedor.getSobrenome());
				ps.setString(4, vendedor.getNomeDeUsuario());
				ps.setString(5, vendedor.getRua());
				ps.setString(6, vendedor.getBairro());
				ps.setInt(7, vendedor.getCep());
				ps.setInt(8, vendedor.getNumeroDaResidencia());
				ps.setString(9, vendedor.getPais());
				ps.setString(10, vendedor.getCidade());
				ps.setString(11, vendedor.getEstado());
				ps.setShort(12, vendedor.getDdd());
				ps.setShort(13, vendedor.getDdi());
				ps.setInt(14, vendedor.getTelefone());
				ps.setString(15, vendedor.getSenha());
				ps.execute();

				ResultSet crid = ps.getGeneratedKeys();
				crid.next();
				int id = crid.getInt(1);

				ps = conexao.prepareStatement("INSERT INTO perfilVendedor (id, ativo) VALUES (?, ?);");
				ps.setInt(1, id);
				ps.setBoolean(2, vendedor.isAtivo());
				ps.execute();
			}
		} catch (SQLException execao) {

			throw new RuntimeException("Opera??o n?o pode ser concluida", execao);
		}

	}

	public Vendedor find(int id) {

		Connection conexao = super.getConexao();

		boolean conecxaoJaExistia;

		if (conexao == null) {

			conecxaoJaExistia = false;
			super.criarConexao();
		} else {
			conecxaoJaExistia = true;
		}

		PreparedStatement ps = null;

		try {

			ps = conexao.prepareStatement(
					"SELECT * FROM perfilVendedor LEFT JOIN usuario ON perfilVendedor.id = usuario.id WHERE perfilVendedor.id=?; ");

			ps.setInt(1, id);

			ResultSet conjuntoDeResultados = ps.executeQuery();

			return lerVendedor(conjuntoDeResultados);

		} catch (SQLException e) {

			throw new RuntimeException("Opera??o n?o pode ser comcluida", e);
		}

	}

	public List<Vendedor> findByNome() {

		Connection conexao = super.getConexao();

		boolean conecxaoJaExistia;
		if (conexao == null) {
			conecxaoJaExistia = false;
			super.criarConexao();
		} else {
			conecxaoJaExistia = true;
		}

		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement("SELECT * FROM vendedor WHERE nome=?;");

			ResultSet conjuntoDeResultados = ps.executeQuery();

			return lerVendedores(conjuntoDeResultados);

		} catch (SQLException execao) {

			throw new RuntimeException("Opera??o n?o pode ser concluida");
		}

	}

	public Vendedor findByCpf(Vendedor vendedor) {

		Connection conexao = super.getConexao();

		boolean conecxaoJaExistia;
		if (conexao == null) {
			conecxaoJaExistia = false;
			super.criarConexao();
		} else {
			conecxaoJaExistia = true;
		}

		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement("SELECT * FROM vendedor WHERE cpf=?;");

			ps.setLong(1, vendedor.getCpf());

			ResultSet conjuntoDeResultados = ps.executeQuery();

			return lerVendedor(conjuntoDeResultados);

		} catch (SQLException execao) {

			throw new RuntimeException("Opera??o n?o pode ser comcluida");
		}

	}

	public List<Vendedor> findByNomeAndSobrenome(Vendedor vendedor) {

		Connection conexcao = super.getConexao();

		boolean conecxaoJaExistia;
		if (conexcao == null) {
			conecxaoJaExistia = false;
			super.criarConexao();
		} else {
			conecxaoJaExistia = true;
		}

		PreparedStatement ps = null;
		try {
			ps = conexcao.prepareStatement("SELECT * FROM vendedor WHERE nome=?, sobrenome=?;");

			ps.setString(1, vendedor.getNome());
			ps.setString(1, vendedor.getSobrenome());

			ResultSet conjuntoDeResultados = ps.executeQuery();

			return lerVendedores(conjuntoDeResultados);

		} catch (SQLException execao) {

			throw new RuntimeException("Opera??o n?o pode ser comcluida");

		}

	}

	public void updateById(Vendedor vendedor) {
		Connection conexao = super.getConexao();

		boolean conecxaoJaExistia;
		if (conexao == null) {
			conecxaoJaExistia = false;
			super.criarConexao();
		} else {
			conecxaoJaExistia = true;
		}

		PreparedStatement ps = null;

		try {
			ps = conexao.prepareStatement("UPDATE vendedor" + " SET ativo=? " + "WHERE Id=?;");

			ps.setBoolean(1, vendedor.isAtivo());
			ps.setInt(2, vendedor.getId());

			ps.execute();

		} catch (SQLException e) {

			throw new RuntimeException("Opera??o n?o pode ser comcluida");
		}

	}

	private List<Vendedor> lerVendedores(ResultSet conjuntoDeResultados) throws SQLException {

		List<Vendedor> vendedor = new ArrayList<>();

		while (conjuntoDeResultados.next()) {

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

			vendedor.add(new Vendedor(id, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro,
					cep, numeroDaResidencia, ddi, ddd, telefone, ativo));

		}

		return vendedor;

	}

	private Vendedor lerVendedor(ResultSet conjuntoDeResultados) throws SQLException {

		if (conjuntoDeResultados.next()) {

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

			return new Vendedor(id, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro, cep,
					numeroDaResidencia, ddi, ddd, telefone, ativo);
		} else {
			throw new RuntimeException("Vendedor n?o encontrado");
		}

	}
}
