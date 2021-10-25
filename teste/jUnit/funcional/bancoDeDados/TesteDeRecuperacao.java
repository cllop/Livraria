package teste.jUnit.funcional.bancoDeDados;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import config.FabricaDeConexao;
import modelo.Fornecedor;
import repository.jdbc.RepositorioFornecedorJDBC;

public class TesteDeRecuperacao {
	
	private static FabricaDeConexao fabricaDeConexao;
	
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
	
	public void findFornecedor() {
		RepositorioFornecedorJDBC repositorio = new RepositorioFornecedorJDBC(fabricaDeConexao);
		
		Map<Integer, Fornecedor> fornecedores = new HashMap<>();
		
		repositorio.criarConexao();
		for(int i =1; i<5; i++) {
			fornecedores.put(i, repositorio.find(i));
		}
		
		Assertions.assertAll(
					()->{Assertions.assertEquals(1, fornecedores.get(1).getId(), "Id do registro numero 1 está incorreto");},
					()->{Assertions.assertEquals(2, fornecedores.get(2).getId(), "Id do regitro numero 2 está incorreto");},
					()->{Assertions.assertEquals(3, fornecedores.get(3).getId(), "Id do regitro numero 3 está incorreto");},
					()->{Assertions.assertEquals(4, fornecedores.get(4).getId(), "Id do regitro numero 4 está incorreto");},
					()->{Assertions.assertEquals(21674826000134l, fornecedores.get(1).getCnpj(), "CNPJ do regitro numero 1 está incorreto");},
					()->{Assertions.assertEquals(19166074000120l, fornecedores.get(2).getCnpj(), "CNPJ do regitro numero 2 está incorreto");},
					()->{Assertions.assertEquals(15427207000114l, fornecedores.get(3).getCnpj(), "CNPJ do regitro numero 3 está incorreto");},
					()->{Assertions.assertEquals(19672580047641l, fornecedores.get(4).getCnpj(), "CNPJ do regitro numero 4 está incorreto");}
				);
		
	}
	
}
