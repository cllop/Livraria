package view.produto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import config.DevConfig;
import modelo.Produto;
import repository.RepositorioProduto;
import util.Real;

public class AdicionarProduto extends JPanel {
	private JTextField tfNome;
	private JTextPane tfDescricao;
	private JTextField tfPreco;
	private JTextField tfQuantidade;
	private JButton btnCadastrarProduto;
	private JLabel lblIdSetor;
	private JTextField textIdSetor;

	public AdicionarProduto(GerenciadorProduto gerenciadorProduto, RepositorioProduto repositorio) {
		if (DevConfig.guiDevMode) {
			super.setBackground(Color.pink);
		}
		AdicionarProduto esseAdicionarProduto= this;
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome ");
		lblNome.setBounds(10, 11, 46, 14);
		add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(10, 36, 259, 20);
		add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setBounds(307, 11, 79, 14);
		add(lblDescricao);
		
		tfDescricao = new JTextPane();
		tfDescricao.setBounds(307, 36, 259, 256);
		add(tfDescricao);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setBounds(10, 67, 46, 14);
		add(lblPreco);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(10, 123, 86, 14);
		add(lblQuantidade);
		
		tfPreco = new JTextField();
		tfPreco.setBounds(10, 92, 259, 20);
		add(tfPreco);
		tfPreco.setColumns(10);
		
		tfQuantidade = new JTextField();
		tfQuantidade.setBounds(10, 148, 259, 20);
		add(tfQuantidade);
		tfQuantidade.setColumns(10);
		
		lblIdSetor = new JLabel("ID do Setor");
		lblIdSetor.setBounds(10, 179, 145, 14);
		add(lblIdSetor);
		
		textIdSetor = new JTextField();
		textIdSetor.setBounds(10, 204, 259, 20);
		add(textIdSetor);
		textIdSetor.setColumns(10);
		
		JButton btnVoltarAoMenuProduto = new JButton("Voltar ao Menu Produto");
		btnVoltarAoMenuProduto.setBounds(10, 435, 169, 23);
		btnVoltarAoMenuProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorProduto.menuProduto();
			}
		});
		add(btnVoltarAoMenuProduto);
		
		btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.setBounds(421, 435, 145, 23);
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome= tfNome.getText();
				String descricao= tfDescricao.getText();
				Real preco= new Real(tfPreco.getText());
				int quantidade= Integer.parseInt(tfQuantidade.getText());
				int idSetor = Integer.parseInt(textIdSetor.getText());
				
				Produto produto= new Produto(nome, descricao, preco, quantidade, idSetor);
				repositorio.add(produto);
				JOptionPane.showMessageDialog(esseAdicionarProduto, "Produto adicionado com sucesso.");
				gerenciadorProduto.menuProduto();
			}
		});
		add(btnCadastrarProduto);
		
		

	}
}
