package view.produto;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import modelo.Produto;
import repository.RepositorioProdutoAndLivro;

public class ExibirProduto extends JPanel {
	private JTextField tfNome;
	private JTextField tfPreco;
	private JTextField tfQuantidade;

	/**
	 * Create the panel.
	 */
	public ExibirProduto(GerenciadorProduto gerenciadorProduto, RepositorioProdutoAndLivro repositorio,Produto produto) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setBounds(25, 44, 46, -19);
		add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Nome ");
		lblNewLabel_1.setBounds(25, 11, 60, 14);
		add(lblNewLabel_1);
		
		tfNome = new JTextField();
		tfNome.setEditable(false);
		tfNome.setBounds(25, 35, 156, 20);
		add(tfNome);
		tfNome.setColumns(10);
		tfNome.setText(produto.getNome());
		
		JLabel lblNewLabel_2 = new JLabel("Pre\u00E7o");
		lblNewLabel_2.setBounds(25, 66, 60, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_3.setBounds(202, 19, 73, 14);
		add(lblNewLabel_3);
		
		JTextPane tfdescricao = new JTextPane();
		tfdescricao.setEditable(false);
		tfdescricao.setBounds(202, 44, 238, 142);
		add(tfdescricao);
		tfdescricao.setText(produto.getDescricao());
		
		
		tfPreco = new JTextField();
		tfPreco.setEditable(false);
		tfPreco.setBounds(25, 85, 156, 20);
		add(tfPreco);
		tfPreco.setColumns(10);
		tfPreco.setText(produto.getPreco().toString());
		
		
		JLabel lblNewLabel_4 = new JLabel("Quantidade");
		lblNewLabel_4.setBounds(25, 112, 73, 14);
		add(lblNewLabel_4);
		
		tfQuantidade = new JTextField();
		tfQuantidade.setEditable(false);
		tfQuantidade.setBounds(25, 128, 156, 20);
		add(tfQuantidade);
		tfQuantidade.setColumns(10);
		tfQuantidade.setText(Integer.toString(produto.getQuantidade()));

	}
	
}
