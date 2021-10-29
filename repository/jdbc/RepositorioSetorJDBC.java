package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.FabricaDeConexao;
import modelo.Setor;
import repository.RepositorioSetor;

public class RepositorioSetorJDBC extends RepositorioJDBC implements RepositorioSetor{

	public RepositorioSetorJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}
	
	public Setor findByNome(String nome) {
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
			ps = con.prepareStatement("SELECT * FROM setor WHERE nome=?");
			ps.setString(1, nome);
			ps.execute();
			
			ResultSet rs = ps.executeQuery();
			
			return lerSetor(rs);
		
		}catch(SQLException e) {
			throw new RuntimeException("Não foi possivel encontrar o produto.", e);
		}finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}
	
	public Setor findById(int id) {
		Connection con = super.getConexao();

		boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}

		PreparedStatement ps = null;

		try {
			
			ps = con.prepareStatement("SELECT * FROM setor WHERE id=? ");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			return lerSetor(rs);
			
		}catch(SQLException e) {
			throw new RuntimeException("Operação não pode ser concluida");
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}
	
	public Setor lerSetor(ResultSet conjuntoDeResultados) {
		
		if(conjuntoDeResultados.next()) {
			
			int id = conjuntoDeResultados.getInt("id");
			
			return new Setor(id);
		} else {
			throw new RuntimeException("Setor não encontrado");
		}
	}
}
