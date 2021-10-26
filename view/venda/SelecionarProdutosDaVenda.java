package view.Venda;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

import modelo.Caixa;
import modelo.Cliente;
import modelo.Produto;
import modelo.Venda;
import modelo.Vendedor;
import repository.RepositorioProdutoAndLivro;
import repository.RepositorioVenda;
import view.GerenciadorPrincipal;

public class SelecionarProdutosDaVenda extends JPanel {
	private JTextField tfNomeProduto;
	private JTextField tfIDDoProduto;
	private JTable TabelaProdutos;

	/**
	 * Create the panel.
	 */
	public SelecionarProdutosDaVenda(GerenciadorPrincipal gerenciadorPrincipal, Vendedor vendedor, Cliente cliente, Caixa caixa,  RepositorioProdutoAndLivro repositorioProduto, RepositorioVenda repositorioVenda ) {
		setBackground(new Color(0, 102, 102));
		setLayout(null);
		
		Venda venda = new Venda(vendedor, cliente, caixa);
		
		ModeloDeTabelaVenda modeloTabela = new ModeloDeTabelaVenda(venda);
		
		JLabel lblNewLabel = new JLabel("Nome do produto:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 23, 125, 14);
		add(lblNewLabel);
		
		tfNomeProduto = new JTextField();
		tfNomeProduto.setBounds(10, 48, 167, 20);
		add(tfNomeProduto);
		tfNomeProduto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID do produto:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(342, 24, 143, 14);
		add(lblNewLabel_1);
		
		tfIDDoProduto = new JTextField();
		tfIDDoProduto.setBounds(343, 48, 167, 20);
		add(tfIDDoProduto);
		tfIDDoProduto.setColumns(10);
		
		JButton btnInserirPorNome = new JButton("Inserir por nome");
		btnInserirPorNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInserirPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInserirPorNome.setBounds(187, 47, 135, 23);
		add(btnInserirPorNome);
		
		JButton btnInserirPorID = new JButton("Inserir por ID");
		btnInserirPorID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tfIDDoProduto.getText());
				try {
					Produto produto = repositorioProduto.find(id);
					ItemDeVenda
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(btnInserirPorID, "Produto não encontrado.");
					
				}
			}
		});
		btnInserirPorID.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInserirPorID.setBounds(520, 47, 120, 23);
		add(btnInserirPorID);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(551, 422, 89, 23);
		add(btnCancelar);
		
		JButton btnFinalizarVenda = new JButton("Finalizar venda");
		btnFinalizarVenda.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFinalizarVenda.setBounds(654, 422, 120, 23);
		add(btnFinalizarVenda);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(551, 330, 78, 14);
		add(lblNewLabel_2);
		
		JButton btnRemoverProduto = new JButton("Remover produto");
		btnRemoverProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemoverProduto.setBounds(639, 354, 135, 23);
		add(btnRemoverProduto);
		
		JSpinner Quantidade = new JSpinner();
		Quantidade.setBounds(551, 355, 52, 20);
		add(Quantidade);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 465, 349);
		add(scrollPane);
		
		TabelaProdutos = new JTable();
		TabelaProdutos.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(TabelaProdutos);
		
		ExibicaoProduto panel = new ExibicaoProduto();
		panel.setBounds(485, 96, 318, 223);
		add(panel);

	}
}
