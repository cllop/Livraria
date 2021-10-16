package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Gerente;
import repository.RepositorioGerente;

public class RepositorioGerenteJDBC extends RepositorioJDBC implements RepositorioGerente {

	public RepositorioGerenteJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
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
		PreparedStatement ps;
		try {
			//ver se existe usuario existe com aquele cpf
			ps = con.prepareStatement(
					"SELECT id FROM usuario WHERE cpf=?");
			ps.setLong(1, gerente.getCpf());

			ResultSet rs = ps.executeQuery();
			boolean temResultado = rs.next();
			int id = -1;
			
			if(temResultado) {
				//se o usuario existe voce pega o id dele com  aquele cpf
				id = rs.getInt(1);
				ps.close();
				ps = con.prepareStatement("INSERT INTO PerfilGerente (id, superGerente) VALUES (?,?)");
				
				
				
			} else {
				//se o usuario não existe voce cria ele e pega o id dele com aquele cpf
			}
			// cria um perfilcaixa com id de usuario


		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar gerente!", e);
		}
		
		
	}
	
	public void remove(Gerente gerente) {
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("DELETE INTO gerente WHERE id=?");
			ps.setInt(1, gerente.getId());
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível remover gerente.", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void update(Gerente gerente) {
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
			ps = con.prepareStatement("UPDATE gerente SET ativo=?, superGerente=? WHERE id=?");
			ps.setBoolean(1, gerente.isAtivo());
			ps.setBoolean(2, gerente.isSuperGerente());
			ps.setInt(3, gerente.getId());
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível alterar os dados do gerente!", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public Gerente find(int id) {
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"SELECT * FROM usuario INNER JOIN gerente ON usuario.id = gerente.id WHERE gerente.id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			boolean temResultado = rs.next();

			if (temResultado) {
				long cpf = rs.getLong(2);
				String nome = rs.getString(3);
				String sobrenome = rs.getString(4);
				String nomeDeUsuario = rs.getString(5);
				String rua = rs.getString(6);
				String bairro = rs.getString(7);
				int cep = rs.getInt(8);
				int numeroDaResidencia = rs.getInt(9);
				boolean ativo = rs.getBoolean(10);
				boolean ehSuperGerente = rs.getBoolean(11);

				return new Gerente(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, ativo,
						ehSuperGerente);
			} else {
				throw new RuntimeException("Gerente não cadastrado.");
			}

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar gerente!", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public Gerente findByCpf(long cpf) {
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"SELECT * FROM usuario INNER JOIN gerente ON usuario.id = gerente.id WHERE gerente.id=");
			ps.setLong(1, cpf);

			ResultSet rs = ps.executeQuery();
			boolean temResultado = rs.next();

			if (temResultado) {
				int id = rs.getInt(1);
				String nome = rs.getString(3);
				String sobrenome = rs.getString(4);
				String nomeDeUsuario = rs.getString(5);
				String rua = rs.getString(6);
				String bairro = rs.getString(7);
				int cep = rs.getInt(8);
				int numeroDaResidencia = rs.getInt(9);
				boolean ativo = rs.getBoolean(10);
				boolean ehSuperGerente = rs.getBoolean(11);

				return new Gerente(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, ativo,
						ehSuperGerente);
			} else {
				throw new RuntimeException("Gerente não cadastrado.");
			}

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar gerente!", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public List<Gerente> findByNome(String nome) {
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"SELECT * FROM usuario INNER JOIN gerente ON usuario.id = gerente.id WHERE gerente.id=?");
			ps.setString(1, nome);

			ResultSet rs = ps.executeQuery();
			List<Gerente> listaDeGerente = new ArrayList<>(rs.getRow());

			while (rs.next()) {
				int id = rs.getInt(1);
				long cpf = rs.getLong(2);
				String sobrenome = rs.getString(4);
				String nomeDeUsuario = rs.getString(5);
				String rua = rs.getString(6);
				String bairro = rs.getString(7);
				int cep = rs.getInt(8);
				int numeroDaResidencia = rs.getInt(9);
				boolean ativo = rs.getBoolean(10);
				boolean ehSuperGerente = rs.getBoolean(11);

				listaDeGerente.add(new Gerente(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep,
						numeroDaResidencia, ativo, ehSuperGerente));
			}
			return listaDeGerente;

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar gerente!", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

}
