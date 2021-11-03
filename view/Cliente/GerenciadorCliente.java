package view.Cliente;

import java.awt.Container;

import javax.swing.JPanel;

public class GerenciadorCliente extends JPanel {
	private Container menuSelecionado;

	public GerenciadorCliente() {

	}
	
	private void trocarTela(Container menuSelecionado) {
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

}
