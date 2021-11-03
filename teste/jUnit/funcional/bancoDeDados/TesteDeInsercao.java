package teste.jUnit.funcional.bancoDeDados;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Fornecedor;
import repository.RepositorioFornecedor;

public class TesteDeInsercao {

	private static TesteDeRecuperacao testeDeRecuperacao;
	
	@BeforeAll
	public static void antesDeTudo() {
		TesteDeRecuperacao.gerenciarDB.destruirDB();
		TesteDeRecuperacao.antesDeTudo();
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
	private void addFornecedor() {
		RepositorioFornecedor repositorioDeFornecedor =TesteDeRecuperacao.fabricaDeRepositorios.criarRepositorioFornecedor();
		List<Fornecedor> fornecedores = TesteDeRecuperacao.mapaRegistros.get(Fornecedor.class).getRegistros();
		for(Fornecedor fornecedor : fornecedores) {
			repositorioDeFornecedor.add(fornecedor);
		}
		testeDeRecuperacao.findFornecedor();
	}
	
}
