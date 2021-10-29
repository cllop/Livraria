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
			// ver se existe usuario existe com aquele cpf
			ps = con.prepareStatement("SELECT id FROM usuario WHERE cpf=?");
			ps.setLong(1, gerente.getCpf());

			ResultSet rs = ps.executeQuery();
			boolean temResultado = rs.next();
			int id = -1;

			if (temResultado) {
				// se o usuario existe voce pega o id dele com aquele cpf
				id = rs.getInt(1);
				ps.close();
				ps = con.prepareStatement("INSERT INTO PerfilGerente (id, superGerente) VALUES (?,?)");

			} else {
				// se o usuario n�o existe voce cria ele e pega o id dele com aquele cpf
			}
			// cria um perfilcaixa com id de usuario

		} catch (SQLException e) {
			throw new RuntimeException("N�o foi poss�vel encontrar gerente!", e);
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
			
			throw new RuntimeException("N�o foi poss�vel remover gerente.", e);
			
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
			throw new RuntimeException("N�o foi poss�vel alterar os dados do gerente!", e);
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
			return lerGerente(rs);

		} catch (SQLException e) {
			throw new RuntimeException("N�o foi poss�vel encontrar gerente!", e);
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
			
			return lerGerente(rs);

		} catch (SQLException e) {
			throw new RuntimeException("N�o foi poss�vel encontrar gerente!", e);
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

			return lerGerentes(rs);
			
	

		}catch(SQLException e){
			
		throw new RuntimeException("N�o foi poss�vel encontrar gerente!", e);
		
		}finally{
			
			if (!jaExisteConexao) {
			super.fecharConexao();
			}
		}
	}

	public Gerente lerGerente(ResultSet conjuntoDeResultados) throws SQLException {
		boolean existeResultado = conjuntoDeResultados.next();

		if (existeResultado) {
			int id = conjuntoDeResultados.getInt("id");
			String nome = conjuntoDeResultados.getString("nome");
			String sobrenome = conjuntoDeResultados.getString("sobrenome");
			String nomeDeUsuario = conjuntoDeResultados.getString("nomeDeUsuario");
			long cpf = conjuntoDeResultados.getLong("cpf");
			long telefone = conjuntoDeResultados.getLong("telefone");
			String rua = conjuntoDeResultados.getString("rua");
			String bairro = conjuntoDeResultados.getString("bairro");
			int cep = conjuntoDeResultados.getInt("cep");
			int numeroDaResidencia = conjuntoDeResultados.getInt("numeroDaResidencia");
			byte ddi = conjuntoDeResultados.getByte("ddi");
			byte ddd = conjuntoDeResultados.getByte("ddd");
			String pais = conjuntoDeResultados.getString("pais");
			String cidade = conjuntoDeResultados.getString("cidade");
			String estado = conjuntoDeResultados.getString("estado");
			boolean ativo = conjuntoDeResultados.getBoolean("ativo");
			boolean ehSuperGerente = conjuntoDeResultados.getBoolean("ehSuperGerente");

			return new Gerente(id, cpf, nome, sobrenome, nomeDeUsuario, pais, estado, cidade, rua, bairro, cep,
					numeroDaResidencia, ddi, ddd, ddd, ativo, ehSuperGerente);

		} else {

			throw new RuntimeException("Gerente n�o encontrado");

		}
	}

	public List<Gerente> lerGerentes(ResultSet conjuntoDeResultados) throws SQLException {

			//listaDeGerente.add(new Gerente(id, cpf, nome, sobrenome, nomeDeUsuario, pais, +estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi, ddd, telefone));
		}
		return listaDeGerente;
	}

}
