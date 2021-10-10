package view;

import java.awt.Color;

import javax.swing.JPanel;

import config.DevConfig;
import modelo.Usuario;
import repository.FabricaDeFabricaDeRepositorios;
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
	
	private FabricaDeFabricaDeRepositorios fabricaDeFabricaDeRepositorios;
	

	public GerenciadorPrincipal(FabricaDeFabricaDeRepositorios fabricaDeFabricaDeRepositorios) {
		setLayout(null);		
		if (DevConfig.guiDevMode) {
			super.setBackground(new Color(100, 50, 50, 255));
		}
		
		this.realizarLogoff();
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
		super.setBounds(x, y, width, height);// n�o esquecer de colocar tambem a chamada ao super setbounds
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
		trocarTela(new GerenciadorProduto(this.fabricaDeRepositorios.criarRepositorioDeProduto(), this.fabricaDeRepositorios.criarRepositorioLivro()));
	}
	
	public void menuFornecedor() {
		trocarTela(new GerenciadorFornecedor(this.fabricaDeRepositorios.criarRepositorioFornecedor()));
	}
	
	public void menuSetor() {
		
	}
	
	
	public void menuCompras() {
		
	}
	
	public void usuarioLogado() {
		
	}
	
	public void realizarLogoff() {
		this.barraDeMenu= null;
		this.menuSelecionado= null;
		this.usuarioLogado= null;
		this.fabricaDeRepositorios= null;
		this.telaLogin= new TelaLogin(this, fabricaDeFabricaDeRepositorios);
		this.add(this.telaLogin);
	}
	public void pesquisarPlanoVip() {
		
	}
	
	public void cadastrarPlanoVip() {
		
	}
	
	
	
	//metodo realizar logof no qual ele seta os valores de menu bar, menu selecionado, usuario logado e fabrica de repositorios para null e depois criar uma tela de login
	
	public void selecionarMenuBarCliente() {
		trocarBarraDeMenu(new MenuBarCliente(this));	
	}
	
	public void selecionarMenuBarCaixa() {
		trocarBarraDeMenu(new MenuBarCaixa(this));	
	}
	
	public void selecionarMenuBarGerente() {
		trocarBarraDeMenu(new MenuBarGerente(this));	
	}
	
	public void selecionarMenuBarVendedor() {
		trocarBarraDeMenu(new MenuBarVendedor(this));	
	}

	public void selecionarFabricaDeRepositorios(FabricaDeRepositorios fabricaDeRepositorios) {
		this.fabricaDeRepositorios = fabricaDeRepositorios;
	}
	
	public void selecionarUsuarioLogado(Usuario usuario) {
		this.usuarioLogado = usuario;
		
	}
}



