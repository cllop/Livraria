package repository.jdbc;

import java.sql.Connection;

import config.FabricaDeConexao;

public class RepositorioJDBC {
	
	private FabricaDeConexao fabricadeconexoes;
	private Connection conexcaoAtual;
	
	public RepositorioJDBC(FabricaDeConexao fabricaDeConexoes) {
		super();
		this.fabricadeconexoes = fabricaDeConexoes;
	}
	
	public Connection criarConexao() {
		
		if(conexcaoAtual!=null) {
			throw new IllegalStateException("N�o � possivel criar uma conex�o, se h� uma j� existente!");
		}
		conexcaoAtual = fabricadeconexoes.criarConecxao();
		return conexcaoAtual;
	}
	
	public void usarConexao(Connection conexao){
		
		if(conexcaoAtual !=null) {
			throw new IllegalStateException("N�o � possivel usar uma conex�o, se j� ha uma existente!");
		
		}
		conexcaoAtual = conexao;
	}
	
	public Connection getConexao() {
		return conexcaoAtual;
	}
	
	public void fecharConexao() {
		
	}
	
	
}
