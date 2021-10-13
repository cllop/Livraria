package view.produto;

import java.awt.Color;

import javax.swing.JPanel;

import config.DevConfig;
import modelo.Produto;
import repository.RepositorioProdutoAndLivro;
import repository.jdbc.RepositorioProdutoAndLivroJDBC;

public class GerenciadorProduto extends JPanel {

	private JPanel menuSelecionado;
	private RepositorioProdutoAndLivro repositorioProduto;
	private RepositorioProdutoAndLivroJDBC repositorioLivros;
	
	public GerenciadorProduto(RepositorioProdutoAndLivro repositorio) {
		if (DevConfig.guiDevMode) {
			super.setBackground(new Color(0, 0, 100, 255));
		}
		this.repositorioLivros= repositorioLivros;
		this.repositorioProduto = repositorioProduto;
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
