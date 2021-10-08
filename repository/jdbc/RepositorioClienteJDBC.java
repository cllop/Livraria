package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Cliente;
import repository.RepositorioCliente;

public class RepositorioClienteJDBC extends RepositorioJDBC implements RepositorioCliente{

	public RepositorioClienteJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	public Cliente getCliente(long cpf) {
		
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
					"INSERT INTO Cliente('cpf','nome','sobrenome','nomeDeUsuario','rua','bairro','CEP','NumeroDaResidencia') VALUES (?,?,?,?,?,?,?,?)");
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
					"DELETE INTO Cliente WHERE id=?"
					);
			ps.setInt(1, cliente.getId());
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível remover cliente!", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	@Override
	public void uptade(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente findByCpf(long cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> findByNomeDeUsuario(String nomeDeUsuario) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
