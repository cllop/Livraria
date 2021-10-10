package repository;

import config.FabricaDeConexao;
import repository.jdbc.RepositorioProdutoAndLivroJDBC;
import repository.jdbc.RepositorioUsuarioJDBC;

public class FabricaDeRepositorios {

	private FabricaDeConexao fabricaDeConexao;

	public FabricaDeRepositorios(FabricaDeConexao fabricaDeConexao) {
		super();
		this.fabricaDeConexao = fabricaDeConexao;
	}
	
	public RepositorioLivro criarRepositorioLivro() {
		return new RepositorioLivroJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioProdutoAndLivro criarRepositorioDeProduto() {
		return new RepositorioProdutoAndLivroJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioUsuario criarRepositorioDeUsuario() {
		return new RepositorioUsuarioJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioCaixa criarRepositorioCaixa();
	
	public RepositorioCompra criarRepositorioCompra();
	
	public RepositorioCliente criarRepositorioCliente();
	
	public RepositorioGerente criarRepositorioGerente();
	
	public RepositorioVenda criarRepositorioVenda();
	
	public RepositorioVendedor criarRepositorioVendedor();
	
	public RepositorioSetor criarRepositorioSetor();
	
	public RepositorioPlanoVip criarRepositorioPlanoVip();
	
	public RepositorioAssinaturaVip criarRepositorioAssinaturaVip();
	
	public RepositorioProdutoCategoria criarRepositorioProdutoCategoria();
	
	public RepositorioPagamento criarRepositorioPagamento();
	
	public RepositorioTelefone criarRepositorioTelefone();
	
	public RepositorioTelefoneUsuario criarRepositorioTelefoneUsuario();
	
	public RepositorioTelefoneFornecedor criarRepositorioTelefoneFornecedor();
	

}
