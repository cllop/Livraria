package view.produto;

import javax.swing.JPanel;

public class GerenciadorProduto extends JPanel {

	private JPanel menuSelecionado;
	/**
	 * Create the panel.
	 */
	public GerenciadorProduto() {

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
		//copiar de gerenciador principal fazendo alteracoes necessarias 
	}
	public void adicionarProduto() {
		this.trocarTela(new AdicionarProduto(this));
	}
	
	public void deletarProduto() {
		this.trocarTela(new DeletarProduto(this));
	}
	public void menuProduto() {
		this.trocarTela(new MenuProduto(this));
	}
}
