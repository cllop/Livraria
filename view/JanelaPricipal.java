package view;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaPricipal extends JFrame {

	private GerenciadorPrincipal contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPricipal frame = new JanelaPricipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public JanelaPricipal() {
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.contentPane = new GerenciadorPrincipal();
		super.setContentPane(contentPane);
		super.setExtendedState(JFrame.MAXIMIZED_BOTH);
		super.setVisible(true);
	}
	
	

}
