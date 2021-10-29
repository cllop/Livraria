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
		fornecedores.add(new Fornecedor(1, 21674826000134l, "Cota Best Informação e Tecnologia", "Cota Best", "Brasil", "Rio de Janeiro", "Rio de Janeiro", "Limoeiro", "Cachoeira", 674, (short) 55, (short)62, (short) 97634523, 7542));
		fornecedores.add(new Fornecedor(2, 19166074000120l, "Barbarex", "Bárbara Rex", "Brasil", "São Paulo", "São Paulo", "Av. Carlos Rosenfeld", "Nova Odessa", 13380374, (short) 185, (short) 55, (short) 19, 34668888));
		fornecedores.add(new Fornecedor(3, 15427207000114l, "Ricel Produtos de Limpeza", "Riccel", "Brasil", "São Paulo",  "São Paulo", "Me. de Deus", "Mooca", 33119000, (short) 689, (short) 55,(short) 11, 26076363));
		fornecedores.add(new Fornecedor(4, 19672580047641l, "CocaNews", "CocaNW", "Espanha", "Bahia", "Salvador",  "Limoeiro", "Cachoeira", 44004380, (short) 87, (short) 56, (short) 23, 934452879));
		return new ConteudoTabelaDB<>(Fornecedor.class,fornecedores);
	}
	
	//Criar registros de todas as outras tabelas a serem testadas 
	
}
