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
			throw new IllegalStateException("N�o � possivel criar uma conecx�o, se h� uma j� existente!");
		}
		conecxaoAtual = fabricadeconexoes.criarConecxao();
		
	}
	
	public void usarConecxao(Connection conecxao){
		
		if(conecxaoAtual !=null) {
			throw new IllegalStateException("N�o � possivel usar uma conecxao, se j� ha uma existente!");
		
		}
		conecxaoAtual = conecxao;
		
	}
	
	public Connection getConecxao() {
		return conecxaoAtual;
	}
	
	
}
