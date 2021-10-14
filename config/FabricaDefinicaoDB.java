package config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FabricaDefinicaoDB {
	
	public  DefinicaoDB criarDefinicaoDB(){
		
		return 
	}
	
	private List<UsuarioDB> criarUsuarioDB(){
		
		List<UsuarioDB> usuarios = new ArrayList<>();
		
		Map<String, AtorDB> atores = criarAtoresDB();
		
		//Cliente
		List<AtorDB> papeisCliente = new ArrayList<>(2);
		
		papeisCliente.add(atores.get("usuario"));
		papeisCliente.add(atores.get("cliente"));
		
		usuarios.add(new UsuarioDB("cliente", "3reaix", "%", papeisCliente));
		
		//Gerente
		
		List<AtorDB> papeisGerente = new ArrayList<>(3);
		
		papeisGerente.add(atores.get("usuario"));
		papeisGerente.add(atores.get("funcionario"));
		papeisGerente.add(atores.get("gerente"));
		
		//Vendedor
		
		
		
		//Caixa
		
		return
	}
	
	private Map<String, AtorDB> criarAtoresDB(){
		
	}

}
