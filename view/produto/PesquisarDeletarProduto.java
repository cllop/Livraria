package view.produto;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Produto;
import repository.RepositorioProdutoAndLivro;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PesquisarDeletarProduto extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PesquisarDeletarProduto(GerenciadorProduto gerenciadorProduto, RepositorioProdutoAndLivro repositorio, Produto produto) {
		setLayout(null);
		
		ExibirProduto panel = new ExibirProduto(produto);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(10, 11, 46, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 35, 126, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produto produto;
				
				produto= panel.lerCampos();
				
			}
		});
		btnPesquisar.setBounds(229, 34, 89, 23);
		add(btnPesquisar);
		
		
		
	}
}
