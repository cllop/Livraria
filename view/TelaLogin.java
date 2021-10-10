package view;

import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;

import config.DevConfig;
import modelo.Caixa;
import modelo.Cliente;
import modelo.Gerente;
import modelo.Usuario;
import modelo.Vendedor;
import repository.FabricaDeFabricaDeRepositorios;
import repository.FabricaDeRepositorios;

public class TelaLogin extends JPanel {

	private GerenciadorPrincipal gerenciador;
	private JPanel telaSelecionada;
	private FabricaDeFabricaDeRepositorios fabricaDeFabricaDeRepositorios;

	public TelaLogin(GerenciadorPrincipal gerenciador, FabricaDeFabricaDeRepositorios fabricaDeFabricaDeRepositorios) {
		if (DevConfig.guiDevMode) {
			this.setBackground(Color.CYAN);
		}
		super.setLayout(null);
		RepositorioDeUsuario repositorio = fabricaDeFabricaDeRepositorios.criarFabricaParaLogin().criarRepositorioDeUsuario();
		this.gerenciador = gerenciador;
		
		this.trocarTela(new DadosDeLogin(this, repositorio));
		this.fabricaDeFabricaDeRepositorios = fabricaDeFabricaDeRepositorios;
	}

	public void realizarLogin(List<Usuario> perfisDeUsuario) {

		if (perfisDeUsuario.size() == 1) {
			this.realizarLogin(perfisDeUsuario.get(0));
		} else {
			JPanel telaDeSelecaoPerfil = new TelaSelecaoPerfil(this, perfisDeUsuario);
			this.trocarTela(telaDeSelecaoPerfil);
		}
	}

	public void realizarLogin(Usuario usuario) {

		if (usuario instanceof Cliente) {
			FabricaDeRepositorios fabricaDeRepositorio = fabricaDeFabricaDeRepositorios.criarFabricaParaCliente();

			this.gerenciador.selecionarFabricaDeRepositorios(fabricaDeRepositorio);
			this.gerenciador.selecionarUsuarioLogado(usuario);
			this.gerenciador.selecionarMenuBarCliente();
			
		}else if(usuario instanceof Gerente) {
			FabricaDeRepositorios fabricaDeRepositorio = fabricaDeFabricaDeRepositorios.criarFabricaParaGerente();
					
			this.gerenciador.selecionarFabricaDeRepositorios(fabricaDeRepositorio);
			this.gerenciador.selecionarUsuarioLogado(usuario);
			this.gerenciador.selecionarMenuBarGerente();
			
		}else if(usuario instanceof Caixa) {
			FabricaDeRepositorios fabricaDeRepositorio = fabricaDeFabricaDeRepositorios.criarFabricaParaCaixa();

			this.gerenciador.selecionarFabricaDeRepositorios(fabricaDeRepositorio);
			this.gerenciador.selecionarUsuarioLogado(usuario);
			this.gerenciador.selecionarMenuBarCaixa();
		}else if(usuario instanceof Vendedor) {
			FabricaDeRepositorios fabricaDeRepositorio = fabricaDeFabricaDeRepositorios.criarFabricaParaVendedor();

			this.gerenciador.selecionarFabricaDeRepositorios(fabricaDeRepositorio);
			this.gerenciador.selecionarUsuarioLogado(usuario);
			this.gerenciador.selecionarMenuBarVendedor();
		}

	}

	public void trocarTela(JPanel telaSelecionada) {
		if (this.telaSelecionada != null) {
			super.remove(this.telaSelecionada);
		}
		super.add(telaSelecionada);
		this.telaSelecionada = telaSelecionada;
		redimensionar();
	}

	public void redimensionar() {
		redimensionar(super.getWidth(), super.getHeight());
	}

	public void redimensionar(int largura, int altura) {
		if (this.telaSelecionada != null) {
			this.telaSelecionada.setBounds(0, 0, largura, altura);
		}
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		redimensionar(width, height);
		super.setBounds(x, y, width, height);
	}

}

