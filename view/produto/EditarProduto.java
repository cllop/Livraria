package view.produto;

import javax.swing.JPanel;

import modelo.Produto;
import repository.RepositorioProdutoAndLivro;
import repository.jdbc.RepositorioProdutoAndLivroJDBC;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarProduto extends JPanel {
	private JTextField tfId;

	/**
	 * Create the panel.
	 */
	public EditarProduto(GerenciadorProduto gerenciadorProduto, RepositorioProdutoAndLivro repositorio, Produto produto) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(10, 11, 46, 14);
		add(lblNewLabel);
		
		tfId = new JTextField();
		tfId.setBounds(10, 33, 167, 20);
		add(tfId);
		tfId.setColumns(10);
		
		JButton btnAvancar = new JButton("Avan\u00E7ar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				Produto p;		
				id = Integer.parseInt(tfId.getText());
				p = repositorio.find(id);
				
				repositorio.update(p);
			}
		});
		btnAvancar.setBounds(345, 295, 89, 23);
		add(btnAvancar);
		ExibirProduto esteProduto = null;
		
		

	}
}
