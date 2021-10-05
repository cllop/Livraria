package view;

import java.awt.Color;

import javax.swing.JPanel;

import config.DevConfig;

public class GerenciadorPrincipal extends JPanel {

	private static final int larguraDaBarraDeMenu = 300;

	private JPanel menuSelecionado;

	private JPanel barraDeMenu;

	public GerenciadorPrincipal() {

		setLayout(null);

		this.barraDeMenu = new MenuBarUsuario(this);
		add(this.barraDeMenu);
		if (DevConfig.devMode) {
			super.setBackground(new Color(100, 50, 50, 255));
		}
		redimencionar();
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
		int altura = super.getHeight();
		int largura = super.getWidth();
		this.barraDeMenu.setBounds(0, 0, larguraDaBarraDeMenu, altura);
		if (this.menuSelecionado != null)
			;
	}
	
	/*
	 * Menus Usuario
	 */
	public void pesquisarProduto() {
		
	}
	public void alterarSenha() {
		
	}
	
	/*
	 * Menus Cliente
	 */
	public void apagarDadosPessoais() {
		
	}
	
	/*
	 * Menus Funcionario
	 */
	
	
	
}
