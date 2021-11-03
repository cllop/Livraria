package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Cliente;
import repository.RepositorioCliente;

public class RepositorioClienteJDBC extends RepositorioJDBC implements RepositorioCliente{

	public RepositorioClienteJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	public void add(Cliente cliente) { // corrigir metodo
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		boolean transacaoFoiAutomatica;
		PreparedStatement ps;
		try {
			transacaoFoiAutomatica = con.getAutoCommit();
			
			if(transacaoFoiAutomatica) {
				con.setAutoCommit(false);
			}
			RepositorioUsuarioJDBC repositorioUsuario = new RepositorioUsuarioJDBC(null);
			repositorioUsuario.usarConexao(con);
			repositorioUsuario.add(cliente);
			ps = con.prepareStatement(
					"INSERT INTO cliente('id') VALUES (?)"); //cliente nao possui atributo proprio.
			ps.setInt(1, cliente.getId());
			ps.execute();
			
			if(transacaoFoiAutomatica) {
				con.commit();
				con.setAutoCommit(true);
			}
		}catch(SQLException e){
			throw new RuntimeException("Não foi possível adicionar cliente.", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void remove(Cliente cliente) {
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
			ps = con.prepareStatement(
					"DELETE INTO cliente WHERE id=?"
					);
			ps.setInt(1, cliente.getId());
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível remover cliente.", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void update(Cliente cliente) {
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
			ps = con.prepareStatement(
					"UPDATE cliente SET nomeDeUsuario=?, sobrenome=?, nomeDeUsuario=?,rua=?,bairro=?,cep=?,numeroDaResidencia=? WHERE id=?"
					);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getSobrenome());
			ps.setString(3, cliente.getNomeDeUsuario());
			ps.setString(4, cliente.getRua());
			ps.setString(5, cliente.getBairro());
			ps.setLong(6, cliente.getCep());
			ps.setInt(7, cliente.getNumeroDaResidencia());
		}catch (SQLException e){
			throw new RuntimeException("Não foi possível alterar os dados do cliente.", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public Cliente find(int id) { 
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
			ps = con.prepareStatement(
					"SELECT * FROM perfilCliente LEFT JOIN usuario ON perfilCliente.id = usuario.id WHERE perfilCliente.id=? "
					);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			return lerCliente(rs);
			
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar cliente.", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public Cliente findByCpf(long cpf) { 
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
			ps = con.prepareStatement(
					"SELECT * FROM cliente WHERE cpf=?"
					);
			ps.setLong(1, cpf);
			
			ResultSet rs = ps.executeQuery();
			
			return lerCliente(rs);
			
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar cliente!", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public Cliente findByNomeDeUsuario(String nomeDeUsuario) {
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
			ps = con.prepareStatement(
					"SELECT * FROM cliente WHERE nomeDeUsuario=?"
					);
			ps.setString(1, nomeDeUsuario);
			
			ResultSet rs = ps.executeQuery();
			
			return lerCliente(rs);
			
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar cliente!", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}
	
	public Cliente findByNomeDeUsuarioAndSenha(String nomeDeUsuario, String senha) {
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
			ps = con.prepareStatement("SELECT * FROM cliente WHERE nomeDeUsuario=?, senha=?");
			ps.setString(1, nomeDeUsuario);
			ps.setString(2, senha);
			
			ResultSet rs = ps.executeQuery();
			
			return lerCliente(rs);
		}catch(SQLException e) {
			throw new RuntimeException ("Não foi possivel encontrar o cliente!", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}
	
	public List<Cliente> lerClientes(ResultSet conjuntoDeResultados) throws SQLException { 
		
		List<Cliente> clientes = new ArrayList<>(conjuntoDeResultados.getRow());
		
		while(conjuntoDeResultados.next()) {
			
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
			byte ddi = conjuntoDeResultados.getByte("ddi");
			byte ddd = conjuntoDeResultados.getByte("ddd");
			int telefone = conjuntoDeResultados.getInt("telefone");
			
			clientes.add(new Cliente(id, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro, cep,numeroDaResidencia, ddi, ddd, telefone));
		}
		return clientes;
	}
	
	public Cliente lerCliente(ResultSet conjuntoDeResultados) throws SQLException {
		
		if(conjuntoDeResultados.next()) {
			
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
		
			return new Cliente(id, idCliente, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro, cep,
					numeroDaResidencia, ddi, ddd, telefone);
		}else {
			throw new RuntimeException("Cliente não encontrado");
		}
		
	}
	
}
