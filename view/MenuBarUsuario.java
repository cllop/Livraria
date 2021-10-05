package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;

public class MenuBarUsuario extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuBarUsuario(GerenciadorPrincipal gerenciadorPrincipal) {
		setLayout(null);
		
		JButton btnPesquisarProduto = new JButton("Pesquisar Produto");
		btnPesquisarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.pesquisarProduto();
			}
		});
		btnPesquisarProduto.setBounds(10, 11, 160, 25);
		add(btnPesquisarProduto);
		
		JButton btnAlterarSenha = new JButton("Aterar Senha");
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.alterarSenha();
			}
		});
		add(btnAlterarSenha);
		btnAlterarSenha.setBounds(10, 47, 160, 25);

	}
}
