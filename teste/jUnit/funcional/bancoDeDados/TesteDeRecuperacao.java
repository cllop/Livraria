package teste.jUnit.funcional.bancoDeDados;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import config.FabricaDeConexao;
import modelo.Caixa;
import modelo.Cliente;
import modelo.Fornecedor;
import modelo.Gerente;
import modelo.PlanoVip;
import modelo.Produto;
import modelo.Setor;
import modelo.Venda;
import modelo.Vendedor;
import repository.FabricaDeRepositorios;
import repository.RepositorioCaixa;
import repository.RepositorioCliente;
import repository.RepositorioFornecedor;
import repository.RepositorioGerente;
import repository.RepositorioPlanoVip;
import repository.RepositorioProduto;
import repository.RepositorioSetor;
import repository.RepositorioVenda;
import repository.RepositorioVendedor;
import repository.jdbc.FabricaDeRepositoriosJDBC;
import repository.jdbc.RepositorioJDBC;
import teste.jUnit.ConteudoTabelaDB;
import teste.jUnit.GerenciarDB;
import teste.jUnit.MapaRegistro;

public class TesteDeRecuperacao {
	
	public static final String nomeDoDB = "testeDB";
	public static FabricaDeRepositorios fabricaDeRepositorios;
	public static MapaRegistro mapaRegistros;
	public static GerenciarDB gerenciarDB;

	@BeforeAll
	public static void antesDeTudo() {
		fabricaDeRepositorios = new FabricaDeRepositoriosJDBC(new FabricaDeConexao("jdbc:mysql://localhost:3306/"+nomeDoDB,"teste", null));
		mapaRegistros = new RegistrosBDParaTesteRecuperacao().obterRegistros();
		gerenciarDB = new GerenciarDB(mapaRegistros, nomeDoDB);
		gerenciarDB.destruirDB();
	}

	@AfterAll
	public static void depoisDeTudo() {
		
	}

	@BeforeEach
	public void antesDeCada() {
		gerenciarDB.criarDB();
		gerenciarDB.criarTabelasEInserirDados();
	}

	@AfterEach
	public void depoisDeCada() {
		gerenciarDB.destruirDB();
	}
	
	
	
	@Test
	public void findSetor() {
		ConteudoTabelaDB<Setor> conteudoTabelaDB = mapaRegistros.get(Setor.class);
		List<Setor> setoresEsperados = conteudoTabelaDB.getRegistros();
		RepositorioSetor repositorio = fabricaDeRepositorios.criarRepositorioSetor();

		iniciarConecxaoSePreciso(repositorio);

		List<Executable> listaDeAssercoes = new ArrayList<>(setoresEsperados.size());

		for (Setor setorEsperado : setoresEsperados) {

			Setor setorEncontrado = repositorio.find(setorEsperado.getId());
			listaDeAssercoes.add(() -> {
				Assertions.assertEquals(setorEsperado, setorEncontrado, "\nSetor encontrado diferente: \n"
						+ setorEncontrado + " \nDeveria ser: \n" + setorEsperado + '\n');
			});

		}
		Assertions.assertAll(listaDeAssercoes);
	}

	@Test
	public void findCliente() {
		ConteudoTabelaDB<Cliente> conteudoTabelaDB = mapaRegistros.get(Cliente.class);
		List<Cliente> clientesEsperados = conteudoTabelaDB.getRegistros();
		RepositorioCliente repositorio = fabricaDeRepositorios.criarRepositorioCliente();

		iniciarConecxaoSePreciso(repositorio);

		List<Executable> listaDeAssercoes = new ArrayList<>(clientesEsperados.size());

		for (Cliente clienteEsperado : clientesEsperados) {

			Cliente clienteEncontrado = repositorio.find(clienteEsperado.getId());
			listaDeAssercoes.add(() -> {
				Assertions.assertEquals(clienteEsperado, clienteEncontrado, "\nCliente encontrado diferente: \n"
						+ clienteEncontrado + " \nDeveria ser: \n" + clienteEsperado + '\n');
			});

		}
		Assertions.assertAll(listaDeAssercoes);
	}

	@Test
	public void findFornecedor() {

		ConteudoTabelaDB<Fornecedor> conteudoDaTabelaFornecedor = mapaRegistros.get(Fornecedor.class);
		List<Fornecedor> fornecedoresEsperados = conteudoDaTabelaFornecedor.getRegistros();
		RepositorioFornecedor repositorio = fabricaDeRepositorios.criarRepositorioFornecedor();

		iniciarConecxaoSePreciso(repositorio);

		List<Executable> listaDeAssercoes = new ArrayList<>(fornecedoresEsperados.size());

		for (Fornecedor fornecedorEsperado : fornecedoresEsperados) {

			Fornecedor fornecedorEncontrado = repositorio.find(fornecedorEsperado.getId());

			listaDeAssercoes.add(() -> {

				Assertions.assertEquals(fornecedorEsperado, fornecedorEncontrado,
						"\nFornecedor encontrado diferente: \n" + fornecedorEncontrado + " \nDeveria ser: \n"
								+ fornecedorEsperado + '\n');
			});

		}
	}
	
	@Test
	public void findGerente() {
		ConteudoTabelaDB<Gerente> conteudoDaTabelaGerente = mapaRegistros.get(Gerente.class);
		List<Gerente> gerentesEsperados = conteudoDaTabelaGerente.getRegistros();
		RepositorioGerente repositorio = fabricaDeRepositorios.criarRepositorioGerente();
		
		iniciarConecxaoSePreciso(repositorio);
		
		List<Executable> listaDeAssercoes = new ArrayList<>(gerentesEsperados.size());

		for (Gerente gerenteEsperado : gerentesEsperados) {

			Gerente gerenteEncontrado = repositorio.find(gerenteEsperado.getId());

			listaDeAssercoes.add(() -> {

				Assertions.assertEquals(gerenteEsperado, gerenteEncontrado, "\nGerente encontrado diferente: \n"
						+ gerenteEncontrado + " \nDeveria ser: \n" + gerenteEsperado + '\n');
			});
		}
	}

