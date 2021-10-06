package view.produto;

import javax.swing.JPanel;

import repository.RepositorioDeProduto;
import repository.RepositorioLivros;

public class GerenciadorProduto extends JPanel {

	private JPanel menuSelecionado;
	private RepositorioDeProduto repositorioProduto;
	private RepositorioLivros repositorioLivros;
	
	public GerenciadorProduto(RepositorioDeProduto repositorio, RepositorioLivros repositorioLivros) {

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
		this.trocarTela(new AdicionarProduto(this, this.RepositorioDeProduto));
		
	}
	
	public void deletarProduto() {
		this.trocarTela(new DeletarProduto(this));
	}
	public void menuProduto() {
		this.trocarTela(new MenuProduto(this));
	}
}
