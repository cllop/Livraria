package config;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.ConnectionEventListener;

public class ConfigurarBancoDeDados {
	private static FabricaDeConexao fabricaDeConexao;
	private static DefinicaoDB definicaoDB;

	public static void main(String[] args) {
		fabricaDeConexao = new FabricaDeConexao(ConfiguracoesDeRecursos.URL_DB_MYSQL, "root", null);
		definicaoDB = new FabricaDefinicaoDB().criarDefinicaoDB();
		// fazer menu com 3 opcoes: cadastrar usuarios, conceder permissoes e deletar
		// usuarios

		cadastrarUsuarios();
	}

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
				comandos.execute("CREATE USER usuario3 @'%'; CREATE USER usuario2 @'%';");

			}

		} catch (Exception e) {
			System.out.println("Não foi possivel cadastrar usuario");
			e.printStackTrace();
		}

	}

	private static void concederPermissoes() {
		StringBuilder construtorDeString = new StringBuilder();

	}

	private static void deletarUsuarios() {
		StringBuilder construtorDeString = new StringBuilder();

		for (UsuarioDB usuario : definicaoDB.getUsuarios()) {
			construtorDeString.append("DROP");
			construtorDeString.append(" USER ");
			construtorDeString.append(usuario.getNome());
			construtorDeString.append(";");
		}
		System.out.println(construtorDeString.toString());
	}
}
