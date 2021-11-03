package view.Cliente;

import java.awt.Container;

import javax.swing.JPanel;

import repository.RepositorioCliente;

public class GerenciadorCliente extends JPanel {
	private Container menuSelecionado;
	private RepositorioCliente repositorioCliente;
	
	public GerenciadorCliente(RepositorioCliente repositorioCliente) {
		setLayout(null);
		this.repositorioCliente = repositorioCliente;
		
		menuCliente();
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
	
	public void setBounds(int x, int y, int width, int height) {
		redimensionar(width, height);
		super.setBounds(x, y, width, height);
	}
	
	public void menuCliente() {
		trocarTela(new MenuCliente(this));
	}
	
	public void cadastrarCliente() {
		trocarTela(new TelaCadastrarCliente(this, this.repositorioCliente));
	}

}
