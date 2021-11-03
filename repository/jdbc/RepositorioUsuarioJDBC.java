package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Caixa;
import modelo.Cliente;
import modelo.Gerente;
import modelo.Usuario;
import modelo.Vendedor;
import repository.RepositorioUsuario;

public class RepositorioUsuarioJDBC extends RepositorioJDBC implements RepositorioUsuario {

	public RepositorioUsuarioJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	public void add(Usuario usuario) {
		Connection conexao = super.getConexao();

		boolean conexaoJaExistia;
		if (conexao == null) {
			conexaoJaExistia = false;
			super.criarConexao();
		} else {
			conexaoJaExistia = true;
		}

		PreparedStatement ps = null;

		try {
			ps = conexao.prepareStatement(
					"INSERT INTO usuario (INSERT INTO usuario (cpf, nome, sobrenome, nomeDeUsuario, pais, estado, cidade, bairro, rua, cep, numeroDaResidencia, ddi, ddd, telefone, senha) \"\r\n"
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			ps.setLong(1, usuario.getCpf());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getSobrenome());
			ps.setString(4, usuario.getNomeDeUsuario());
			ps.setString(5, usuario.getPais());
			ps.setString(6, usuario.getEstado());
			ps.setString(7, usuario.getCidade());
			ps.setString(8, usuario.getBairro());
			ps.setString(9, usuario.getRua());
			ps.setInt(10, usuario.getCep());
			ps.setInt(11, usuario.getNumeroDaResidencia());
			ps.setShort(12, usuario.getDdi());
			ps.setShort(13, usuario.getDdd());
			ps.setInt(14, usuario.getTelefone());
			ps.setString(15, usuario.getSenha());
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Operaï¿½ï¿½o nï¿½o pode ser comcluida", e);
		}
	}

	public List<Usuario> findTodosPerfisByNomeDeUsuarioAndSenha(String nomeDeUsuario, String senha) {
		Connection conexao = super.getConexao();

		boolean conexaoJaExistia;
		if (conexao == null) {
			conexaoJaExistia = false;
			conexao = super.criarConexao();
		} else {
			conexaoJaExistia = true;
		}

		PreparedStatement ps = null;

		try {

			ps = conexao.prepareStatement("SELECT usuario.*," + " perfilCliente.id as idCliente,"
					+ " perfilGerente.id as idGerente, perfilGerente.ativo as perfilDeGerenteEstaAtivo, perfilGerente.superGerente,"
					+ " perfilVendedor.id as idVendedor, perfilVendedor.ativo as perfilVendedorEstaAtivo,"
					+ " perfilCaixa.id as idCaixa, perfilCaixa.ativo as perfilCaixaEstaAtivo"
					+ " FROM usuario LEFT JOIN perfilCliente ON usuario.id = perfilCliente.id"
					+ " LEFT JOIN perfilGerente ON usuario.id= perfilGerente.id"
					+ " LEFT JOIN perfilCaixa ON usuario.id = perfilCaixa.id"
					+ " LEFT JOIN perfilVendedor ON usuario.id = perfilVendedor.id"
					+ " WHERE nomeDeUsuario=? AND senha=?;");

			ps.setString(1, nomeDeUsuario);
			ps.setString(2, senha);

			ResultSet conjuntoDeResultados = ps.executeQuery();

			return lerPerfisDeUsuario(conjuntoDeResultados);

		} catch (SQLException e) {
			System.out.println("------------------------------------------");
			e.printStackTrace();
			System.out.println("------------------------------------------");
			throw new RuntimeException("Operacao nao pode ser comcluida", e);
		}
	}

	public void update(Usuario usuario) {
		Connection conexao = super.getConexao();

		boolean conexaoJaExistia;
		if (conexao == null) {
			conexaoJaExistia = false;
			super.criarConexao();
		} else {
			conexaoJaExistia = true;
		}

		PreparedStatement ps = null;

		try {

			ps = conexao.prepareStatement("UPDATE usuario");

		} catch (SQLException e) {
			throw new RuntimeException("Operaï¿½ï¿½o nï¿½o pode ser comcluida");

		}
	}

