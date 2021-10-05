package view.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Produto;
import repository.RepositorioDeProduto;
import util.Real;

public class AdicionarProduto extends JPanel {
	private JTextField tfNome;
	private JTextField tfDescricao;
	private JTextField tfPreco;
	private JTextField tfQuantidade;
	private JButton btnCadastrarProduto;

	/**
	 * Create the panel.
	 */
	public AdicionarProduto(GerenciadorProduto gerenciadorProduto, RepositorioDeProduto repositorio) {
		AdicionarProduto esseAdicionarProduto= this;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome ");
		lblNewLabel.setBounds(29, 11, 46, 14);
		add(lblNewLabel);
		
		tfNome = new JTextField();
		tfNome.setBounds(10, 30, 86, 20);
		add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_1.setBounds(29, 67, 46, 14);
		add(lblNewLabel_1);
		
		tfDescricao = new JTextField();
		tfDescricao.setBounds(10, 81, 86, 20);
		add(tfDescricao);
		tfDescricao.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pre\u00E7o");
		lblNewLabel_2.setBounds(29, 135, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade");
		lblNewLabel_3.setBounds(20, 200, 86, 14);
		add(lblNewLabel_3);
		
		tfPreco = new JTextField();
		tfPreco.setBounds(10, 150, 86, 20);
		add(tfPreco);
		tfPreco.setColumns(10);
		
		tfQuantidade = new JTextField();
		tfQuantidade.setBounds(10, 212, 86, 20);
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
			}
		});
		btnCadastrarLivro.setBounds(390, 266, 161, 23);
		add(btnCadastrarLivro);

	}
}
