package view;

import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;

import config.DevConfig;
import config.FabricaDeConexao;
import modelo.Caixa;
import modelo.Cliente;
import modelo.Gerente;
import modelo.Usuario;
import modelo.Vendedor;
import repository.FabricaDeRepositorios;
import repository.RepositorioDeUsuario;
import repository.jdbc.RepositorioUsuarioJDBC;

public class TelaLogin extends JPanel {

	private GerenciadorPrincipal gerenciador;
	private JPanel telaSelecionada;

	public TelaLogin(GerenciadorPrincipal gerenciador) {
		if (DevConfig.guiDevMode) {
			this.setBackground(Color.CYAN);
		}
		super.setLayout(null);
		RepositorioDeUsuario repositorio= new RepositorioUsuarioJDBC(new FabricaDeConexao("jdbc:mysql://localhost:3306/Livraria","Login", "09876Logoff"));
		this.gerenciador = gerenciador;
		
		this.trocarTela(new DadosDeLogin(this, repositorio));

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
			FabricaDeRepositorios fabricaDeRepositorio = new FabricaDeRepositorios(
					new FabricaDeConexao("jdbc:mysql://localhost:3306/Livraria", "Cliente", "3reaix"));

			this.gerenciador.selecionarFabricaDeRepositorios(fabricaDeRepositorio);
			this.gerenciador.selecionarUsuarioLogado(usuario);
			this.gerenciador.selecionarMenuBarCliente();
		}else if(usuario instanceof Gerente) {
			FabricaDeRepositorios fabricaDeRepositorio = new FabricaDeRepositorios(
					new FabricaDeConexao("jdbc:mysql://localhost:3306/Livraria", "Gerente", "38964"));

			this.gerenciador.selecionarFabricaDeRepositorios(fabricaDeRepositorio);
			this.gerenciador.selecionarUsuarioLogado(usuario);
			this.gerenciador.selecionarMenuBarGerente();
		}else if(usuario instanceof Caixa) {
			FabricaDeRepositorios fabricaDeRepositorio = new FabricaDeRepositorios(
					new FabricaDeConexao("jdbc:mysql://localhost:3306/Livraria", "Caixa", "reporepo"));

			this.gerenciador.selecionarFabricaDeRepositorios(fabricaDeRepositorio);
			this.gerenciador.selecionarUsuarioLogado(usuario);
			this.gerenciador.selecionarMenuBarCaixa();
		}else if(usuario instanceof Vendedor) {
			FabricaDeRepositorios fabricaDeRepositorio = new FabricaDeRepositorios(
					new FabricaDeConexao("jdbc:mysql://localhost:3306/Livraria", "Vendedor", "comsono"));

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

