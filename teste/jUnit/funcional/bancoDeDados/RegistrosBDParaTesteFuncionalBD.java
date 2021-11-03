package teste.jUnit.funcional.bancoDeDados;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Caixa;
import modelo.Cliente;
import modelo.Fornecedor;
import modelo.Gerente;
import modelo.ItemDeVenda;
import modelo.Pagamento;
import modelo.PagamentoEmDinheiro;
import modelo.Produto;
import modelo.Setor;
import modelo.Venda;
import modelo.Vendedor;
import teste.jUnit.ConteudoTabelaDB;
import teste.jUnit.MapaRegistro;
import teste.jUnit.RegistrosBD;
import util.Real;

public class RegistrosBDParaTesteFuncionalBD implements RegistrosBD{
	
	public static void main(String[] args) {
		
//	System.out.println(criarRegistrosCiente().gerarComandosDeInsert());
		System.out.println(new RegistrosBDParaTesteFuncionalBD().obterRegistros().gerarTodosOsInserts());


		
	}
	
	public MapaRegistro obterRegistros() {
		
		MapaRegistro mapaRegistro = new MapaRegistro();
		
		mapaRegistro.put(this.criarRegistrosFornecedor());
		mapaRegistro.put(this.criarRegistrosCaixa());
		mapaRegistro.put(this.criarRegistrosGerente());
		mapaRegistro.put(this.criarRegistrosCliente());
		mapaRegistro.put(this.criarRegistrosVendedor());
		mapaRegistro.put(this.criarRegistrosSetor());
		mapaRegistro.put(this.criarRegistrosProduto());
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
		
		setores.add(new Setor(3,"Limpeza de Banheiro", produtosSetor3));
		produtosSetor3.add(new Produto(7, "Sabao BacterMais", "Elimina 99% das bacterias", new Real(200), 34, 3));
		produtosSetor3.add(new Produto(8, "agua sanitaria", "acida", new Real(500), 40, 3));
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
		fornecedores.add(new Fornecedor(1, 21674826000134l, "Cota Best Informacao e Tecnologia", "Cota Best", "Brasil", "Rio de Janeiro", "Rio de Janeiro", "Limoeiro", "Cachoeira", 4647674, (short) 55, (short)62, (short) 23, 7543532));
		fornecedores.add(new Fornecedor(2, 19166074000120l, "Barbarex", "Barbara Rex", "Brasil", "Sao Paulo", "Sao Paulo", "Av. Carlos Rosenfeld", "Nova Odessa", 13380374, (short) 4185, (short) 55, (short) 19, 34668888));
		fornecedores.add(new Fornecedor(3, 15427207000114l, "Ricel Produtos de Limpeza", "Riccel", "Brasil", "Sao Paulo",  "Sao Paulo", "Me. de Deus", "Mooca", 33119000, (short) 3689, (short) 55,(short) 11, 26076363));
		fornecedores.add(new Fornecedor(4, 19672580047641l, "CocaNews", "CocaNW", "Portugal", "Distrito de Lisboa", "Lisboa",  "Limoeiro", "Cachoeira", 44004380, (short) 6387, (short) 55, (short) 23, 934452879));
		return new ConteudoTabelaDB<>(Fornecedor.class,fornecedores);
	}
	
	
	private static ConteudoTabelaDB<Gerente> criarRegistrosGerente(){
		List<Gerente> gerentes = new ArrayList(3);
		
		gerentes.add(new Gerente(1, 18942361422l, "Claudia", "Alvares", "Claudinha", "1234", "Brasil", "Bahia", "Salvador", "Rua Lopes Trovao", "Massaranduba", 40435000, (short)62, (byte)55, (byte)71, 984824479, true, false));
		gerentes.add(new Gerente(2, 19455377833l, "Juliana", "Oliveira", "july", "2090", "Brasil", "Bahia", "Camacari", "Rua Coracao de Maria", "Phoc I", 42800970, (short)281, (byte)55, (byte)71, 915680927, true, false));
		gerentes.add(new Gerente(3, 19455377833l, "Victor", "Araujo", "vitinho", "8990", "Brasil", "Bahia", "Salvavor", "Rua Iracema", "Pituacu", 41740140, (short)43, (byte)55, (byte)71, 909738266, true, false));

		return new ConteudoTabelaDB<>(Gerente.class, gerentes);
	}
	
	
	private static ConteudoTabelaDB<Caixa> criarRegistrosCaixa(){
		List<Caixa> caixas = new ArrayList<>(3);
		List<Gerente> gerentes = criarRegistrosGerente().getRegistros();
		int ultimoIdDeUsuariosJaCadastrados = gerentes.get(gerentes.size()-1).getId();
				
		caixas.add(new Caixa(++ultimoIdDeUsuariosJaCadastrados, 17941361533l, "Lucas", "Silva", "luscax", "123abc","Portugal","Distrito de Lisboa","Lisboa","Rua Lopes Trovao", "Massaranduba", 40435000, (short)798, (byte)55, (byte)71, 919563879, true));
		caixas.add(new Caixa(++ultimoIdDeUsuariosJaCadastrados, 15342341407l, "Stephanie", "Neves", "ster", "123qwr", "Japao","Hokkaido","Sapporo" ,"Rua Lopes Trovao", "Massaranduba", 40435000, (short)109, (byte)55, (byte)71, 942567798, true));
		caixas.add(new Caixa(++ultimoIdDeUsuariosJaCadastrados, 82183837983l, "Fabio Henrique", "Ferreira", "Fabio", "love999","Estados Unidos", "Alasca", "Anchorage", "Rua Beatriz", "Barroso", 60862700, (short)749, (byte)55, (byte)85, 944002892, true));

		return new ConteudoTabelaDB<>(Caixa.class, caixas);
	}
	
	
	private static ConteudoTabelaDB<Cliente> criarRegistrosCliente(){
		List<Cliente> clientes = new ArrayList<>(3);
		List<Caixa> caixas = criarRegistrosCaixa().getRegistros();
		int ultimoIdDeUsuariosJaCadastrados = caixas.get(caixas.size()-1).getId();

		clientes.add(new Cliente(++ultimoIdDeUsuariosJaCadastrados, 1, 40028922554l, "Bleinimir", "Cunha", "Blemir", "lourasbrasil9", "Dojoland", "Carlitchos","Coxs de Farinhas", "Mangueira", "Bairro aleatorio", 47474747, (short)58, (byte)55, (byte)75, 98987744));
		clientes.add(new Cliente(++ultimoIdDeUsuariosJaCadastrados, 2, 98573153332l, "Shinolino", "Soares", "Linoshino", "missbundamole2","Lagland", "IsaiEoLag", "Alto da Perturbaco", "Carvalho", "Periculosidade", 46464646, (short)57, (byte)55, (byte)71, 985859979));
		clientes.add(new Cliente(++ultimoIdDeUsuariosJaCadastrados, 3, 11919554488l, "Sonyscleison", "Fernandes", "sony", "minecraft00","Estados Zunidos", "Matatatu de Brotas", "Eucalipto", "Caca da Onca", "Matador de Javalis", 45454545, (short)56, (byte)1 , (byte)56, 965652287));
		
		return new ConteudoTabelaDB<>(Cliente.class, clientes);
	}
	
	
	private static ConteudoTabelaDB<Vendedor> criarRegistrosVendedor(){
		List<Vendedor> vendedores = new ArrayList<>(3);
		List<Cliente> clientes = criarRegistrosCliente().getRegistros();
		int ultimoIdUsuariosJaCadastrados = clientes.get(clientes.size()-1).getId();
		
		vendedores.add(new Vendedor(++ultimoIdUsuariosJaCadastrados, 7145584521l, "Gabriela", "Veiga", "Gazela", "amazonia78","Venezuela", "Rondonia", "Cacatua", "Nave-Mae", "Help", 55655252, (short)45, (byte)55, (byte)77, 55586858, true));
		vendedores.add(new Vendedor(++ultimoIdUsuariosJaCadastrados, 5641578545l, "Geovanna", "Carvalho", "Geogeo", "madeira222","Vaticano", "Groelandia", "SAnta Maria", "Borboletas Psicodelicas", "Pred. Limpo", 1235896, (short)78, (byte)29, (byte)00, 75562265, true));
		vendedores.add(new Vendedor(++ultimoIdUsuariosJaCadastrados, 4585565145l, "Michele", "Lisboa", "Lesley", "88barackobama","Joanesburgo", "Acre", "Writable", "Undefined", "Source", 236987451, (short)65, (byte)48, (byte)47, 45785415, true));
		
		return new ConteudoTabelaDB<>(Vendedor.class, vendedores);
	}
	
