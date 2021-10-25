package teste.jUnit.funcional.bancoDeDados;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Fornecedor;
import teste.jUnit.ConteudoTabelaDB;
import teste.jUnit.RegistrosBD;

public class RegistrosBDParaTesteFuncionalBD implements RegistrosBD{

	
	public <T> Map<Class<T>, ConteudoTabelaDB<T>> obterRegistros() {
		Map <Class<T>, ConteudoTabelaDB<T>> mapaConteudo = new HashMap<>();
		
		mapaConteudo.put(Fornecedor.class, this.criarRegistrosFornecedor());
		
		return null;
	}
	
	private ConteudoTabelaDB <Fornecedor> criarRegistrosFornecedor(){
		List <Fornecedor> fornecedores = new ArrayList(4);
		fornecedores.add(new Fornecedor(1, 21674826000134, "Cota Best Informação e Tecnologia", "Cota Best", "Brasil", "Rio de Janeiro", 'Rio de Janeiro',"Limoeiro", "Cachoeira", 56, 62, 97634523,7542));
		//Adicionar os fornecedores desejados
		return new ConteudoTabelaDB<>(fornecedores);
	}
	
	//Criar registros de todas as outras tabelas a serem testadas 
	
}
