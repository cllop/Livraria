package teste.jUnit.funcional.bancoDeDados;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import modelo.Caixa;
import modelo.Cliente;
import modelo.Gerente;
import modelo.Usuario;
import modelo.Vendedor;
import teste.jUnit.MapaRegistro;
import teste.jUnit.RegistrosBD;

public class RegistroDBParaTesteInsercao implements RegistrosBD{
	private RegistrosBD registroBD;
	
	
	
	public RegistroDBParaTesteInsercao(RegistrosBD registroBD) {
		this.registroBD = registroBD;
	}



	public MapaRegistro obterRegistros() {
		try {
			MapaRegistro mapa = registroBD.obterRegistros();
			Field atributoId = Usuario.class.getDeclaredField("id");
			atributoId.setAccessible(true);
			List<List> listaDeListaUsuarios = new ArrayList<>(3);
			
			listaDeListaUsuarios.add(mapa.get(Cliente.class).getRegistros());
			listaDeListaUsuarios.add(mapa.get(Gerente.class).getRegistros());
			listaDeListaUsuarios.add(mapa.get(Caixa.class).getRegistros());
			listaDeListaUsuarios.add(mapa.get(Vendedor.class).getRegistros());
			
			for(List listaDeUsuario: listaDeListaUsuarios) {
				for(int i=0; i<listaDeUsuario.size(); i++) {
					atributoId.setInt(listaDeUsuario.get(i), i+1);
				}
			}
			
			return mapa;
					
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}
