package teste.jUnit;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import config.FabricaDeConexao;
import teste.jUnit.funcional.bancoDeDados.RegistrosBDParaTesteFuncionalBD;

public class  GerenciarDB {
	
	private MapaRegistro mapaRegistros;
	private FabricaDeConexao fabricaDeConexaoParaCriacaoDelecao;
	private FabricaDeConexao fabricaParaCadastroDeRegistro;
	private String nomeDoDB;
	
	public GerenciarDB(MapaRegistro mapaDeRegistro, String nomeDoDB) {
		this.mapaRegistros = mapaDeRegistro;
		this.nomeDoDB = nomeDoDB;
		this.fabricaDeConexaoParaCriacaoDelecao = new FabricaDeConexao("jdbc:mysql://localhost:3306/?allowMultiQueries=true", "teste", null);
		this.fabricaParaCadastroDeRegistro = new FabricaDeConexao("jdbc:mysql://localhost:3306/"+nomeDoDB+"?allowMultiQueries=true", "teste", null);
	}

	public void criarDB(){
		try {
			mapaRegistros = new RegistrosBDParaTesteFuncionalBD().obterRegistros();
			StringBuilder sb = new StringBuilder();
			sb.append("Create DataBase ");
			sb.append(nomeDoDB);
			sb.append(" ;");
			Connection con = fabricaDeConexaoParaCriacaoDelecao.criarConecxao();
			Statement st = con.createStatement();
			st.execute(sb.toString());
			con.close();
			st.close();
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void criarTabelas() {
		try {
			StringBuilder sb = new StringBuilder();
			
			Connection con = fabricaParaCadastroDeRegistro.criarConecxao();
			Statement st = con.createStatement();
			st= con.createStatement();
			
			Scanner leitor = new Scanner(new File("DadosTeste/ParaTeste/CodigosParaCriacaoDeTabelas.sql"));
			while(leitor.hasNextLine()) {
				sb.append(leitor.nextLine());
			}
			
			leitor = new Scanner(new File("DadosTeste/ParaTeste/CodigosParaCriacaoDeChavesEstrangeiras.sql"));
			while(leitor.hasNextLine()) {
				sb.append(leitor.nextLine());
			}
			st.execute(sb.toString());
			System.out.println("Tabelas criadas e dados inseridos");
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
	}
	
	public void criarTabelasEInserirDados() {
		
		try {
			StringBuilder sb = new StringBuilder();
			
			Connection con = fabricaParaCadastroDeRegistro.criarConecxao();
			Statement st = con.createStatement();
			st= con.createStatement();
			
			Scanner leitor = new Scanner(new File("DadosTeste/ParaTeste/CodigosParaCriacaoDeTabelas.sql"));
			while(leitor.hasNextLine()) {
				sb.append(leitor.nextLine());
			}
			
			leitor = new Scanner(new File("DadosTeste/ParaTeste/CodigosParaCriacaoDeChavesEstrangeiras.sql"));
			while(leitor.hasNextLine()) {
				sb.append(leitor.nextLine());
			}
			sb.append(mapaRegistros.gerarTodosOsInserts());
			st.execute(sb.toString());
			System.out.println("Tabelas criadas e dados inseridos");
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void destruirDB() {
		Connection   con = fabricaDeConexaoParaCriacaoDelecao.criarConecxao();
		try {
			Statement st = con.createStatement();
			st.execute("DROP DATABASE IF EXISTS "+nomeDoDB+" ;");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

}
