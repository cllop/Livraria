package repository;

import config.FabricaDeConexao;
import repository.jdbc.RepositorioAssinaturaVipJDBC;
import repository.jdbc.RepositorioCaixaJDBC;
import repository.jdbc.RepositorioClienteJDBC;
import repository.jdbc.RepositorioCompraJDBC;
import repository.jdbc.RepositorioFornecedorJDBC;
import repository.jdbc.RepositorioGerenteJDBC;
import repository.jdbc.RepositorioLivroJDBC;
import repository.jdbc.RepositorioPagamentoJDBC;
import repository.jdbc.RepositorioPlanoVipJDBC;
import repository.jdbc.RepositorioProdutoCategoriaJDBC;
import repository.jdbc.RepositorioProdutoAndLivroJDBC;
import repository.jdbc.RepositorioSetorJDBC;
import repository.jdbc.RepositorioTelefoneFornecedorJDBC;
import repository.jdbc.RepositorioTelefoneJDBC;
import repository.jdbc.RepositorioTelefoneUsuarioJDBC;
import repository.jdbc.RepositorioUsuarioJDBC;
import repository.jdbc.RepositorioVendaJDBC;
import repository.jdbc.RepositorioVendedorJDBC;

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
