package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Cliente;
import repository.RepositorioCliente;

public class RepositorioClienteJDBC extends RepositorioJDBC implements RepositorioCliente{

	public RepositorioClienteJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	public Cliente getCliente(long cpf) { //metodo igual de findByCpf?
		return null;
	}
	
	public void add(Cliente cliente) {
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
					"INSERT INTO cliente('cpf','nome','sobrenome','nomeDeUsuario','rua','bairro','CEP','NumeroDaResidencia') VALUES (?,?,?,?,?,?,?,?)");
			ps.setLong(1, cliente.getCpf());
			ps.setString(2, cliente.getNome());
			ps.setString(3, cliente.getSobrenome());
			ps.setString(4, cliente.getNomeDeUsuario());
			ps.setString(5, cliente.getRua());
			ps.setString(6, cliente.getBairro());
			ps.setInt(7, cliente.getCep());
			ps.setInt(8, cliente.getNumeroDaResidencia());
		} catch (SQLException e) {
			e.printStackTrace();
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

	public void uptade(Cliente cliente) {
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
					"UPTADE cliente SET nome=?, sobrenome=?, nomeDeUsuario=?,rua=?,bairro=?,cep=?,numeroDaResidencia=? WHERE id=?"
					);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getSobrenome());
			ps.setString(3, cliente.getNomeDeUsuario());
			ps.setString(4, cliente.getRua());
			ps.setString(5, cliente.getBairro());
			ps.setLong(6, cliente.getCep());
			ps.setInt(7, cliente.getNumeroDaResidencia());
		}catch (SQLException e){
			throw new RuntimeException("Não foi possível alterar os dados do cliente!", e);
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
					"SELECT * FROM cliente WHERE id=?"
					);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			boolean temResultado = rs.next();
			
			if(temResultado) {
				long cpf = rs.getLong(2);
				String nome = rs.getString(3);
				String sobrenome = rs.getString(4);
				String nomeDeUsuario = rs.getString(5);
				String rua = rs.getString(6);
				String bairro = rs.getString(7);
				int cep = rs.getInt(8);
				int numeroDaResidencia = rs.getInt(9);
				
				return new Cliente(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia);
			}else {
				throw new RuntimeException("Cliente não cadastrado.");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar cliente!", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public Cliente findByCpf(long cpf) { //metodo igual o de getCliente?
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
			boolean temResultado = rs.next();
			
			if(temResultado) {
				int id = rs.getInt(2);
				String nome = rs.getString(3);
				String sobrenome = rs.getString(4);
				String nomeDeUsuario = rs.getString(5);
				String rua = rs.getString(6);
				String bairro = rs.getString(7);
				int cep = rs.getInt(8);
				int numeroDaResidencia = rs.getInt(9);
				
				return new Cliente(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia);
			}else {
				throw new RuntimeException("Cliente não cadastrado.");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar cliente!", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public List<Cliente> findByNomeDeUsuario(String nomeDeUsuario) {
		return null;
	}
	
}
