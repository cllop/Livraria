package teste.jUnit;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import config.FabricaDeConexao;
import teste.jUnit.funcional.bancoDeDados.RegistrosBDParaTesteFuncionalBD;

public class  GerenciarDB {
	
	private  MapaRegistro mapaRegistros;
	private static final String nomeDoDB = "testeDB";
	private static FabricaDeConexao fabricaDeConexaoParaCriacaoDelecao;
	private static FabricaDeConexao fabricaParaCadastroDeRegistro=  new FabricaDeConexao("jdbc:mysql://localhost:3306/"+nomeDoDB+"?allowMultiQueries=true", "teste", null);
	
	public static void criarConexao(){
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
			con = fabricaParaCadastroDeRegistro.criarConecxao();
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
			System.out.println("Cadastrado com sucesso");
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private static void destruirDB() {
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
