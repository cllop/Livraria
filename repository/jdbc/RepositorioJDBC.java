package repository.jdbc;

import java.sql.Connection;

import config.FabricaDeConexao;

public class RepositorioJDBC {
	
	private FabricaDeConexao fabricadeconexoes;
	private Connection conecxaoAtual;
	
	public RepositorioJDBC(FabricaDeConexao fabricaDeConexoes) {
		super();
		this.fabricadeconexoes = fabricaDeConexoes;
	}
	
	public void criarConecxao() {
		
		if(conecxaoAtual!=null) {
			throw new IllegalStateException("Não é possivel criar uma conecxão, se há uma já existente!");
		}
		conecxaoAtual = fabricadeconexoes.criarConecxao();
		
	}
	
	public void usarConecxao(Connection conecxao){
		
		if(conecxaoAtual !=null) {
			throw new IllegalStateException("Não é possivel usar uma conecxao, se já ha uma existente!");
		
		}
		conecxaoAtual = conecxao;
		
	}
	
	public Connection getConecxao() {
		return conecxaoAtual;
	}
	
	
}
