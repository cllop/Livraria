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
			 
		} catch (SQLException execao) {
			if(DevConfig.devMode) {
				System.out.println("----------------------------------------------------------------");
				execao.printStackTrace();
				System.out.println("----------------------------------------------------------------");
			}
			throw new RuntimeException("Conecxão não pode ser criada",execao);
			
		}
		 
		return conecxao;
		
	}
	
}
