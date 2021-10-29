package teste.jUnit.funcional.bancoDeDados;

import java.util.ArrayList;
import java.util.List;

import modelo.Caixa;
import modelo.Cliente;
import modelo.Fornecedor;
import modelo.Gerente;
import modelo.Produto;
import modelo.Setor;
import teste.jUnit.ConteudoTabelaDB;
import teste.jUnit.MapaRegistro;
import teste.jUnit.RegistrosBD;
import util.Real;

public class RegistrosBDParaTesteFuncionalBD implements RegistrosBD{
	
	public static void main(String[] args) {
		
		ConteudoTabelaDB conteudo = criarRegistrosSetor();
		System.out.println(conteudo.gerarComandosDeInsert());
		
		
	}
	
	public MapaRegistro obterRegistros() {
		
		MapaRegistro mapaRegistro = new MapaRegistro();
		
		mapaRegistro.put(this.criarRegistrosFornecedor());
		
		return mapaRegistro;
	}
	
	private static ConteudoTabelaDB <Fornecedor> criarRegistrosFornecedor(){
		List <Fornecedor> fornecedores = new ArrayList(4);
		fornecedores.add(new Fornecedor(1, 21674826000134l, "Cota Best Informação e Tecnologia", "Cota Best", "Brasil", "Rio de Janeiro", "Rio de Janeiro", "Limoeiro", "Cachoeira", 4647674, (short) 55, (short)62, (short) 23, 7543532));
		fornecedores.add(new Fornecedor(2, 19166074000120l, "Barbarex", "Bárbara Rex", "Brasil", "São Paulo", "São Paulo", "Av. Carlos Rosenfeld", "Nova Odessa", 13380374, (short) 4185, (short) 55, (short) 19, 34668888));
		fornecedores.add(new Fornecedor(3, 15427207000114l, "Ricel Produtos de Limpeza", "Riccel", "Brasil", "São Paulo",  "São Paulo", "Me. de Deus", "Mooca", 33119000, (short) 3689, (short) 55,(short) 11, 26076363));
		fornecedores.add(new Fornecedor(4, 19672580047641l, "CocaNews", "CocaNW", "Portugal", "Distrito de Lisboa", "Lisboa",  "Limoeiro", "Cachoeira", 44004380, (short) 6387, (short) 55, (short) 23, 934452879));
		return new ConteudoTabelaDB<>(Fornecedor.class,fornecedores);
	}
	
	private static ConteudoTabelaDB<Gerente> criarRegistrosGerente(){
		List<Gerente> gerentes = new ArrayList(3);
		
		gerentes.add(new Gerente(1, 18942361422l, "Claudia", "Alvares", "Claudinha", "Brasil", "Bahia", "Salvador", "Rua Lopes Trovao", "Massaranduba", 40435000, (byte)62, (byte)55, (byte)71, 984824479, true, false));
		gerentes.add(new Gerente(2, 19455377833l, "Juliana", "Oliveira", "july", "Brasil", "Bahia", "Camacari", "Rua Coracao de Maria", "Phoc I", 42800970, (byte)281, (byte)55, (byte)71, 915680927, true, false));
		gerentes.add(new Gerente(3, 19455377833l, "Victor", "Araujo", "vitinho", "Brasil", "Bahia", "Salvavor", "Rua Iracema", "Pituacu", 41740140, (byte)43, (byte)55, (byte)71, 909738266, true, false));

		return new ConteudoTabelaDB<>(Gerente.class, gerentes);
	}
	
	private static ConteudoTabelaDB<Caixa> criarRegistrosCaixa(){
		List<Caixa> caixas = new ArrayList<>(3);
		
		caixas.add(new Caixa(1, 17941361533l, "Lucas", "Silva", "luscax", "Rua Lopes Trovao", "Massaranduba", 40435000, (byte)89, (byte)55, (byte)71, 919563879));
		caixas.add(new Caixa(2, 15342341407l, "Stephanie", "Neves", "ster", "Rua Lopes Trovao", "Massaranduba", 40435000, (byte)109, (byte)55, (byte)71, 942567798));
		caixas.add(new Caixa(3, 82183837983l, "Fabio Henrique", "Ferreira", "Fabio", "Rua Beatriz", "Barroso", 60862700, (byte)749, (byte)55, (byte)85, 944002892));

		return new ConteudoTabelaDB<>(Caixa.class, caixas);
	}
	
	public static ConteudoTabelaDB<Setor> criarRegistrosSetor(){
		List<Setor> setores = new ArrayList<>(3);
		
		List<Produto> produtosSetor1 = new ArrayList<>();
		
		produtosSetor1.add(new Produto(1, "Sabão BacterMais", "Elimina 99% das bacterias", new Real(200), 34));
		
		setores.add(new Setor(3,"Limpeza de Banheiro", produtosSetor1));
		
		return new ConteudoTabelaDB<>(Setor.class, setores);
	}
	
	public static ConteudoTabelaDB<Cliente> criarRegistrosCliente(){
		List<Cliente> clientes = new ArrayList<>(3);
		
		int numeroDeUsuariosJaCadastrados = criarRegistrosCaixa().getRegistros().size();
		
		clientes.add(new Cliente(++numeroDeUsuariosJaCadastrados, 1, 40028922554l, "Bleinimir", "Cunha", "Blemir", "Dojoland", "Carlitchos", "Coxs de Farinhas", "Mangueira", "Cano PVC", 47474747, (byte)58, (byte)55, (byte)75, 98987744 ));
		clientes.add(new Cliente(++numeroDeUsuariosJaCadastrados, 2, 98573153332l, "Shinolino", "Soares", "Linoshino", "Lagland", "IsaiEoLag", "Alto da Perturbação", "Carvalho", "Periculosidade", 46464646, (byte)57, (byte)55, (byte)71, 985859979));
		clientes.add(new Cliente(++numeroDeUsuariosJaCadastrados, 3, 11919554488l, "Sonyscleison", "Fernandes", "Brasil", "Estados Zunidos", "Matatatu de Brotas", "Eucalipto", "Caça da Onça", "Matador de Javalis", 45454545, (byte)56, (byte)1 , (byte)56, 965652287));
		
		return new ConteudoTabelaDB<>(Cliente.class, clientes);
	}
	
	
	
	//Criar registros de todas as outras tabelas a serem testadas 
	
}
