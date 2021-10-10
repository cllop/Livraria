package repository.jdbc;

import config.FabricaDeConexao;
import repository.FabricaDeRepositorios;
import repository.RepositorioAssinaturaVip;
import repository.RepositorioCaixa;
import repository.RepositorioCliente;
import repository.RepositorioCompra;
import repository.RepositorioDeProduto;
import repository.RepositorioDeUsuario;
import repository.RepositorioFornecedor;
import repository.RepositorioGerente;
import repository.RepositorioLivros;
import repository.RepositorioPagamento;
import repository.RepositorioPlanoVip;
import repository.RepositorioProdutoCategoria;
import repository.RepositorioSetor;
import repository.RepositorioTelefone;
import repository.RepositorioTelefoneFornecedor;
import repository.RepositorioTelefoneUsuario;
import repository.RepositorioVenda;
import repository.RepositorioVendedor;

public class FabricaDeRepositoriosJDBC implements FabricaDeRepositorios {

	private FabricaDeConexao fabricaDeConexao;

	public FabricaDeRepositoriosJDBC(FabricaDeConexao fabricaDeConexao) {
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
