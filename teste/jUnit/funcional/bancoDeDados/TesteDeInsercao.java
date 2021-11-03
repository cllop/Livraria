package teste.jUnit.funcional.bancoDeDados;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Caixa;
import modelo.Cliente;
import modelo.Fornecedor;
import modelo.Gerente;
import modelo.Produto;
import modelo.Setor;
import modelo.Vendedor;
import repository.RepositorioCaixa;
import repository.RepositorioCliente;
import repository.RepositorioFornecedor;
import repository.RepositorioGerente;
import repository.RepositorioProduto;
import repository.RepositorioSetor;
import repository.RepositorioVendedor;

public class TesteDeInsercao {

	private static TesteDeRecuperacao testeDeRecuperacao;
	
	@BeforeAll
	public static void antesDeTudo() {
		TesteDeRecuperacao.antesDeTudo();
		TesteDeRecuperacao.gerenciarDB.destruirDB();
		testeDeRecuperacao = new TesteDeRecuperacao();
	}
	@BeforeEach
	public void antesDeCada() {
		
		TesteDeRecuperacao.gerenciarDB.criarDB();
		TesteDeRecuperacao.gerenciarDB.criarTabelas();
	}
	@AfterAll
	public static void depoisDeTudo() {
	
	}
	@AfterEach
	public void depoisDeCada() {
		TesteDeRecuperacao.gerenciarDB.destruirDB();
	}
	
	@Test
	public void addFornecedor() {
		RepositorioFornecedor repositorio =TesteDeRecuperacao.fabricaDeRepositorios.criarRepositorioFornecedor();
		List<Fornecedor> list = TesteDeRecuperacao.mapaRegistros.get(Fornecedor.class).getRegistros();
		for(Fornecedor model : list) {
			repositorio.add(model);
		}
		testeDeRecuperacao.findFornecedor();
	}
	@Test
	public void addCaixa() {
		RepositorioCaixa repositorio =TesteDeRecuperacao.fabricaDeRepositorios.criarRepositorioCaixa();
		List<Caixa> list = TesteDeRecuperacao.mapaRegistros.get(Caixa.class).getRegistros();
		for(Caixa model : list) {
			repositorio.add(model);
		}
		testeDeRecuperacao.findCaixa();
	}
	@Test
	public void addGerente() {
		RepositorioGerente repositorio =TesteDeRecuperacao.fabricaDeRepositorios.criarRepositorioGerente();
		List<Gerente> list = TesteDeRecuperacao.mapaRegistros.get(Gerente.class).getRegistros();
		for(Gerente model : list) {
			repositorio.add(model);
		}
		testeDeRecuperacao.findGerente();
	}
	@Test
	public void addVendedor() {
		RepositorioVendedor repositorio =TesteDeRecuperacao.fabricaDeRepositorios.criarRepositorioVendedor();
		List<Vendedor> list = TesteDeRecuperacao.mapaRegistros.get(Vendedor.class).getRegistros();
		for(Vendedor model : list) {
			repositorio.add(model);
		}
		testeDeRecuperacao.findVendedor();
	}
	@Test
	public void addCliente() {
		RepositorioCliente repositorio =TesteDeRecuperacao.fabricaDeRepositorios.criarRepositorioCliente();
		List<Cliente> list = TesteDeRecuperacao.mapaRegistros.get(Cliente.class).getRegistros();
		for(Cliente model : list) {
			repositorio.add(model);
		}
		testeDeRecuperacao.findCliente();
	}
	@Test
	public void addSetor() {
		RepositorioSetor repositorio =TesteDeRecuperacao.fabricaDeRepositorios.criarRepositorioSetor();
		List<Setor> list = TesteDeRecuperacao.mapaRegistros.get(Setor.class).getRegistros();
		for(Setor model : list) {
			repositorio.add(model);
		}
		testeDeRecuperacao.findSetor();
	}
	@Test
	public void addProduto() {
		RepositorioProduto repositorio =TesteDeRecuperacao.fabricaDeRepositorios.criarRepositorioDeProduto();
		List<Produto> list = TesteDeRecuperacao.mapaRegistros.get(Produto.class).getRegistros();
		for(Produto model : list) {
			repositorio.add(model);
		}
		testeDeRecuperacao.findProduto();
	}
}
