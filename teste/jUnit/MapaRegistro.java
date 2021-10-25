package teste.jUnit;

import java.util.HashMap;
import java.util.Map;

public class MapaRegistro {
	
	

	private Map <Class, ConteudoTabelaDB> map;
	
	public MapaRegistro() {
		
		map= new HashMap<>();
	}
	
	public void put(ConteudoTabelaDB conteudoTabelaDB) {
		
		map.put(conteudoTabelaDB.getClasseModelo(), conteudoTabelaDB);
	}
	
	public <T> ConteudoTabelaDB <T> get(Class <T> clazz) {
		
		return map.get(clazz);
	}
	
}