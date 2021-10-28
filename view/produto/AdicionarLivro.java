package view.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Livro;
import modelo.Produto;
import repository.RepositorioProduto;

public class AdicionarLivro extends JPanel {
	private JTextField tfIsbn;
	private JTextField tfAutor;
	private JTextField tfeditora;

	/**
	 * Create the panel.
	 */
	public AdicionarLivro(GerenciadorProduto gerenciadorProduto, RepositorioProduto repositorio, Produto produto) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(10, 11, 46, 14);
		add(lblNewLabel);
		
		tfIsbn = new JTextField();
		tfIsbn.setBounds(10, 25, 86, 20);
		add(tfIsbn);
		tfIsbn.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Autor");
		lblNewLabel_1.setBounds(10, 56, 46, 14);
		add(lblNewLabel_1);
		
		tfAutor = new JTextField();
		tfAutor.setBounds(10, 68, 86, 20);
		add(tfAutor);
		tfAutor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Editora ");
		lblNewLabel_2.setBounds(10, 96, 46, 14);
		add(lblNewLabel_2);
		
		tfeditora = new JTextField();
		tfeditora.setBounds(10, 109, 86, 20);
		add(tfeditora);
		tfeditora.setColumns(10);
		
		JButton btnCadastrarLivro = new JButton("Cadastrar");
		btnCadastrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String autor= tfAutor.getText();
				long isbn= Long.parseLong(tfIsbn.getText());
				String editora= tfeditora.getText();
				Livro livro= new Livro(produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getQuantidade(), isbn, autor, editora);
				repositorio.add(livro);
				JOptionPane.showMessageDialog(btnCadastrarLivro, "Livro cadastrado com sucesso");
				gerenciadorProduto.menuProduto();
			}
		});
		btnCadastrarLivro.setBounds(10, 164, 89, 23);
		add(btnCadastrarLivro);
		
	}

}
