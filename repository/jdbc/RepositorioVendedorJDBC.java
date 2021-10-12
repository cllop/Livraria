package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			super.criarConexao();
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

				ps.close();

				ps = conexao.prepareStatement("INSERT INTO vendedor (id, ativo) VALUES (?, ?)");

				ps.setInt(1, id);
				ps.setBoolean(2, vendedor.isAtivo());

			} else {

				ps = conexao.prepareStatement(
						"INSERT INTO usuario (cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?); "
								+ "INSERT INTO funcionario (id, ativo) VALUES (LAST_INSERT_ID(), ?);");

				ps.setLong(1, vendedor.getCpf());
				ps.setString(2, vendedor.getNome());
				ps.setString(3, vendedor.getSobrenome());
				ps.setString(4, vendedor.getNomeDeUsuario());
				ps.setString(5, vendedor.getRua());
				ps.setString(6, vendedor.getBairro());
				ps.setInt(7, vendedor.getCep());
				ps.setInt(8, vendedor.getNumeroDaResidencia());

				ps.setBoolean(9, vendedor.isAtivo());

				ps.execute();
			}

		} catch (SQLException execao) {

			throw new RuntimeException("Operação não pode ser comcluida");
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

			ps = conexao.prepareStatement("Select * From vendedores WHERE id= ?; ");
			
			ps.setInt(1, id);

			ResultSet conjuntoDeResultados = ps.executeQuery();
			
			return lerVendedor(conjuntoDeResultados);
			
		} catch (SQLException execao) {

			throw new RuntimeException("Operação não pode ser comcluida");
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
			
			throw new RuntimeException("Operação não pode ser comcluida");
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
			boolean existeResultado = conjuntoDeResultados.next();
			long cpf = conjuntoDeResultados.getLong("cpf");
			String nome = conjuntoDeResultados.getString("nome");
			String sobrenome = conjuntoDeResultados.getString("sobrenome");
			String nomeDeUsuario = conjuntoDeResultados.getString("nomeDeUsuario");
			String rua = conjuntoDeResultados.getString("rua");
			String bairro = conjuntoDeResultados.getString("bairro");
			int cep = conjuntoDeResultados.getInt("cep");
			int numeroDaResidencia = conjuntoDeResultados.getInt("numeroDeResidencia");

			return new Vendedor(cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia);

		} catch (SQLException execao) {

			throw new RuntimeException("Operação não pode ser comcluida");
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

			throw new RuntimeException("Operação não pode ser comcluida");

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
			ps = conexao.prepareStatement("UPDATE vendedor" 
					+ " SET ativo=? "
					+ "WHERE Id=?;");

			ps.setBoolean(1, vendedor.isAtivo());
			ps.setInt(2, vendedor.getId());

			ps.execute();

		} catch (SQLException e) {

			throw new RuntimeException("Operação não pode ser comcluida");
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
			String rua = conjuntoDeResultados.getString("rua");
			String bairro = conjuntoDeResultados.getString("bairro");
			int cep = conjuntoDeResultados.getInt("cep");
			int numeroDaResidencia = conjuntoDeResultados.getInt("numeroDeResidencia");

			vendedor.add(
					new Vendedor(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, true));

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
			String rua = conjuntoDeResultados.getString("rua");
			String bairro = conjuntoDeResultados.getString("bairro");
			int cep = conjuntoDeResultados.getInt("cep");
			int numeroDaResidencia = conjuntoDeResultados.getInt("numeroDeResidencia");
			boolean ativo = conjuntoDeResultados.getBoolean("ativo");

			return new Vendedor(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, true);
		} else {
			throw new RuntimeException("Vendedor não encontrado");
		}

	}
}
