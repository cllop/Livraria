package teste.jUnit.funcional.bancoDeDados;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
import repository.jdbc.FabricaDeRepositoriosJDBC;
import repository.jdbc.RepositorioJDBC;
import teste.jUnit.ConteudoTabelaDB;
import teste.jUnit.MapaRegistro;

public class TesteDeRecuperacao {
	
	private static final String nomeDoDB = "testeDB";
	private static FabricaDeConexao fabricaDeConexaoParaCriacaoDelecao;
	private static FabricaDeConexao fabricaParaCadastroDeRegistro=  new FabricaDeConexao("jdbc:mysql://localhost:3306/"+nomeDoDB+"?allowMultiQueries=true", "teste", null);
	private static FabricaDeRepositorios fabricaDeRepositorios;
	private MapaRegistro mapaRegistros;

	@BeforeAll
	public static void antesDeTudo() {
		fabricaDeRepositorios = new FabricaDeRepositoriosJDBC(new FabricaDeConexao("jdbc:mysql://localhost:3306/TesteLivraria","teste", null));
		fabricaDeConexaoParaCriacaoDelecao = new FabricaDeConexao("jdbc:mysql://localhost:3306/?allowMultiQueries=true", "teste", null);
		destruirDB();
		
	}

	@AfterAll
	public static void depoisDeTudo() {
		
	}

	@BeforeEach
	public void antesDeCada() {
		
		try {
			mapaRegistros = new RegistrosBDParaTesteFuncionalBD().obterRegistros();
			StringBuilder sb = new StringBuilder();
			sb.append("Create DataBase ");
			sb.append(nomeDoDB);
			sb.append(" ;");
			Connection con = fabricaDeConexaoParaCriacaoDelecao.criarConecxao();
			Statement st = con.createStatement();
			st.execute(sb.toString());
			con.close();
			st.close();
			con = fabricaParaCadastroDeRegistro.criarConecxao();
			st= con.createStatement();
			
			Scanner leitor = new Scanner(new File("DadosTeste/ParaTeste/CodigosParaCriacaoDeTabelas.sql"));
			while(leitor.hasNextLine()) {
				sb.append(leitor.nextLine());
			}
			
			leitor = new Scanner(new File("DadosTeste/ParaTeste/CodigosParaCriacaoDeChavesEstrangeiras.sql"));
			while(leitor.hasNextLine()) {
				sb.append(leitor.nextLine());
			}
			sb.append(mapaRegistros.gerarTodosOsInserts());
			st.execute(sb.toString());
			System.out.println("Cadastrado com sucesso");
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@AfterEach
	public void depoisDeCada() {
		depoisDeTudo();
	}
	private static void destruirDB() {
		Connection   con = fabricaDeConexaoParaCriacaoDelecao.criarConecxao();
		try {
			Statement st = con.createStatement();
			st.execute("DROP DATABASE IF EXISTS "+nomeDoDB+" ;");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException();
		}
		
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

	private void iniciarConecxaoSePreciso(Object objeto) {

		if (objeto instanceof RepositorioJDBC) {
			((RepositorioJDBC) objeto).criarConexao();
		}
	}

}
