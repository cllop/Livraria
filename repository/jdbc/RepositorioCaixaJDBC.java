package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Caixa;
import modelo.Fornecedor;
import repository.RepositorioCaixa;

public class RepositorioCaixaJDBC extends RepositorioJDBC implements RepositorioCaixa {

	public RepositorioCaixaJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	@Override
	public void add(Caixa Caixa) {
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
			ps = con.prepareStatement("SELECT * FROM perfilcaixa WHERE cpf=?");
			ps.setLong(1, cpf);
			ps.execute();

			ResultSet rs = ps.executeQuery();
			boolean temResultado = rs.next();

			if (temResultado) {
				int id = rs.getInt("id");
			}

			// ver se existe usuario existe com aquele cpf

			// se o usuario existe voce pega o id dele com aquele cpf

			// se o usuario não existe voce cria ele e pega o id dele com aquele cpf

			// cria um perfilcaixa com id de usuario
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void remove(Caixa caixa) {
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
			ps = con.prepareStatement("DELETE FROM perfilcaixa WHERE id=?");
			ps.setLong(1, caixa.getId());
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível remover o caixa.", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void update(Caixa caixa) {
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
					"UPDATE perfilcaixa SET nome=?, sobrenome=?, nomeDeUsuario=?, rua=?, bairro=?, cep=?, numeroDoImovel=? WHERE id=?");
			ps.setString(1, caixa.getNome());
			ps.setString(2, caixa.getSobrenome());
			ps.setString(3, caixa.getNomeDeUsuario());
			ps.setString(4, caixa.getRua());
			ps.setString(5, caixa.getBairro());
			ps.setInt(6, caixa.getCep());
			ps.setInt(7, caixa.getNumeroDaResidencia());

			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possivel alterar os dados do caixa.", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public Caixa find(int id) {
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
			ps = con.prepareStatement("SELECT * FROM perfilcaixa WHERE id=?");
			ps.setInt(1, id);
			ps.execute();

			ResultSet rs = ps.executeQuery();
			boolean temResultado = rs.next();
			if (temResultado) {
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String nomeDeUsuario = rs.getString("nomeDeUsuario");
				String rua = rs.getString("rua");
				String bairro = rs.getString("bairro");
				int cep = rs.getInt("cep");
				short numeroDaResidencia = rs.getShort("numeroDaResidencia");

				return new Caixa(id, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia);
			} else {
				throw new RuntimeException("Caixa não cadastrado.");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível encontrar fornecedor.", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	@Override
	public List<Caixa> findBynome(String nome) {
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
					"SELECT * FROM perfilcaixa WHERE nome=?"
					);
			ps.setString(1, nome);
			ps.execute();
			
			ResultSet rs = ps.executeQuery();
			boolean temResultado = rs.next();
			
			if(temResultado) {
				int id = rs.getInt("id");
				String sobrenome = rs.getString("sobrenome");
				String nomeDeUsuario = rs.getString("nomeDeUsuario");
				String rua = rs.getString("rua");
				String bairro = rs.getString("bairro");
				int cep = rs.getInt("cep");
				short numeroDaResidencia = rs.getShort("numeroDaResidencia");
				
				return (List<Caixa>) new Caixa(id, sobrenome, nome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia);
		  }else {
			throw new RuntimeException("Caixa não cadastrado.");
			
		  }
		}catch(SQLException e){
			throw new RuntimeException("Não foi possível encontrar o caixa.", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
		   }
		}	
	}
 }
			
	   