	//vendedor, cliente, caixa
	private static ConteudoTabelaDB<Venda> CriarRegistrosVenda(){
		List<Venda> vendas = new ArrayList<>(3);
		List<Caixa> caixas = criarRegistrosCaixa().getRegistros();
		List<Vendedor> vendedores = criarRegistrosVendedor().getRegistros();
		List<Cliente> clientes = criarRegistrosCliente().getRegistros();
		List<Produto> produtos = criarRegistrosProduto().getRegistros();
		
		//venda 1
		List<ItemDeVenda> itensDeVenda = new ArrayList<>(3);
		itensDeVenda.add(new ItemDeVenda(1, 1, 6, new Real(550), produtos.get(8)));
		itensDeVenda.add(new ItemDeVenda(2, 1, 8, new Real(600), produtos.get(7)));
		itensDeVenda.add(new ItemDeVenda(3, 1, 7, new Real(710), produtos.get(6)));
		
		List<Pagamento> pagamentos = new ArrayList<>();	
		pagamentos.add(new PagamentoEmDinheiro(1, new Real(1810)));
		
		//Date(int year, int month, int date, int hrs, int min, int sec)
		vendas.add(new Venda(1, new Date(2000, 12, 22, 7, 59, 59), vendedores.get(3), clientes.get(3), caixas.get(3), itensDeVenda, pagamentos));
		
		//venda 2
		itensDeVenda = new ArrayList<>(3);
		itensDeVenda.add(new ItemDeVenda(4, 2, 5, new Real(111), produtos.get(5)));
		itensDeVenda.add(new ItemDeVenda(5, 2, 4, new Real(569), produtos.get(4)));
		itensDeVenda.add(new ItemDeVenda(6, 2, 1, new Real(125), produtos.get(3)));
		
		pagamentos = new ArrayList<>();	
		pagamentos.add(new PagamentoEmDinheiro(2, new Real(7894)));
		
		//Date(int year, int month, int date, int hrs, int min, int sec)
		vendas.add(new Venda(2, new Date(1995, 8, 25, 5, 56, 25), vendedores.get(2), clientes.get(2), caixas.get(2), itensDeVenda, pagamentos));
		
 	
	
	//venda 3
	itensDeVenda = new ArrayList<>(3);
	itensDeVenda.add(new ItemDeVenda(7, 3, 4, new Real(550), produtos.get(2)));
	itensDeVenda.add(new ItemDeVenda(8, 3, 6, new Real(600), produtos.get(2)));
	itensDeVenda.add(new ItemDeVenda(9, 3, 7, new Real(710), produtos.get(0)));
	
	pagamentos = new ArrayList<>();	
	pagamentos.add(new PagamentoEmDinheiro(1, new Real(3000)));
	
	//Date(int year, int month, int date, int hrs, int min, int sec)
	vendas.add(new Venda(3, new Date(1452, 12, 24, 15, 59, 59), vendedores.get(3), clientes.get(3), caixas.get(3), itensDeVenda, pagamentos));
	
	return new ConteudoTabelaDB<>(Venda.class, vendas);
	
	}
	//Criar registros de todas as outras tabelas a serem testadas 
	
}
