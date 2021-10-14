package teste.execucaoTelas.produto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import config.ConfiguracoesDeRecursos;
import repository.jdbc.FabricaDeFabricaDeRepositorioJDBC;
import view.GerenciadorPrincipal;
import view.produto.GerenciadorProduto;

public class TelaDeTesteGerenciador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeTesteGerenciador frame = new TelaDeTesteGerenciador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaDeTesteGerenciador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new GerenciadorProduto(new FabricaDeFabricaDeRepositorioJDBC(ConfiguracoesDeRecursos.URL_DB_MYSQL).criarFabricaParaGerente().criarRepositorioDeProduto());
		setContentPane(contentPane);
	}

}
