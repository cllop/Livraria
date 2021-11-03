package view.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuProduto extends JPanel {

	public MenuProduto(GerenciadorProduto gerenciadorProduto) {
		setLayout(null);
		
		JButton btnAdicionarProduto = new JButton("Adicionar Produto");
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			gerenciadorProduto.adicionarProduto();
			}
		});
		btnAdicionarProduto.setBounds(10, 11, 430, 23);
		add(btnAdicionarProduto);
		
		JButton btnDeletarProduto = new JButton("Deletar Produto");
		btnDeletarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorProduto.deletarProduto();
			}
		});
		btnDeletarProduto.setBounds(10, 83, 430, 23);
		add(btnDeletarProduto);
		try {
			JButton btnEditarProduto = new JButton("Editar Produto");
			btnEditarProduto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gerenciadorProduto.editarProdutos();
				}
			});
			
			btnEditarProduto.setBounds(10, 45, 430, 23);
			add(btnEditarProduto);
		}catch(Exception execao){
			System.out.println("O erro"+execao);
		}	
	}
}
