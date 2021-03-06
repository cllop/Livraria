package view.venda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Vendedor;
import repository.RepositorioCliente;
import view.GerenciadorPrincipal;

public class JanelaSelecionarCliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaSelecionarCliente frame = new JanelaSelecionarCliente(null, null, null);
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
	public JanelaSelecionarCliente(GerenciadorPrincipal gerenciadorPrincipal ,Vendedor vendedor, RepositorioCliente repositorio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new SelecionarCliente(gerenciadorPrincipal, vendedor, repositorio);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

}
