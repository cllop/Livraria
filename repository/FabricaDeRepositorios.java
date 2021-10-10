package repository;

public interface FabricaDeRepositorios {
	
	public RepositorioLivros criarRepositorioLivro();
	public RepositorioDeProduto criarRepositorioDeProduto();
	
	public RepositorioDeUsuario criarRepositorioDeUsuario();
	
	public RepositorioFornecedor criarRepositorioFornecedor();
	
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
