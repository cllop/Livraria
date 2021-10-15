package config;

import java.util.ArrayList;
import java.util.List;

public class AtorDB {
	private List<CasoDeUsoDB> casoDeUsos;
	private String nome;
	
	public AtorDB( String nome) {
		super();
		this.nome = nome;
		this.casoDeUsos = new ArrayList<>();
		
	}

	public List<CasoDeUsoDB> getCasoDeUso() {
		return casoDeUsos;
	}

	public String getNome() {
		return nome;
	}

	public void atribuirCasoDeUso(CasoDeUsoDB casoDeUso) {
		
		this.casoDeUsos.add(casoDeUso);
		
	}

	@Override
	public String toString() {
		return "AtorDB [casoDeUsos=" + casoDeUsos + ", nome=" + nome + "]";
	}
	
	

}
