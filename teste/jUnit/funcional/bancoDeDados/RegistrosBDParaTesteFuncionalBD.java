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
	
	
	
	private static ConteudoTabelaDB<Setor> criarRegistrosSetor(){
		
		List<Setor> setores = new ArrayList<>(3);
		List<Produto> produtosSetor1 = new ArrayList<>(3);
		List<Produto> produtosSetor2 = new ArrayList<>(3);
		List<Produto> produtosSetor3 = new ArrayList<>(3);
		
		setores.add(new Setor(1, "Limpeza pessoal", produtosSetor1));
		produtosSetor1.add(new Produto(1, "Sabonete", "Antibacteriano", new Real(300), 10, 1));
		produtosSetor1.add(new Produto(2, "Shampoo", "Anticaspa", new Real(300), 5, 1));
		produtosSetor1.add(new Produto(3, "Esponja", "Macia", new Real(400), 80, 1));
		
		setores.add(new Setor(2, "Lipeza Cozinha", produtosSetor2));
		produtosSetor2.add(new Produto(4, "Detergente", "Solido", new Real(600), 15, 2));
		produtosSetor2.add(new Produto(5, "Limpa aluminio", "Da brilho", new Real(400), 13, 2));
		produtosSetor2.add(new Produto(6, "Rodo de pia", "Pequeno", new Real(800), 30, 2));
		
		setores.add(new Setor(3,"Limpeza de Banheiro", produtosSetor1));
		produtosSetor3.add(new Produto(7, "Sab�o BacterMais", "Elimina 99% das bacterias", new Real(200), 34, 3));
		produtosSetor3.add(new Produto(8, "�gua sanit�ria", "�cida", new Real(500), 40, 3));
		produtosSetor3.add(new Produto(9, "Desinfetante", "Cheiroso", new Real(400), 67, 3));
	
		return new ConteudoTabelaDB<>(Setor.class, setores);
	}
	
	private static ConteudoTabelaDB<Produto> criarRegistrosProduto(){
		List<Produto> listaDeProdutos = new ArrayList<>();
		List<Setor> listaDeSetor = criarRegistrosSetor().getRegistros();
		
		for (Setor setor : listaDeSetor) {
			listaDeProdutos.addAll(setor.getProdutos());
		}
		return new ConteudoTabelaDB<>(Produto.class, listaDeProdutos);
		
	}
	private static ConteudoTabelaDB <Fornecedor> criarRegistrosFornecedor(){
		List <Fornecedor> fornecedores = new ArrayList(4);
		fornecedores.add(new Fornecedor(1, 21674826000134l, "Cota Best Informa��o e Tecnologia", "Cota Best", "Brasil", "Rio de Janeiro", "Rio de Janeiro", "Limoeiro", "Cachoeira", 4647674, (short) 55, (short)62, (short) 23, 7543532));
		fornecedores.add(new Fornecedor(2, 19166074000120l, "Barbarex", "B�rbara Rex", "Brasil", "S�o Paulo", "S�o Paulo", "Av. Carlos Rosenfeld", "Nova Odessa", 13380374, (short) 4185, (short) 55, (short) 19, 34668888));
		fornecedores.add(new Fornecedor(3, 15427207000114l, "Ricel Produtos de Limpeza", "Riccel", "Brasil", "S�o Paulo",  "S�o Paulo", "Me. de Deus", "Mooca", 33119000, (short) 3689, (short) 55,(short) 11, 26076363));
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
		List<Gerente> gerentes = criarRegistrosGerente().getRegistros();
		int ultimoIdDeUsuariosJaCadastrados = gerentes.get(gerentes.size()-1).getId();
		
		
		caixas.add(new Caixa(++ultimoIdDeUsuariosJaCadastrados, 17941361533l, "Lucas", "Silva", "luscax", "Rua Lopes Trovao", "Massaranduba", 40435000, (byte)89, (byte)55, (byte)71, 919563879));
		caixas.add(new Caixa(++ultimoIdDeUsuariosJaCadastrados, 15342341407l, "Stephanie", "Neves", "ster", "Rua Lopes Trovao", "Massaranduba", 40435000, (byte)109, (byte)55, (byte)71, 942567798));
		caixas.add(new Caixa(++ultimoIdDeUsuariosJaCadastrados, 82183837983l, "Fabio Henrique", "Ferreira", "Fabio", "Rua Beatriz", "Barroso", 60862700, (byte)749, (byte)55, (byte)85, 944002892));

		return new ConteudoTabelaDB<>(Caixa.class, caixas);
	}
	
	
	
	public static ConteudoTabelaDB<Cliente> criarRegistrosCiente(){
		List<Cliente> clientes = new ArrayList<>(3);
		List<Caixa> caixas = criarRegistrosCaixa().getRegistros();
		int ultimoIdDeUsuariosJaCadastrados = caixas.get(caixas.size()-1).getId();
		
		clientes.add(new Cliente(++ultimoIdDeUsuariosJaCadastrados, 1, 40028922554l, "Bleinimir", "Cunha", "Blemir", "Dojoland", "Carlitchos", "Coxs de Farinhas", "Mangueira", "Cano PVC", 47474747, (byte)58, (byte)55, (byte)75, 98987744 ));
		clientes.add(new Cliente(++ultimoIdDeUsuariosJaCadastrados, 2, 98573153332l, "Shinolino", "Soares", "Linoshino", "Lagland", "IsaiEoLag", "Alto da Perturba��o", "Carvalho", "Periculosidade", 46464646, (byte)57, (byte)55, (byte)71, 985859979));
		clientes.add(new Cliente(++ultimoIdDeUsuariosJaCadastrados, 3, 11919554488l, "Sonyscleison", "Fernandes", "Brasil", "Estados Zunidos", "Matatatu de Brotas", "Eucalipto", "Ca�a da On�a", "Matador de Javalis", 45454545, (byte)56, (byte)1 , (byte)56, 965652287));
		
		return new ConteudoTabelaDB<>(Cliente.class, clientes);
	}
	
	
	
	//Criar registros de todas as outras tabelas a serem testadas 
	
}