	public Usuario find(int id) {
		Connection conexao = super.getConexao();

		boolean conexaoJaExistia;
		if (conexao == null) {
			conexaoJaExistia = false;
			super.criarConexao();
		} else {
			conexaoJaExistia = true;
		}

		PreparedStatement ps = null;

		try {

			ps = conexao.prepareStatement("SELECT * usuario WHERE id=? ");

			ResultSet conjuntoDeResultados = ps.executeQuery();

			return lerUsuario(conjuntoDeResultados);

		} catch (Exception e) {

			throw new RuntimeException("Operaï¿½ï¿½o nï¿½o pode ser comcluida");
		}
	}

	public List<Usuario> findByNome(String nome) {
		Connection conexao = super.getConexao();

		boolean conexaoJaExistia;
		if (conexao == null) {
			conexaoJaExistia = false;
			super.criarConexao();
		} else {
			conexaoJaExistia = true;
		}

		PreparedStatement ps = null;

		try {

			ps = conexao.prepareStatement("SELECT * usuario WHERE nome=? ");

			ResultSet conjuntoDeResultados = ps.executeQuery();

			return lerListaDeUsuario(conjuntoDeResultados);
		} catch (Exception e) {

			throw new RuntimeException("Operaï¿½ï¿½o nï¿½o pode ser comcluida");
		}
	}

	private Usuario lerUsuario(ResultSet conjuntoDeResultados) throws SQLException {
		boolean existeResultado = conjuntoDeResultados.next();

		if (existeResultado) {
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

			return new Usuario(id, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro, cep,
					numeroDaResidencia, ddi, ddd, telefone);
		} else {
			throw new RuntimeException("Usuario não encontrado");
		}
	}

	private List<Usuario> lerListaDeUsuario(ResultSet conjuntoDeResultados) throws SQLException {
		List<Usuario> usuarios = new ArrayList<>(conjuntoDeResultados.getRow());

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

			usuarios.add(new Usuario(id, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro,
					cep, numeroDaResidencia, ddi, ddd, telefone));
		}
		return usuarios;
	}

	private List<Usuario> lerPerfisDeUsuario(ResultSet conjuntoDeResultados) throws SQLException {
		if (conjuntoDeResultados.next()) {

			List<Usuario> perfisUsuario = new ArrayList<>(4);

			if (conjuntoDeResultados.getString("idCliente") != null) {
				int id = conjuntoDeResultados.getInt("id");
				int idCliente = conjuntoDeResultados.getInt("idCliente");
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

				perfisUsuario.add(new Cliente(id, idCliente, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado,
						cidade, rua, bairro, cep, numeroDaResidencia, ddi, ddd, telefone));
			}

			if (conjuntoDeResultados.getString("idGerente") != null) {
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
				boolean ativo = conjuntoDeResultados.getBoolean("perfilDeGerenteEstaAtivo");
				boolean superGerente = conjuntoDeResultados.getBoolean("superGerente");

				perfisUsuario.add(new Gerente(id, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua,
						bairro, cep, numeroDaResidencia, ddi, ddd, telefone, ativo, superGerente));
			}

			if (conjuntoDeResultados.getString("idVendedor") != null) {
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
				boolean ativo = conjuntoDeResultados.getBoolean("perfilVendedorEstaAtivo");

				perfisUsuario.add(new Vendedor(id, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade,
						rua, bairro, cep, numeroDaResidencia, ddi, ddd, telefone, ativo));
			}

			if (conjuntoDeResultados.getString("idCaixa") != null) {
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
				boolean ativo = conjuntoDeResultados.getBoolean("perfilCaixaEstaAtivo");

				perfisUsuario.add(new Caixa(id, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua,
						bairro, cep, numeroDaResidencia, ddi, ddd, telefone, ativo));
			}

			return perfisUsuario;

		} else {

			throw new RuntimeException("Usuario não encontrado");
		}
	}

}
