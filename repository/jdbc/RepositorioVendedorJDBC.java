package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

			ps = conexao.prepareStatement(
					"INSERT INTO vendedor (cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?); ");

			ps.setLong(1, vendedor.getCpf());
			ps.setString(2, vendedor.getNome());
			ps.setString(3, vendedor.getSobrenome());
			ps.setString(4, vendedor.getNomeDeUsuario());
			ps.setString(5, vendedor.getRua());
			ps.setString(6, vendedor.getBairro());
			ps.setInt(6, vendedor.getCep());
			ps.setInt(6, vendedor.getNumeroDaResidencia());

			ps.execute();

		} catch (SQLException execao) {

			throw new RuntimeException("Operação não pode ser comcluida");
		}

	}

	public Vendedor find(int Id) {

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

			return new Vendedor(Id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia);

		} catch (SQLException execao) {

			throw new RuntimeException("Operação não pode ser comcluida");
		}

	}

	public Vendedor findByNome() {

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

	public Vendedor findByNomeAndSobrenome(Vendedor vendedor) {

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

	public Vendedor updateById(int id, Vendedor vendedor) {
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
					+ "SET nome=?, sobrenome=?, nomeDeUsuário=?, CPF=?, telefone=?, rua=?, bairro=?, CEP=?, númeroDaResidência=?\r\n"
					+ "WHERE Id=?;");

			ps.setLong(1, vendedor.getCpf());
			ps.setString(2, vendedor.getNome());
			ps.setString(3, vendedor.getSobrenome());
			ps.setString(4, vendedor.getNomeDeUsuario());
			ps.setString(5, vendedor.getRua());
			ps.setString(6, vendedor.getBairro());
			ps.setInt(6, vendedor.getCep());
			ps.setInt(6, vendedor.getNumeroDaResidencia());

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

		} catch (SQLException e) {

			throw new RuntimeException("Operação não pode ser comcluida");
		}

	}
}
