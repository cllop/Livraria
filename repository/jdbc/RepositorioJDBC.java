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
			throw new IllegalStateException("Não é possivel criar uma conexão, se há uma já existente!");
		}
		conexcaoAtual = fabricadeconexoes.criarConecxao();
		return conexcaoAtual;
	}
	
	public void usarConexao(Connection conexao){
		
		if(conexcaoAtual !=null) {
			throw new IllegalStateException("Não é possivel usar uma conexão, se já ha uma existente!");
		
		}
		conexcaoAtual = conexao;
	}
	
	public Connection getConexao() {
		return conexcaoAtual;
	}
	
	public void fecharConexao() {
		
	}
	
	
}
