package config;

public class PermissoesDB {
	
	String permicoes;
	String tabela;
	
	public PermissoesDB(String permicoes, String tabela) {
		super();
		this.permicoes = permicoes;
		this.tabela = tabela;
	}

	public String getComandos() {
		return permicoes;
	}

	public String getTabela() {
		return tabela;
	}

	@Override
	public String toString() {
		return "PermissoesDB [permicoes=" + permicoes + ", tabela=" + tabela + "]";
	}
	
	
}
