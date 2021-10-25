package view.venda;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.Font;

public class SelecionarProdutosDaVenda extends JPanel {
	private JTextField tfNomeProduto;
	private JTextField tfIDDoProduto;
	private JTable TabelaProdutos;

	/**
	 * Create the panel.
	 */
	public SelecionarProdutosDaVenda() {
		setBackground(new Color(0, 102, 102));
		setLayout(null);
		
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
		lblNewLabel_2.setBounds(570, 280, 78, 14);
		add(lblNewLabel_2);
		
		JButton btnRemoverProduto = new JButton("Remover produto");
		btnRemoverProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemoverProduto.setBounds(639, 305, 135, 23);
		add(btnRemoverProduto);
		
		JSpinner Quantidade = new JSpinner();
		Quantidade.setBounds(570, 306, 52, 20);
		add(Quantidade);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 465, 349);
		add(scrollPane);
		
		TabelaProdutos = new JTable();
		TabelaProdutos.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(TabelaProdutos);

	}
}
