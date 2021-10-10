package view;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import config.ConfiguracoesDeRecursos;
import repository.FabricaDeFabricaDeRepositorios;
import repository.FabricaDeRepositorios;
import repository.jdbc.FabricaDeFabricaDeRepositorioJDBC;

public class JanelaPricipal extends JFrame {

	private GerenciadorPrincipal contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPricipal frame = new JanelaPricipal(criarFabricaDeFabricaDeRepositorios());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static FabricaDeFabricaDeRepositorios criarFabricaDeFabricaDeRepositorios () {
		return new FabricaDeFabricaDeRepositorioJDBC(ConfiguracoesDeRecursos.URL_DB_MYSQL);
	}
	
	public JanelaPricipal(FabricaDeFabricaDeRepositorios fabricaDeFabricaDeRepositorios) {
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.contentPane = new GerenciadorPrincipal(fabricaDeFabricaDeRepositorios);
		super.setContentPane(contentPane);
		super.setExtendedState(JFrame.MAXIMIZED_BOTH);
		super.setVisible(true);
	}
	
	

}
