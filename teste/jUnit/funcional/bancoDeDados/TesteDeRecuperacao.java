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

import modelo.Cliente;
import modelo.Fornecedor;
import modelo.Setor;
import repository.FabricaDeRepositorios;
import repository.RepositorioCliente;
import repository.RepositorioFornecedor;
import repository.RepositorioSetor;
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
		Assertions.assertAll(listaDeAssercoes);
	}

	public void iniciarConecxaoSePreciso(Object objeto) {
		
		if(objeto instanceof RepositorioJDBC) {
			((RepositorioJDBC)objeto).criarConexao();
		}
	}

}
