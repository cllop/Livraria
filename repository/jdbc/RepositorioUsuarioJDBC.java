package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Usuario;
import repository.RepositorioUsuario;

public class RepositorioUsuarioJDBC extends RepositorioJDBC implements RepositorioUsuario {

	private List<Usuario> usuario;
	
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

	public List<Usuario> findByNomeDeUsuarioAndSenha(String nome, String senha) {

		return null;
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
		
		return null;
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
			boolean existeResultado = conjuntoDeResultados.next();
			long cpf = conjuntoDeResultados.getLong("cpf");
			String sobrenome = conjuntoDeResultados.getString("sobrenome");
			String nomeDeUsuario = conjuntoDeResultados.getString("nomeDeUsuario");
			String rua = conjuntoDeResultados.getString("rua");
			String bairro = conjuntoDeResultados.getString("bairro");
			int cep = conjuntoDeResultados.getInt("cep");
			int numeroDaResidencia = conjuntoDeResultados.getInt("numeroDeResidencia");
			
			return usuario;
		}catch (Exception e) {
			
			throw new RuntimeException("Operação não pode ser comcluida");
		}
		
	}

}
