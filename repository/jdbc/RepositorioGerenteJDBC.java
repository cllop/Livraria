package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Gerente;
import repository.RepositorioGerente;

public class RepositorioGerenteJDBC extends RepositorioJDBC implements RepositorioGerente{

	public RepositorioGerenteJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	public Gerente getGerente(long cpf) {
		return null;
	}

	public void add(Gerente gerente) {
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
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
			repositorioUsuario.add(gerente);
			
			ps = con.prepareStatement(
					"INSERT INTO gerente('id') VALUES (?)");
			ps.setInt(1, gerente.getId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void remove(Gerente gerente) {
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
					"DELETE INTO gerente WHERE id=?"
					);
			ps.setInt(1, gerente.getId());
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível remover gerente.", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void uptade(Gerente gerente) {
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
					"UPTADE gerente SET nome=?, sobrenome=?, nomeDeUsuario=?,rua=?,bairro=?,cep=?,numeroDaResidencia=? WHERE id=?"
					);
			ps.setString(1, gerente.getNome());
			ps.setString(2, gerente.getSobrenome());
			ps.setString(3, gerente.getNomeDeUsuario());
			ps.setString(4, gerente.getRua());
			ps.setString(5, gerente.getBairro());
			ps.setLong(6, gerente.getCep());
			ps.setInt(7, gerente.getNumeroDaResidencia());
		}catch (SQLException e){
			throw new RuntimeException("Não foi possível alterar os dados do gerente!", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public Gerente find(int id) {
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
					"SELECT * FROM gerente WHERE id=?"
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
				
				return new Gerente(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia);
			}else {
				throw new RuntimeException("Gerente não cadastrado.");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar gerente!", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}
	
	public Gerente findByCpf(long cpf) {
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
					"SELECT * FROM gerente WHERE cpf=?"
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
				
				return new Gerente(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia);
			}else {
				throw new RuntimeException("Gerente não cadastrado.");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar gerente!", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public List<Gerente> findByNomeDeUsuario(String nomeDeUsuario) {
		return null;
	}

}
