package repository.jdbc;

import java.sql.Connection;

import config.FabricaDeConexao;

public class RepositorioJDBC {
	
	private FabricaDeConexao fabricadeconexoes;
	private Connection conexaoAtual;
	
	public RepositorioJDBC(FabricaDeConexao fabricaDeConexoes) {
		super();
		this.fabricadeconexoes = fabricaDeConexoes;
	}
	
	public Connection criarConexao() {
		
		if(conexaoAtual!=null) {
			throw new IllegalStateException("N�o � possivel criar uma conex�o, se h� uma j� existente!");
		}
		conexaoAtual = fabricadeconexoes.criarConecxao();
		return conexaoAtual;
	}
	
	public void usarConexao(Connection conexao){
		
		if(conexaoAtual !=null) {
			throw new IllegalStateException("N�o � possivel usar uma conex�o, se j� ha uma existente!");
		
		}
		conexaoAtual = conexao;
	}
	
	public Connection getConexao() {
		return conexaoAtual;
	}
	
	public void fecharConexao() {
		
	}
	
	
}
