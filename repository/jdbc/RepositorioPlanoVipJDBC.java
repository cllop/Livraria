package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import config.FabricaDeConexao;
import modelo.PlanoVip;
import repository.RepositorioPlanoVip;

public class RepositorioPlanoVipJDBC extends RepositorioJDBC implements RepositorioPlanoVip{

	public RepositorioPlanoVipJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	public void add(PlanoVip planoVip) {
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
					"INSERT INTO planoVip('preco', 'descricao', 'ativo', 'nome') VALUES (?, ?, ?, ?)"
					);
			ps.setInt(1, planoVip.getPreco().getCentavos());
			ps.setString(2, planoVip.getDescricao());
			ps.setBoolean(3, planoVip.isAtivo());
			ps.setString(4, planoVip.getNome());
			
		}catch(SQLException e){
			throw new RuntimeException("Não foi possível adicionar plano vip.", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void remove(PlanoVip planoVip) {
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
					"DELETE FROM planoVip WHERE id=?"
					);
			ps.setInt(1, planoVip.getId());
			
		}catch(SQLException e) {
			throw new RuntimeException("Não foi possível remover plano vip.", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void uptade(PlanoVip planoVip) {
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
					"UPTADE planoVip SET preco=?, ativo=?"
					);
			ps.setInt(1, planoVip.getPreco().getCentavos());
			ps.setBoolean(2, planoVip.isAtivo());		
			ps.execute();
		}catch(SQLException e) {
			throw new RuntimeException("Não foi possível alterar plano vip.", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	@Override
	public List<PlanoVip> getAll() {
	
		return null;
	}

	@Override
	public PlanoVip findByNome(String nome) {
		
		return null;
	}
	
	private List<PlanoVip> lerLIstaDePlanosVip() {
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
			ps = con.prepareStatement("SELECT *");
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
	}
}
