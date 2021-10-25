package teste.jUnit.funcional.bancoDeDados;

import java.util.ArrayList;
import java.util.List;

import modelo.Fornecedor;
import teste.jUnit.ConteudoTabelaDB;
import teste.jUnit.MapaRegistro;
import teste.jUnit.RegistrosBD;

public class RegistrosBDParaTesteFuncionalBD implements RegistrosBD{
	public static void main(String[] args) {
		ConteudoTabelaDB conteudoFornecedores = criarRegistrosFornecedor();
		System.out.println(conteudoFornecedores.gerarComandosDeInsert());
	}
	
	public MapaRegistro obterRegistros() {
		
		MapaRegistro mapaRegistro = new MapaRegistro();
		
		mapaRegistro.put(this.criarRegistrosFornecedor());
		
		return mapaRegistro;
	}
	
	private static ConteudoTabelaDB <Fornecedor> criarRegistrosFornecedor(){
		List <Fornecedor> fornecedores = new ArrayList(4);
		fornecedores.add(new Fornecedor(1, 21674826000134l, "Cota Best Informação e Tecnologia", "Cota Best", "Brasil", "Rio de Janeiro", "Rio de Janeiro", "Limoeiro", "Cachoeira", 674, (short)55, (short)62, (short) 97634523, 7542));
		//Adicionar os fornecedores desejados
		return new ConteudoTabelaDB<>(Fornecedor.class,fornecedores);
	}
	
	//Criar registros de todas as outras tabelas a serem testadas 
	
}
