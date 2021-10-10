package testeExecucaoDeTelasLogin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import repository.FabricaDeRepositorios;
import view.GerenciadorPrincipal;

public class TelaTesteLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTesteLogin frame = new TelaTesteLogin();
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
	public TelaTesteLogin() {
		GerenciadorPrincipal gerenciadorPrincipal = new GerenciadorPrincipal (criarFrabricaDeRepositorios());
		super.setContentPane(gerenciadorFornecedor);
		super.setExtendedState(JFrame.MAXIMIZED_BOTH);
		super.setVisible(true);

	
	}
	
	public FabricaDeRepositorios criarFrabricaDeRepositorios() {
		
		
	}
}
