package config;

public class PermissoesDB {
	
	String permicoes;
	String tabela;
	
	public PermissoesDB(String permicoes, String tabela) {
		super();
		this.permicoes = permicoes;
		this.tabela = tabela;
	}

	public String getPermicoes() {
		return permicoes;
	}

	public String getTabela() {
		return tabela;
	}
	
}
