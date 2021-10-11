package view.produto;

import javax.swing.JPanel;

import modelo.Produto;
import repository.RepositorioProdutoAndLivro;
import repository.jdbc.RepositorioProdutoAndLivroJDBC;

public class GerenciadorProduto extends JPanel {

	private JPanel menuSelecionado;
	private RepositorioProdutoAndLivro repositorioProduto;
	private RepositorioProdutoAndLivroJDBC repositorioLivros;
	
	public GerenciadorProduto(RepositorioProdutoAndLivro repositorio, RepositorioProdutoAndLivroJDBC repositorioLivros) {
		this.repositorioProduto= repositorio;
		this.repositorioLivros= repositorioLivros;
		this.repositorioProduto = repositorioProduto;
	}
	public void trocarTela(JPanel menuSelecionado) {
		if (this.menuSelecionado != null) {
			super.remove(this.menuSelecionado);
		}
		super.add(menuSelecionado);
		this.menuSelecionado = menuSelecionado;
		redimencionar();
	}
	public void redimencionar() {
		
	}
	public void adicionarProduto() {
		this.trocarTela(new AdicionarProduto(this, this.repositorioProduto));
		
	}
	
	public void deletarProduto() {
		this.trocarTela(new DeletarProduto(this));
	}
	public void menuProduto() {
		this.trocarTela(new MenuProduto(this));
	}
	public void adicionarLivro(Produto prod) {
		this.trocarTela(new AdicionarLivro(this, this.repositorioLivros, prod));
	}
}
