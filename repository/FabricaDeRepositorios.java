package repository;

import config.FabricaDeConexao;
import repository.jdbc.RepositorioLivroJDBC;
import repository.jdbc.RepositorioProdutoJDBC;

public class FabricaDeRepositorios {

	private FabricaDeConexao fabricaDeConexao;

	public FabricaDeRepositorios(FabricaDeConexao fabricaDeConexao) {
		super();
		this.fabricaDeConexao = fabricaDeConexao;
	}
	
	public RepositorioLivros criarRepositorioLivro() {
		return new RepositorioLivroJDBC(this.fabricaDeConexao);
	}
	public RepositorioDeProduto criarRepositorioDeProduto() {
		return new RepositorioProdutoJDBC(this.fabricaDeConexao);
	}
	
	//adiconar metodos para criar os outros repositorios
}
