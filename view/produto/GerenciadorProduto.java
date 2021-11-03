package view.produto;

import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;

import config.DevConfig;
import modelo.Produto;
import repository.RepositorioProduto;

public class GerenciadorProduto extends JPanel {

	private JPanel menuSelecionado;
	private RepositorioProduto repositorio;

	public GerenciadorProduto(RepositorioProduto repositorio, Produto produto) {
		if (DevConfig.guiDevMode) {
			super.setBackground(new Color(0, 0, 100, 255));
		}
		super.setLayout(null);
		this.repositorio = repositorio;

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
		this.trocarTela(new AdicionarProduto(this, this.repositorio));

	}

	public void deletarProduto() {
		this.trocarTela(new DadosPesquisaParaDeletarProduto(this, repositorio));
	}

	public void deletarProduto(Produto produto) {
		this.trocarTela(new DeletarProduto(this, repositorio, produto));
	}
	
	public void menuProduto() {
		this.trocarTela(new MenuProduto(this));
	}
	
	public void exibirProduto(Produto produto) {
		this.trocarTela(new ExibirProduto(this, produto));
	}

	public void exibirProdutos(List<Produto> produto) {

	}
	
	public void editarProdutos(Produto produto) {
		this.trocarTela(new EditarProduto(this, repositorio, produto));
	}
	
	public void editarProdutos() {
		this.trocarTela(new PesquisarEditarProduto(this, repositorio));
	}
	
	public void pesquisarProduto() {
		this.trocarTela(new PesquisarProduto(this, repositorio));
	}

}
