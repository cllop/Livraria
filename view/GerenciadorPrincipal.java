package view;

import java.awt.Color;

import javax.swing.JPanel;

import config.DevConfig;
import modelo.Usuario;
import repository.FabricaDeRepositorios;
import view.fornecedor.GerenciadorFornecedor;
import view.produto.GerenciadorProduto;

public class GerenciadorPrincipal extends JPanel {

	private static final int larguraDaBarraDeMenu = 300;

	private JPanel menuSelecionado;

	private MenuBarUsuario barraDeMenu;
	
	private TelaLogin telaLogin;
	
	private FabricaDeRepositorios fabricaDeRepositorios;
	
	private Usuario usuarioLogado;
	
	//criar atributo usuario logado

	public GerenciadorPrincipal() {
		setLayout(null);		
		if (DevConfig.guiDevMode) {
			super.setBackground(new Color(100, 50, 50, 255));
		}
		
		//adicionar tela login
	}

	public void trocarTela(JPanel menuSelecionado) {
		if (this.menuSelecionado != null) {
			super.remove(this.menuSelecionado);
		}
		super.add(menuSelecionado);
		this.menuSelecionado = menuSelecionado;
		redimensionar();
	}
	
	public void trocarBarraDeMenu(MenuBarUsuario barraDeMenu) {
		if (this.barraDeMenu != null) {
			super.remove(this.barraDeMenu);
		}
		super.add(barraDeMenu);
		this.barraDeMenu = barraDeMenu;
		redimensionar();
	}
	
	
	public void redimensionar(){
		redimensionar(super.getWidth(), super.getHeight());
	}
	
	public void redimensionar(int largura, int altura) {
		if (this.barraDeMenu!=null) {
			this.barraDeMenu.setBounds(0, 0, larguraDaBarraDeMenu, altura);
		}		
		if (this.menuSelecionado != null) {
			this.menuSelecionado.setBounds(larguraDaBarraDeMenu, 0, largura-larguraDaBarraDeMenu, altura);
		}
		if (this.telaLogin!=null) {
			this.telaLogin.setBounds(0, 0, largura, altura);
		}
	}
	
	
	@Override
	public void setBounds(int x, int y, int width, int height) {
		redimensionar(width, height);// chamar metodo redimensionar dentro do setbounds nas outras classes gerenciador
		super.setBounds(x, y, width, height);// não esquecer de colocar tambem a chamada ao super setbounds
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
		trocarTela(new GerenciadorFornecedor());
	}
	
	public void menuSetor() {
		
	}
	
	
	public void menuCompras() {
		
	}
	
	public void usuarioLogado() {
		
	}
	
	public void realizarLogof() {
		this.barraDeMenu= null;
		this.menuSelecionado= null;
		this.usuarioLogado= null;
		this.fabricaDeRepositorios= null;
		this.telaLogin= new TelaLogin(this);
	}
	//metodo realizar logof no qual ele seta os valores de menu bar, menu selecionado, usuario logado e fabrica de repositorios para null e depois criar uma tela de login
	
	//criar metodos selecionar menu bar um para cada menubar
	
	
	//criar metodo selecionar fabrica de repositorios recebe fabrica de repositorios como parametro e seta o valor do atributo fabrica de repositorios
	
	
	//criar metodo selecionar usuario
}



