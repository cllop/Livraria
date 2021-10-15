package config;

import java.util.List;

public class DefinicaoDB {
	
	private List<UsuarioDB> usuarios;
	private String nomeDB;
	
	public DefinicaoDB(List<UsuarioDB> usuarios, String nomeDB) {
		super();
		this.usuarios = usuarios;
		this.nomeDB = nomeDB;
	}
	
	public List<UsuarioDB> getUsuarios() {
		return usuarios;
	}
	
	public String getNomeDB() {
		return nomeDB;
	}
	
	
}
