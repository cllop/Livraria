package view.produto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Produto;
import repository.RepositorioProduto;

public class PesquisarEditarProduto extends JPanel {
	private JTextField tfId;

	/**
	 * Create the panel.
	 * @param produto 
	 */
	public PesquisarEditarProduto(GerenciadorProduto gerenciadorProduto, RepositorioProduto repositorio) {
		setLayout(null);
		
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setForeground(Color.RED);
		lblMensagem.setBounds(10, 67, 169, 14);
		add(lblMensagem);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		add(lblNewLabel_1);
		
		JButton btnPesquisarPorId = new JButton("Pesquisar");
		btnPesquisarPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tfId.getText());
				
				
					
					Produto p = repositorio.find(id);
					if(p != null) {
						  gerenciadorProduto.editarProdutos(p);
					}else {
						
						JOptionPane.showMessageDialog(null, "Produto não existe");;
						
					}
				  
			}
		});
		btnPesquisarPorId.setBounds(239, 35, 89, 23);
		add(btnPesquisarPorId);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(10, 11, 46, 14);
		add(lblNewLabel);
		
		tfId = new JTextField();
		tfId.setBounds(10, 33, 167, 20);
		add(tfId);
		tfId.setColumns(10);
		
		
		
		

	}
}
