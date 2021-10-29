package view.produto;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import modelo.Produto;
import repository.RepositorioProduto;
import util.Real;
import view.GerenciadorPrincipal;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExibirProduto extends JPanel {
	private JTextField tfNome;
	private JTextField tfPreco;
	private JTextField tfQuantidade;
	private JTextField tfId;
	private JTextPane tpDescricao;

	
	public ExibirProduto(Produto produto) {
		this(null, produto);
	}
	
	
	public ExibirProduto(GerenciadorPrincipal gerenciador,Produto produto) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setBounds(25, 44, 46, -19);
		add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Nome ");
		lblNewLabel_1.setBounds(25, 67, 60, 14);
		add(lblNewLabel_1);
		
		tfNome = new JTextField();
		tfNome.setEditable(false);
		tfNome.setBounds(25, 92, 156, 20);
		add(tfNome);
		tfNome.setColumns(10);
		tfNome.setText(produto.getNome());
		
		JLabel lblNewLabel_2 = new JLabel("Pre\u00E7o");
		lblNewLabel_2.setBounds(25, 127, 60, 14);
		add(lblNewLabel_2);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setBounds(202, 19, 73, 14);
		add(lblDescricao);
		
		tpDescricao = new JTextPane();
		tpDescricao.setEditable(false);
		tpDescricao.setBounds(202, 44, 238, 142);
		add(tpDescricao);
		tpDescricao.setText(produto.getDescricao());
		
		
		tfPreco = new JTextField();
		tfPreco.setEditable(false);
		tfPreco.setBounds(25, 152, 156, 20);
		add(tfPreco);
		tfPreco.setColumns(10);
		tfPreco.setText(produto.getPreco().toString());
		
		
		JLabel lblNewLabel_4 = new JLabel("Quantidade");
		lblNewLabel_4.setBounds(25, 193, 73, 14);
		add(lblNewLabel_4);
		
		tfQuantidade = new JTextField();
		tfQuantidade.setEditable(false);
		tfQuantidade.setBounds(25, 218, 156, 20);
		add(tfQuantidade);
		tfQuantidade.setColumns(10);
		tfQuantidade.setText(Integer.toString(produto.getQuantidade()));
		
		JLabel lblNewLabel_3 = new JLabel("Id");
		lblNewLabel_3.setBounds(25, 11, 46, 14);
		add(lblNewLabel_3);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(23, 36, 158, 20);
		add(tfId);
		tfId.setColumns(10);
		tfId.setText(Integer.toString(produto.getId()));
		
		if(gerenciador != null) {
			JButton btnNewButton = new JButton("Pesquisar Outro Produto");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					gerenciador.pesquisarProduto();
					
				}
			});
			btnNewButton.setBounds(25, 266, 178, 23);
			add(btnNewButton);

		}
	}
	
	public void habilitarCamposEditaveis() {
		tfNome.setEditable(true); 
		tfPreco.setEditable(true);
		tpDescricao.setEditable(true);
	}
	
	public Produto lerCampos() {
		
		
		
		return new Produto(Integer.parseInt(tfId.getText()),tfNome.getText(),tpDescricao.getText(),new Real( tfPreco.getText()),Integer.parseInt(tfQuantidade.getText()));
		
		
	}
}
