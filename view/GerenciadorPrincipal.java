package view;

import java.awt.Color;

import javax.swing.JPanel;

import config.DevConfig;
import modelo.Produto;
import modelo.Usuario;
import repository.FabricaDeFabricaDeRepositorios;
import repository.FabricaDeRepositorios;
import repository.RepositorioProdutoAndLivro;
import view.fornecedor.GerenciadorFornecedor;
import view.produto.ExibirProduto;
import view.produto.GerenciadorProduto;

public class GerenciadorPrincipal extends JPanel {

	private static final int larguraDaBarraDeMenu = 300;

	private JPanel menuSelecionado;

	private MenuBarUsuario barraDeMenu;

	private TelaLogin telaLogin;

	private Usuario usuarioLogado;

	private FabricaDeRepositorios fabricaDeRepositorios;

	private FabricaDeFabricaDeRepositorios fabricaDeFabricaDeRepositorios;
	
	private RepositorioProdutoAndLivro repositorio;

	public GerenciadorPrincipal(FabricaDeFabricaDeRepositorios fabricaDeFabricaDeRepositorio) {
		setLayout(null);
		if (DevConfig.guiDevMode) {
			super.setBackground(new Color(100, 50, 50, 255));
		}

		this.fabricaDeFabricaDeRepositorios = fabricaDeFabricaDeRepositorio;
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

	public void redimensionar() {
		redimensionar(super.getWidth(), super.getHeight());
	}

	public void redimensionar(int largura, int altura) {
		if (this.barraDeMenu != null) {
			this.barraDeMenu.setBounds(0, 0, larguraDaBarraDeMenu, altura);
		}
		if (this.menuSelecionado != null) {
			this.menuSelecionado.setBounds(larguraDaBarraDeMenu, 0, largura - larguraDaBarraDeMenu, altura);
		}
		if (this.telaLogin != null) {
			this.telaLogin.setBounds(0, 0, largura, altura);
		}
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		redimensionar(width, height);// chamar metodo redimensionar dentro do setbounds nas outras classes
										// gerenciador
		super.setBounds(x, y, width, height);// n�o esquecer de colocar tambem a chamada ao super setbounds
	}

	/*
	 * Menus Usuario
	 */
	public void pesquisarProduto(Produto produto) {
		

	}

	public void alterarSenha() {

	}

	public void apagarDadosPessoais() {

	}

	public void menuFuncionario() {

	}

	public void menuProduto() {
		trocarTela(new GerenciadorProduto(this.fabricaDeRepositorios.criarRepositorioDeProduto()));
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
		if (barraDeMenu != null) {
			super.remove(barraDeMenu);
		}
		if (menuSelecionado != null) {
			super.remove(menuSelecionado);
		}
		this.barraDeMenu = null;
		this.menuSelecionado = null;
		this.usuarioLogado = null;
		this.fabricaDeRepositorios = null;
		this.telaLogin = new TelaLogin(this, fabricaDeFabricaDeRepositorios);
		this.add(this.telaLogin);
		
		this.redimensionar();
	}

	public void pesquisarPlanoVip() {

	}

	public void cadastrarPlanoVip() {

	}

	// metodo realizar logof no qual ele seta os valores de menu bar, menu
	// selecionado, usuario logado e fabrica de repositorios para null e depois
	// criar uma tela de login

	public void selecionarMenuBarCliente() {
		if (telaLogin != null) {
			super.remove(telaLogin);
		}
		trocarBarraDeMenu(new MenuBarCliente(this));
		super.repaint();
	}

	public void selecionarMenuBarCaixa() {
		if (telaLogin != null) {
			super.remove(telaLogin);
		}
		trocarBarraDeMenu(new MenuBarCaixa(this));
		super.repaint();
	}

	public void selecionarMenuBarGerente() {
		if (telaLogin != null) {
			super.remove(telaLogin);
		}
		trocarBarraDeMenu(new MenuBarGerente(this));
		super.repaint();
	}

	public void selecionarMenuBarVendedor() {
		if (telaLogin != null) {
			super.remove(telaLogin);
			super.repaint();
		}
		trocarBarraDeMenu(new MenuBarVendedor(this));
		super.repaint();
	}
	
	

	public void selecionarFabricaDeRepositorios(FabricaDeRepositorios fabricaDeRepositorios) {
		this.fabricaDeRepositorios = fabricaDeRepositorios;
	}

	public void selecionarUsuarioLogado(Usuario usuario) {
		this.usuarioLogado = usuario;

	}
}
