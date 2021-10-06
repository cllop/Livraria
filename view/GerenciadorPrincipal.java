package view;

import java.awt.Color;

import javax.swing.JPanel;

import config.DevConfig;
import repository.FabricaDeRepositorios;
import view.produto.GerenciadorProduto;

public class GerenciadorPrincipal extends JPanel {

	private static final int larguraDaBarraDeMenu = 300;

	private JPanel menuSelecionado;

	private JPanel barraDeMenu;
	
	private FabricaDeRepositorios fabricaDeRepositorios;

	public GerenciadorPrincipal() {
		setLayout(null);

		MenuBarUsuario menuBarUsuario;
		menuBarUsuario = new MenuBarGerente(this);
		
		this.barraDeMenu = menuBarUsuario;
		barraDeMenu.setSize(270, 760);
		barraDeMenu.setLocation(0, 0);
		add(this.barraDeMenu);
		if (DevConfig.devMode) {
			super.setBackground(new Color(100, 50, 50, 255));
			redimencionar();
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
		if (this.menuSelecionado != null) {
			
		}
	}
	
	/*
	 * Menus Usuario
	 */
	public void pesquisarProduto() {
		
		
	}
	public void alterarSenha() {
		
	}
	
	
	public void apagarDadosPessoais() {
		
	}

	public void menuFuncionario() {
		
	}
	
	public void menuProduto() {
		trocarTela(new GerenciadorProduto( this.fabricaDeRepositorios.criarRepositorioDeProduto(), this.fabricaDeRepositorios.criarRepositorioLivro()));
	}
	
	public void menuFornecedor() {
		
	}
	
	public void menuSetor() {
		
	}
	
	
	public void menuCompras() {
		
	}
}



