package teste.jUnit.funcional.bancoDeDados;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
import teste.jUnit.ConteudoTabelaDB;
import teste.jUnit.GerenciarDB;
import teste.jUnit.MapaRegistro;

public class TesteDeInsercao {

	private static TesteDeRecuperacao testeDeRecuperacao;
	private static GerenciarDB gerenciarDB;
	private static MapaRegistro mapaRegistros;
	private static FabricaDeRepositorios fabricaDeRepositorios;
	public static final String nomeDoDB = "testeDB";
	public static FabricaDeConexao  fabricaDeConexao;
	@BeforeAll
	public static void antesDeTudo() {
		fabricaDeConexao = new FabricaDeConexao("jdbc:mysql://localhost:3306/"+nomeDoDB+"?allowMultiQueries=true","teste", null);
		fabricaDeRepositorios = new FabricaDeRepositoriosJDBC(fabricaDeConexao);
		mapaRegistros = new RegistroDBParaTesteInsercao(new RegistrosBDParaTesteRecuperacao()).obterRegistros();
		gerenciarDB = new GerenciarDB(null, nomeDoDB);
		gerenciarDB.destruirDB();
		testeDeRecuperacao = new TesteDeRecuperacao();
		TesteDeRecuperacao.fabricaDeRepositorios = fabricaDeRepositorios;
		TesteDeRecuperacao.mapaRegistros = mapaRegistros;
	}
	@BeforeEach
	public void antesDeCada() {
		gerenciarDB.criarDB();
		gerenciarDB.criarTabelas();
	}
	
	@AfterAll
	public static void depoisDeTudo() {
	
	}
	
	@AfterEach
	public void depoisDeCada() {
		gerenciarDB.destruirDB();
	}
	
	@Test
	public void addFornecedor() {
		RepositorioFornecedor repositorio = fabricaDeRepositorios.criarRepositorioFornecedor();
		List<Fornecedor> list = mapaRegistros.get(Fornecedor.class).getRegistros();
		for(Fornecedor model : list) {
			repositorio.add(model);
		}
		testeDeRecuperacao.findFornecedor();
	}
	
	@Test
	public void addCaixa() {
		RepositorioCaixa repositorio = fabricaDeRepositorios.criarRepositorioCaixa();
		List<Caixa> list = mapaRegistros.get(Caixa.class).getRegistros();
		for(Caixa model : list) {
			repositorio.add(model);
		}
		testeDeRecuperacao.findCaixa();
	}
	
	@Test
	public void addGerente() {
		RepositorioGerente repositorio =fabricaDeRepositorios.criarRepositorioGerente();
		List<Gerente> list = mapaRegistros.get(Gerente.class).getRegistros();
		for(Gerente model : list) {
			repositorio.add(model);
		}
		testeDeRecuperacao.findGerente();
	}
	
	@Test
	public void addVendedor() {
		RepositorioVendedor repositorio =fabricaDeRepositorios.criarRepositorioVendedor();
		List<Vendedor> list = mapaRegistros.get(Vendedor.class).getRegistros();
		for(Vendedor model : list) {
			repositorio.add(model);
		}
		testeDeRecuperacao.findVendedor();
	}
	
	@Test
	public void addCliente() {
		RepositorioCliente repositorio =fabricaDeRepositorios.criarRepositorioCliente();
		List<Cliente> list = mapaRegistros.get(Cliente.class).getRegistros();
		for(Cliente model : list) {
			repositorio.add(model);
		}
		testeDeRecuperacao.findCliente();
	}
	
	@Test
	public void addSetor() {
		try {
			RepositorioSetor repositorio = fabricaDeRepositorios.criarRepositorioSetor();
			List<Setor> list = mapaRegistros.get(Setor.class).getRegistros();
			

			for(Setor model : list) {
				repositorio.add(model);
			}
			ConteudoTabelaDB<Produto> conteudoTabelaProduto = mapaRegistros.get(Produto.class);
			Connection con = fabricaDeConexao.criarConecxao();
			Statement ps = con.createStatement();
			ps.execute(conteudoTabelaProduto.gerarComandosDeInsert());
			testeDeRecuperacao.findSetor();
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
		
	}
	
	@Test
	public void addProduto() {
		try {
			ConteudoTabelaDB<Setor> conteudoTabelaSetor = mapaRegistros.get(Setor.class);
			Connection con = fabricaDeConexao.criarConecxao();
			Statement ps = con.createStatement();
			ps.execute(conteudoTabelaSetor.gerarComandosDeInsert());
			
			RepositorioProduto repositorio = fabricaDeRepositorios.criarRepositorioDeProduto();
			List<Produto> list = mapaRegistros.get(Produto.class).getRegistros();
			for(Produto model : list) {
				repositorio.add(model);
			}
			testeDeRecuperacao.findProduto();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
