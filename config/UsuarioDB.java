package config;

import java.util.List;

public class UsuarioDB {
	
	private String nome;
	private String host;
	private String senha;
	private List<AtorDB> papeis;

	public UsuarioDB(String nome, String host, String senha, List<AtorDB> papeis) {
		super();
		this.nome = nome;
		this.host = host;
		this.senha = senha;
		this.papeis = papeis;
	}
	
	public String getNome() {
		return nome;
	}

	public String getHost() {
		return host;
	}

	public String getSenha() {
		return senha;
	}

	public List<AtorDB> getPapeis() {
		return papeis;
	}

	@Override
	public String toString() {
		return "UsuarioDB [nome=" + nome + ", host=" + host + ", senha=" + senha + ", papeis=" + papeis + "]";
	}

	

}
