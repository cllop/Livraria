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
		// TODO Auto-generated method stub
		
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
