package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Cliente;
import modelo.Gerente;
import modelo.Usuario;
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
					"INSERT INTO usuario (id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
			ps.setLong(2, usuario.getCpf());
			ps.setString(3, usuario.getNome());
			ps.setString(4, usuario.getSobrenome());
			ps.setString(5, usuario.getNomeDeUsuario());
			ps.setString(6, usuario.getRua());
			ps.setString(7, usuario.getBairro());
			ps.setInt(8, usuario.getCep());
			ps.setInt(9, usuario.getNumeroDaResidencia());

			ps.execute();
		} catch (SQLException e) {
			
			throw new RuntimeException("Operação não pode ser comcluida");
		}
	}

	public List<Usuario> findTodosPerfisByNomeDeUsuarioAndSenha(String nomeDeUsuario, String senha) {
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
			
			ps = conexao.prepareStatement("SELECT usuario.*,"
					+ " perfilCliente.id as idCliente,"
					+ " perfilGerente.id as idGerente, gerente.ativo as perfilDeGerenteEstaAtivo, perfilGerente.superGerente,"
					+ " perfilVendedor.id as idVendedor, perfilVendedor.estaAtivo as perfilVendedorEstaAtivo, "
					+ " pefilCaixa.id as idCaixa, perfilCaixa.estaAtivo as perfilCaixa"
					+ " usuario LEFT JOIN perfilCliente ON usuario.id =  perfilCliente.id  LEFT JOIN perfilGerente ON usuario.id= perfilGerente LEFT JOIN perfilCaixa ON usuario.id = perfil.id LEFT JOIN perfilVendedor ON usuario.id = perfilVendedor.id WHERE nomeDeUsuario=? AND senha=? ");
			
			ps.setString(1,nomeDeUsuario);
			ps.setString(2, senha);
			
			ResultSet conjuntoDeResultados = ps.executeQuery();
			
			return lerPerfisDeUsuario(conjuntoDeResultados);
			
		}catch (SQLException e) {
			throw new RuntimeException("Operação não pode ser comcluida");
		}

		
	}

	

	@Override
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
			
			ps= conexao.prepareStatement("UPDATE usuario");
		
		} catch (SQLException e) {
			
			throw new RuntimeException("Operação não pode ser comcluida");
			
		}
		
		
	}

	@Override
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
			
			
		}catch (Exception e) {
			
			throw new RuntimeException("Operação não pode ser comcluida");
		}
		
	}

	@Override
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
		}catch (Exception e) {
			
			throw new RuntimeException("Operação não pode ser comcluida");
		}
		
	}
	
	private Usuario lerUsuario(ResultSet conjuntoDeResultados)throws SQLException{
		
		
		boolean existeResultado = conjuntoDeResultados.next();
		
		if(existeResultado) {
			int id = conjuntoDeResultados.getInt("id");
			long cpf = conjuntoDeResultados.getLong("cpf");
			String sobrenome = conjuntoDeResultados.getString("sobrenome");
			String nomeDeUsuario = conjuntoDeResultados.getString("nomeDeUsuario");
			String rua = conjuntoDeResultados.getString("rua");
			String bairro = conjuntoDeResultados.getString("bairro");
			int cep = conjuntoDeResultados.getInt("cep");
			int numeroDaResidencia = conjuntoDeResultados.getInt("numeroDeResidencia");
			
			return new Usuario(id, cpf, nomeDeUsuario, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia);
			
		}else {
			
			throw new RuntimeException("Usuario não enconrado");
			
		}

		
	}
	private List<Usuario> lerListaDeUsuario(ResultSet conjuntoDeResultados) throws SQLException{
		
		List<Usuario> usuarios = new ArrayList<>(conjuntoDeResultados.getRow());
		
	
		while(conjuntoDeResultados.next()) {
			int id = conjuntoDeResultados.getInt("id");
			long cpf = conjuntoDeResultados.getLong("cpf");
			String sobrenome = conjuntoDeResultados.getString("sobrenome");
			String nomeDeUsuario = conjuntoDeResultados.getString("nomeDeUsuario");
			String rua = conjuntoDeResultados.getString("rua");
			String bairro = conjuntoDeResultados.getString("bairro");
			int cep = conjuntoDeResultados.getInt("cep");
			int numeroDaResidencia = conjuntoDeResultados.getInt("numeroDeResidencia");
			
			usuarios.add(new Usuario(id, cpf, nomeDeUsuario, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia));
			
		}
		return usuarios;
		
	}
	
	private List<Usuario> lerPerfisDeUsuario(ResultSet conjuntoDeResultados) throws SQLException{
		
		if(conjuntoDeResultados.next()) {
			List<Usuario> perfisUsuario = new ArrayList<>(4);
			
			if(conjuntoDeResultados.getString("idCliente")!= null) {
				int id = conjuntoDeResultados.getInt("id");
				long cpf = conjuntoDeResultados.getLong("cpf");
				String sobrenome = conjuntoDeResultados.getString("sobrenome");
				String nomeDeUsuario = conjuntoDeResultados.getString("nomeDeUsuario");
				String rua = conjuntoDeResultados.getString("rua");
				String bairro = conjuntoDeResultados.getString("bairro");
				int cep = conjuntoDeResultados.getInt("cep");
				int numeroDaResidencia = conjuntoDeResultados.getInt("numeroDeResidencia");
				
				// Quando tiver dados de cliente leia aqui
				
				perfisUsuario.add(new Cliente(id, cpf, nomeDeUsuario, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia));
				
			}
			
			if(conjuntoDeResultados.getString("idGerente")!= null) {
				int id = conjuntoDeResultados.getInt("id");
				long cpf = conjuntoDeResultados.getLong("cpf");
				String sobrenome = conjuntoDeResultados.getString("sobrenome");
				String nomeDeUsuario = conjuntoDeResultados.getString("nomeDeUsuario");
				String rua = conjuntoDeResultados.getString("rua");
				String bairro = conjuntoDeResultados.getString("bairro");
				int cep = conjuntoDeResultados.getInt("cep");
				int numeroDaResidencia = conjuntoDeResultados.getInt("numeroDeResidencia");
				
				
				boolean ativo = conjuntoDeResultados.getBoolean("perfilDeGerenteEstaAtivo");
				boolean superGerente = conjuntoDeResultados.getBoolean("superGerente");
				
				perfisUsuario.add(new Gerente(id, cpf, nomeDeUsuario, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, ativo, superGerente));
			}
			
			
		}else {
			throw new RuntimeException("Usuario não encontrado");
		}
		
	}

}
