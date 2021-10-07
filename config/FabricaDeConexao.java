package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	private String url;
	private String usuario;
	private String senha;
	
	public FabricaDeConexao(String url, String usuario, String senha) {
		this.url = url;
		this.usuario = usuario;
		this.senha = senha;
		
		
	}
	public Connection criarConecxao(){
		
		 Connection conecxao = null;
		 
		 try {
			 
			 conecxao = DriverManager.getConnection(url, usuario, senha);
			 
		} catch (SQLException excecao) {
			
			throw new RuntimeException("Conecxão não pode ser criada");
			
		}
		 
		return conecxao;
		
	}
	
}