	@Test
	public void findVendedor() {

		ConteudoTabelaDB<Vendedor> conteudoDaTabelaVendedor = mapaRegistros.get(Vendedor.class);
		List<Vendedor> vendedoresEsperados = conteudoDaTabelaVendedor.getRegistros();
		RepositorioVendedor repositorio = fabricaDeRepositorios.criarRepositorioVendedor();

		iniciarConecxaoSePreciso(repositorio);

		List<Executable> listaDeAssercoes = new ArrayList<>(vendedoresEsperados.size());

		for (Vendedor vendedorEsperado : vendedoresEsperados) {

			Vendedor vendedorEncontrado = repositorio.find(vendedorEsperado.getId());

			listaDeAssercoes.add(() -> {

				Assertions.assertEquals(vendedorEsperado, vendedorEncontrado, "\nVendedor encontrado diferente: \n"
						+ vendedorEncontrado + " \nDeveria ser: \n" + vendedorEsperado + '\n');
			});

		}

	}

	@Test
	public void findCaixa() {
		
		ConteudoTabelaDB<Caixa> conteudoDaTabelaCaixa = mapaRegistros.get(Caixa.class);
		List<Caixa> caixasEsperados = conteudoDaTabelaCaixa.getRegistros();
		RepositorioCaixa repositorio = fabricaDeRepositorios.criarRepositorioCaixa();
		
		iniciarConecxaoSePreciso(repositorio);
		
		List<Executable> listaDeAssercoes = new ArrayList<>(caixasEsperados.size());
		
		for (Caixa caixaEsperado : caixasEsperados) {
			
			Caixa caixaEncontrado = repositorio.find(caixaEsperado.getId());
			
			listaDeAssercoes.add(() ->{
				Assertions.assertEquals(caixaEsperado, caixaEncontrado, "\nCaixa encontrado diferente: \n" + caixaEncontrado + "\nDeveria ser: \n" + caixaEsperado + "\n'");
			
			});
		}
		
		Assertions.assertAll(listaDeAssercoes);
	}
	@Test
	public void findProduto() {
		ConteudoTabelaDB<Produto> conteudoDaTabelaProduto = mapaRegistros.get(Produto.class);
		List<Produto> produtosEsperados = conteudoDaTabelaProduto.getRegistros();
		RepositorioProduto repositorio = fabricaDeRepositorios.criarRepositorioDeProduto();

		iniciarConecxaoSePreciso(repositorio);
		List<Executable> listaDeAssercoes = new ArrayList<>(produtosEsperados.size());

		for (Produto produtoEsperado : produtosEsperados) {
			Produto produtoEncontrado = repositorio.find(produtoEsperado.getId());

			listaDeAssercoes.add(new Executable() {
				public void execute() throws Throwable {
					Assertions.assertEquals(produtoEsperado, produtoEncontrado, "\nProduto encontrado diferente: \n"
							+ produtoEncontrado + "\nDeveria ser: \n" + produtoEsperado + "\n");
				}

			});
			
		}
		Assertions.assertAll(listaDeAssercoes);
	}

	@Test
	private void findVenda() {
		ConteudoTabelaDB<Venda> conteudoTabelaVenda = mapaRegistros.get(Venda.class);
		List<Venda> vendasEsperadas = conteudoTabelaVenda.getRegistros();
		RepositorioVenda repositorio = fabricaDeRepositorios.criarRepositorioVenda();
		
		iniciarConecxaoSePreciso(repositorio);
		List<Executable> listaDeAssercoes = new ArrayList<>(vendasEsperadas.size());
		
		for (Venda vendaEsperada : vendasEsperadas) {
			Venda vendaEncontrada = repositorio.find(vendaEsperada.getId());
			
			listaDeAssercoes.add(new Executable() {
				public void execute() throws Throwable {
					Assertions.assertEquals(vendaEsperada, vendaEncontrada, "\nVenda encontrada diferente: \n"
							+ vendaEncontrada + "\nDeveria ser: \n" + vendaEsperada + "\n");
				}
			});
		}
		Assertions.assertAll(listaDeAssercoes);
	}
	
	
	@Test
	private void findPlanoVip() {
		ConteudoTabelaDB<PlanoVip> conteudoTabelaPlanoVip = mapaRegistros.get(PlanoVip.class);
		List<PlanoVip> planosVipEsperados = conteudoTabelaPlanoVip.getRegistros();
		RepositorioPlanoVip repositorio = fabricaDeRepositorios.criarRepositorioPlanoVip();
		
		iniciarConecxaoSePreciso(repositorio);
		List<Executable> listaDeAssercoes = new ArrayList<>(planosVipEsperados.size());
		
		for (PlanoVip planoVipEsperado : planosVipEsperados) {
			PlanoVip planoVipEncontrado = repositorio.find(planoVipEsperado.getId());
			
			listaDeAssercoes.add(new Executable() {
				public void execute() throws Throwable {
					Assertions.assertEquals(planoVipEsperado, planoVipEncontrado, "\nPlanoVip encontrado diferente: \n"
							+ planoVipEncontrado + "\nDeveria ser: \n" + planoVipEsperado + "\n");
				}
			});
		}
		Assertions.assertAll(listaDeAssercoes);
		
	}
	
	private void iniciarConecxaoSePreciso(Object objeto) {

		if (objeto instanceof RepositorioJDBC) {
			((RepositorioJDBC) objeto).criarConexao();
		}
	}

}
