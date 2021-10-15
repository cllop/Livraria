package config;

import java.util.ArrayList;
import java.util.List;

public class CasoDeUsoDB {
	
	private int numero;
	private String nome;
	private List<PermissoesDB> permissoes;
	
	public CasoDeUsoDB(int numero, String nome) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.permissoes = new ArrayList<>();
	}

	public int getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public List<PermissoesDB> getPermissoes() {
		return permissoes;
	}
	
	public void adicionarPermicao(PermissoesDB permissao) {
		this.permissoes.add(permissao);
	}

	@Override
	public String toString() {
		return "CasoDeUsoDB [numero=" + numero + ", nome=" + nome + ", permissoes=" + permissoes + "]";
	}
	
	
	
	
}
