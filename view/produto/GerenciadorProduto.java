package view.produto;

import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;

import config.DevConfig;
import modelo.Produto;
import repository.RepositorioProdutoAndLivro;
import repository.jdbc.RepositorioProdutoAndLivroJDBC;

public class GerenciadorProduto extends JPanel {

	private JPanel menuSelecionado;
	private RepositorioProdutoAndLivro repositorioProdutoAndLivro;

	public GerenciadorProduto(RepositorioProdutoAndLivro repositorio) {
		if (DevConfig.guiDevMode) {
			super.setBackground(new Color(0, 0, 100, 255));
		}
		super.setLayout(null);
		this.repositorioProdutoAndLivro = repositorio;

		this.menuProduto();
	}

	public void trocarTela(JPanel menuSelecionado) {
		if (this.menuSelecionado != null) {
			super.remove(this.menuSelecionado);
		}
		super.add(menuSelecionado);
		this.menuSelecionado = menuSelecionado;
		redimensionar();
	}

	public void redimensionar() {
		redimensionar(super.getWidth(), super.getHeight());
	}

	public void redimensionar(int largura, int altura) {
		if (this.menuSelecionado != null) {
			this.menuSelecionado.setBounds(0, 0, largura, altura);
		}
	}

	public void setBounds(int x, int y, int width, int height) {
		redimensionar(width, height);
		super.setBounds(x, y, width, height);
	}

	public void adicionarProduto() {
		this.trocarTela(new AdicionarProduto(this, this.repositorioProdutoAndLivro));

	}

	public void deletarProduto() {
		this.trocarTela(new PesquisarDeletarProduto(this, this.repositorioProdutoAndLivro));
	}

	public void menuProduto() {
		this.trocarTela(new MenuProduto(this));
	}

	public void adicionarLivro(Produto prod) {
		this.trocarTela(new AdicionarLivro(this, this.repositorioProdutoAndLivro, prod));
	}

	public void exibirprodutos(List<Produto> produto) {

	}
	
	public void editarProdutos() {
		this.trocarTela(new EditarProduto());
	}

}
