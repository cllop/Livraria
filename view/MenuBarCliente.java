package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;

public class MenuBarCliente extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuBarCliente(GerenciadorPrincipal gerenciadorPrincipal) {
		setLayout(null);
		
		JButton btnPesquisarProduto = new JButton("Pesquisar Produto");
		btnPesquisarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.pesquisarProduto();
			}
		});
		btnPesquisarProduto.setBounds(10, 11, 158, 23);
		add(btnPesquisarProduto);
		
		JButton btnAlterarSenha = new JButton("Aterar Senha");
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.alterarSenha();
			}
		});
		btnAlterarSenha.setBounds(10, 45, 158, 23);
		add(btnAlterarSenha);
		
		JButton btnNewButton = new JButton("Apagar Dados Pessoais");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.apagarDadosPessoais();
			}
		});
		btnNewButton.setBounds(10, 79, 158, 23);
		add(btnNewButton);

	}
}
