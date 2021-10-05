package view.produto;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MenuProduto extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuProduto(GerenciadorProduto gerenciadorProduto) {
		setLayout(null);
		
		JButton btnAdicionarProduto = new JButton("Adicionar Produto");
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			gerenciadorProduto.adicionarProduto();
			}
		});
		btnAdicionarProduto.setBounds(10, 11, 137, 23);
		add(btnAdicionarProduto);
		
		JButton btnDeletarProduto = new JButton("Deletar Produto");
		btnDeletarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorProduto.deletarProduto();
			}
		});
		btnDeletarProduto.setBounds(10, 56, 137, 23);
		add(btnDeletarProduto);

	}

}
