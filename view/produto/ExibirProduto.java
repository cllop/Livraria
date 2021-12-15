package view.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import modelo.Produto;
import util.Real;

public class ExibirProduto extends JPanel {
	private JTextField tfNome;
	private JTextField tfPreco;
	private JTextField tfQuantidade;
	private JTextField tfId;
	private JTextPane tpDescricao;
	private JTextField tfIdSetor;

	public ExibirProduto(GerenciadorProduto gerenciador, Produto produto) {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setBounds(25, 44, 46, -19);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 67, 60, 14);
		add(lblNewLabel_1);

		tfNome = new JTextField();
		tfNome.setEditable(false);
		tfNome.setBounds(10, 92, 259, 20);
		add(tfNome);
		tfNome.setColumns(10);
		tfNome.setText(produto.getNome());

		JLabel lblNewLabel_2 = new JLabel("Pre\u00E7o");
		lblNewLabel_2.setBounds(10, 127, 60, 14);
		add(lblNewLabel_2);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setBounds(304, 11, 89, 14);
		add(lblDescricao);

		tpDescricao = new JTextPane();
		tpDescricao.setEditable(false);
		tpDescricao.setBounds(304, 36, 259, 258);
		add(tpDescricao);
		tpDescricao.setText(produto.getDescricao());

		tfPreco = new JTextField();
		tfPreco.setEditable(false);
		tfPreco.setBounds(10, 152, 259, 20);
		add(tfPreco);
		tfPreco.setColumns(10);
		tfPreco.setText(produto.getPreco().toString());

		JLabel lblNewLabel_4 = new JLabel("Quantidade");
		lblNewLabel_4.setBounds(10, 193, 73, 14);
		add(lblNewLabel_4);

		tfQuantidade = new JTextField();
		tfQuantidade.setEditable(false);
		tfQuantidade.setBounds(10, 218, 259, 20);
		add(tfQuantidade);
		tfQuantidade.setColumns(10);
		tfQuantidade.setText(Integer.toString(produto.getQuantidade()));

		JLabel lblNewLabel_3 = new JLabel("Id");
		lblNewLabel_3.setBounds(10, 11, 46, 14);
		add(lblNewLabel_3);

		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(10, 36, 259, 20);
		add(tfId);
		tfId.setColumns(10);
		tfId.setText(Integer.toString(produto.getId()));

		JLabel lblIDSetor = new JLabel("ID do Setor");
		lblIDSetor.setBounds(10, 249, 124, 14);
		add(lblIDSetor);

		tfIdSetor = new JTextField();
		tfIdSetor.setEditable(false);
		tfIdSetor.setBounds(10, 274, 259, 20);
		add(tfIdSetor);
		tfIdSetor.setColumns(10);
		tfIdSetor.setText(Integer.toString(produto.getIdSetor()));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciador.menuProduto();
			}
		});
		btnVoltar.setBounds(474, 453, 89, 23);
		add(btnVoltar);

		if (gerenciador != null) {
			JButton btnNewButton = new JButton("Pesquisar Outro Produto");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gerenciador.pesquisarProduto();
				}
			});
			btnNewButton.setBounds(30, 453, 100, 23);
			add(btnNewButton);

		}
	}

	public void habilitarCamposEditaveis() {
		tfNome.setEditable(true);
		tfPreco.setEditable(true);
		tpDescricao.setEditable(true);
		tfIdSetor.setEditable(true);
	}

	public Produto lerCampos() {
		return new Produto(Integer.parseInt(tfId.getText()), tfNome.getText(), tpDescricao.getText(), new Real(tfPreco.getText()), Integer.parseInt(tfQuantidade.getText()), Integer.parseInt(tfIdSetor.getText()));
	}
}
