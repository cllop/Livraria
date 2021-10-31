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

import modelo.Caixa;
import modelo.Cliente;
import modelo.Fornecedor;
import modelo.Gerente;
import modelo.Produto;
import modelo.Setor;
import modelo.Vendedor;
import repository.FabricaDeRepositorios;
import repository.RepositorioCaixa;
import repository.RepositorioCliente;
import repository.RepositorioFornecedor;
import repository.RepositorioGerente;
import repository.RepositorioProduto;
import repository.RepositorioSetor;
import repository.RepositorioVendedor;
import repository.jdbc.RepositorioJDBC;
import teste.jUnit.ConteudoTabelaDB;
import teste.jUnit.MapaRegistro;

public class TesteDeRecuperacao {

	private static FabricaDeRepositorios fabricaDeRepositorios;
	private MapaRegistro mapaRegistros;

	@BeforeAll
	public static void antesDeTudo() {

	}

	@AfterAll
	public static void depoisDeTudo() {

	}

	@BeforeEach

	public void antesDeCada() {

	}

	@AfterEach
	public void depoisDeCada() {

	}

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

		ConteudoTabelaDB<Fornecedor> conteudoDaTabelaFornecedor = mapaRegistros.get((Fornecedor.class));
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
<<<<<<< HEAD
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
			
=======
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
>>>>>>> main
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
