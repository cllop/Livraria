package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaPricipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPricipal frame = new JanelaPricipal();
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
	public JanelaPricipal() {
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.contentPane = new GerenciadorPrincipal();
		super.setContentPane(contentPane);
		super.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
