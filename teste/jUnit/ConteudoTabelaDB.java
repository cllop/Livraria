package teste.jUnit;

import java.util.List;

public class ConteudoTabelaDB <E> {
	private List<E> registros;
	
	public ConteudoTabelaDB(List<E> registros){
		this.registros = registros;
	}
	
	public List<E> getRegistros(){
		return registros;
	}
	
	public String gerarComandosDeInsert() {
		return 
	}
	
	
}
