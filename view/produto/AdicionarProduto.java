package view.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import modelo.Produto;
import repository.RepositorioProdutoAndLivro;
import util.Real;

public class AdicionarProduto extends JPanel {
	private JTextField tfNome;
	private JTextPane tfDescricao;
	private JTextField tfPreco;
	private JTextField tfQuantidade;
	private JButton btnCadastrarProduto;

	/**
	 * Create the panel.
	 */
	public AdicionarProduto(GerenciadorProduto gerenciadorProduto, RepositorioProdutoAndLivro repositorio) {
		AdicionarProduto esseAdicionarProduto= this;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome ");
		lblNewLabel.setBounds(29, 11, 46, 14);
		add(lblNewLabel);
		
		tfNome = new JTextField();
		tfNome.setBounds(10, 30, 259, 20);
		add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descricao");
		lblNewLabel_1.setBounds(307, 11, 52, 14);
		add(lblNewLabel_1);
		
		tfDescricao = new JTextPane();
		tfDescricao.setBounds(307, 30, 364, 225);
		add(tfDescricao);
		
		
		JLabel lblNewLabel_2 = new JLabel("Preco");
		lblNewLabel_2.setBounds(29, 61, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade");
		lblNewLabel_3.setBounds(20, 106, 86, 14);
		add(lblNewLabel_3);
		
		tfPreco = new JTextField();
		tfPreco.setBounds(10, 75, 86, 20);
		add(tfPreco);
		tfPreco.setColumns(10);
		
		tfQuantidade = new JTextField();
		tfQuantidade.setBounds(10, 119, 86, 20);
		add(tfQuantidade);
		tfQuantidade.setColumns(10);
		
		JButton btnVoltarAoMenuProduto = new JButton("Voltar ao Menu Produto");
		btnVoltarAoMenuProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorProduto.menuProduto();
			}
		});
		btnVoltarAoMenuProduto.setBounds(104, 266, 145, 23);
		add(btnVoltarAoMenuProduto);
		
		btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome= tfNome.getText();
				String descricao= tfDescricao.getText();
				Real preco= new Real(tfPreco.getText());
				int quantidade= Integer.parseInt(tfQuantidade.getText());
				Produto produto= new Produto(nome, descricao, preco, quantidade);
				repositorio.add(produto);
				JOptionPane.showMessageDialog(esseAdicionarProduto, "Produto adicionado com sucesso!");
				gerenciadorProduto.menuProduto();
			}
		});
		btnCadastrarProduto.setBounds(259, 266, 121, 23);
		add(btnCadastrarProduto);
		
		JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
		btnCadastrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome= tfNome.getText();
				String descricao= tfDescricao.getText();
				Real preco= new Real(tfPreco.getText());
				int quantidade= Integer.parseInt(tfQuantidade.getText());
				Produto produto= new Produto(nome, descricao, preco, quantidade);
				gerenciadorProduto.adicionarLivro(produto);
			}
		});
		btnCadastrarLivro.setBounds(390, 266, 161, 23);
		add(btnCadastrarLivro);

	}
}
