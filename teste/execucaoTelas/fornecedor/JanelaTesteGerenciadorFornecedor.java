package teste.execucaoTelas.fornecedor;

import java.awt.EventQueue;

import javax.swing.JFrame;

import repository.RepositorioFornecedor;
import view.JanelaPricipal;
import view.fornecedor.GerenciadorFornecedor;

public class JanelaTesteGerenciadorFornecedor extends JFrame {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JanelaTesteGerenciadorFornecedor();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaTesteGerenciadorFornecedor() {
		GerenciadorFornecedor gerenciadorFornecedor = new GerenciadorFornecedor(criarRepositorioDeTeste());
		super.setContentPane(gerenciadorFornecedor);
		super.setExtendedState(JFrame.MAXIMIZED_BOTH);
		super.setVisible(true);

	}
	
	public RepositorioFornecedor criarRepositorioDeTeste() {
		return null;
	}
}
