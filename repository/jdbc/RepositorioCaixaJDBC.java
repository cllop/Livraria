package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Caixa;
import repository.RepositorioCaixa;

public class RepositorioCaixaJDBC extends RepositorioJDBC implements RepositorioCaixa {

	public RepositorioCaixaJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	@Override
	public void add(Caixa Caixa) {

		// ver se existe usuario existe com aquele cpf

		// se o usuario existe voce pega o id dele com aquele cpf

		// se o usuario não existe voce cria ele e pega o id dele com aquele cpf

		// cria um perfilcaixa com id de usuario

	}

	public void uptade(Caixa caixa){
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
			ps = con.prepareStatement("UPDATE Caixa SET *");
			
			
			
		}catch (SQLException e){
			throw new RuntimeException("Não foi possivel alterar os dados do caixa.", e);
			
		}finally{
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	@Override
	public Caixa find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Caixa> findBynome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
