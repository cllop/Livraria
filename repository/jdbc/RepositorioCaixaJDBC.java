package repository.jdbc;

import java.util.List;

import config.FabricaDeConexao;
import modelo.Caixa;
import repository.RepositorioCaixa;

public class RepositorioCaixaJDBC extends RepositorioJDBC implements RepositorioCaixa{

	public RepositorioCaixaJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	@Override
	public void add(Caixa Caixa) {
		
		
		//ver se existe usuario existe com aquele cpf
		
		//se o usuario existe voce pega o id dele com  aquele cpf
		
		//se o usuario não existe voce cria ele e pega o id dele com aquele cpf
		
		// cria um perfilcaixa com id de usuario
		
	}

	@Override
	public void update(Caixa caixa) {
		// TODO Auto-generated method stub
		
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
