package config;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;



public class ConfigurarBancoDeDados {
	private static FabricaDeConexao fabricaDeConexao;
	private static DefinicaoDB definicaoDB;

//	public static void main(String[] args) {
//		fabricaDeConexao = new FabricaDeConexao(ConfiguracoesDeRecursos.URL_DB_MYSQL, "root", null);
//		definicaoDB = new FabricaDefinicaoDB().criarDefinicaoDB();
//		// fazer menu com 3 opcoes: cadastrar usuarios, conceder permissoes e deletar
//		
//
//		System.out.println("Digite o menu desejado");
//		System.out.println("a-Cadastrar Usuario");
//		System.out.println("b-Conceder Permissoes");
//		System.out.println("c-Deletar Usuarios");
//		Scanner sc = new Scanner(System.in);
//				
//		char opcao= sc.nextLine().charAt(0);
//		
//		switch (opcao) {
//		
//		case 'a': 
//			cadastrarUsuarios();
//			break;
//		case 'b':
//			concederPermissoes();
//			break;
//		case 'c':
//			deletarUsuarios();
//			break;
//		default:
//			
//			throw new IllegalArgumentException("Ta errado");
//		}
//		
//	}

	private static void cadastrarUsuarios() {
		try {

			StringBuilder construtorDeString = null;
			Connection conexao = fabricaDeConexao.criarConecxao();

			conexao.setAutoCommit(false);

			for (UsuarioDB usuario : definicaoDB.getUsuarios()) {

				construtorDeString = new StringBuilder();

				construtorDeString.append("CREATE USER ");
				construtorDeString.append(usuario.getNome());
				construtorDeString.append(" @");
				construtorDeString.append('\'');
				construtorDeString.append(usuario.getHost());
				construtorDeString.append('\'');
				construtorDeString.append(" IDENTIFIED BY ");
				construtorDeString.append('\'');
				construtorDeString.append(usuario.getSenha());
				construtorDeString.append('\'');
				construtorDeString.append(";");

				Statement comandos = fabricaDeConexao.criarConecxao().createStatement();
				comandos.execute(construtorDeString.toString());

			}

			conexao.commit();
			System.out.println("Cadastrado com sucesso!!");

		} catch (Exception e) {
			System.out.println("Não foi possivel cadastrar usuario");
			e.printStackTrace();
		}

	}

	private static void concederPermissoes() {
		try {
			StringBuilder construtorDeString = null;
			Connection conexao = fabricaDeConexao.criarConecxao();

			conexao.setAutoCommit(false);

			for (UsuarioDB usuario : definicaoDB.getUsuarios()) {
//				System.out.println("Usuario nome ="+ usuario.getNome());
				
				for (AtorDB papel : usuario.getPapeis()) {
//					System.out.println("AtorDB nome="+papel.getNome());
					
					for (CasoDeUsoDB casoDeUsos : papel.getCasoDeUso()) {
//						System.out.println("Caso de uso ="+ casoDeUsos.getNome());
						
						for (PermissoesDB permissao : casoDeUsos.getPermissoes()) {
							construtorDeString = new StringBuilder();
							construtorDeString.append("GRANT ");
							construtorDeString.append(permissao.getComandos());
							construtorDeString.append(" ON ");
							construtorDeString.append(definicaoDB.getNomeDB());
							construtorDeString.append('.');
							construtorDeString.append(permissao.getTabela());
							construtorDeString.append(" TO ");
							construtorDeString.append(usuario.getNome());
							construtorDeString.append(" @");
							construtorDeString.append('\'');
							construtorDeString.append(usuario.getHost());
							construtorDeString.append('\'');
							construtorDeString.append(';');
//							System.out.println("SQL ="+construtorDeString.toString());
							Statement comandos = fabricaDeConexao.criarConecxao().createStatement();
							comandos.execute(construtorDeString.toString());
						}
					}
				}
			}
			
			conexao.commit();

			System.out.println("Permissões concedidas com sucesso!");

		} catch (Exception e) {
			
			System.out.println("Nao foi possivel conceder permissoes");
			e.printStackTrace();
		}

	}

	private static void deletarUsuarios() {

		try {
			StringBuilder construtorDeString = null;

			Connection conexao = fabricaDeConexao.criarConecxao();

			conexao.setAutoCommit(false);

			for (UsuarioDB usuario : definicaoDB.getUsuarios()) {

				construtorDeString = new StringBuilder();

				construtorDeString.append("DROP");
				construtorDeString.append(" USER ");
				construtorDeString.append(usuario.getNome());
				construtorDeString.append(";");

				Statement comandos = fabricaDeConexao.criarConecxao().createStatement();
				comandos.execute(construtorDeString.toString());
			}

			conexao.commit();

			System.out.println("Deletado com sucesso!!");

		} catch (Exception e) {

			System.out.println("Não foi possivel deletar usuario");
			e.printStackTrace();
		}

	}
}
