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
			throw new IllegalStateException("Não é possivel criar uma conexão, se há uma já existente!");
		}
		conexaoAtual = fabricadeconexoes.criarConecxao();
		return conexaoAtual;
	}
	
	public void usarConexao(Connection conexao){
		
		if(conexaoAtual !=null) {
			throw new IllegalStateException("Não é possivel usar uma conexão, se já ha uma existente!");
		
		}
		conexaoAtual = conexao;
	}
	
	public Connection getConexao() {
		return conexaoAtual;
	}
	
	public void fecharConexao() {
		
	}
	
	
}
