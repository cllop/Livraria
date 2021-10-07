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
import repository.jdbc.RepositorioProdutoJDBC;
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
	
	public RepositorioLivros criarRepositorioLivro() {
		return new RepositorioLivroJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioDeProduto criarRepositorioDeProduto() {
		return new RepositorioProdutoJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioDeUsuario criarRepositorioDeUsuario() {
		return new RepositorioUsuarioJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioFornecedor criarRepositorioFornecedor() {
		return new RepositorioFornecedorJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioCaixa criarRepositorioCaixa() {
		return new RepositorioCaixaJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioCompra criarRepositorioCompra() {
		return new RepositorioCompraJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioCliente criarRepositorioCliente() {
		return new RepositorioClienteJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioGerente criarRepositorioGerente() {
		return new RepositorioGerenteJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioVenda criarRepositorioVenda() {
		return new RepositorioVendaJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioVendedor criarRepositorioVendedor() {
		return new RepositorioVendedorJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioSetor criarRepositorioSetor() {
		return new RepositorioSetorJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioPlanoVip criarRepositorioPlanoVip() {
		return new RepositorioPlanoVipJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioAssinaturaVip criarRepositorioAssinaturaVip() {
		return new RepositorioAssinaturaVipJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioProdutoCategoria criarRepositorioProdutoCategoria() {
		return new RepositorioProdutoCategoriaJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioPagamento criarRepositorioPagamento() {
		return new RepositorioPagamentoJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioTelefone criarRepositorioTelefone() {
		return new RepositorioTelefoneJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioTelefoneUsuario criarRepositorioTelefoneUsuario() {
		return new RepositorioTelefoneUsuarioJDBC(this.fabricaDeConexao);
	}
	
	public RepositorioTelefoneFornecedor criarRepositorioTelefoneFornecedor() {
		return new RepositorioTelefoneFornecedorJDBC(this.fabricaDeConexao);
	}
	
}
