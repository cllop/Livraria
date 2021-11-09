package view.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Produto;
import repository.RepositorioProduto;

public class DeletarProduto extends JPanel {

	public DeletarProduto(GerenciadorProduto gerenciador, RepositorioProduto repositorio, Produto produto) {
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(180, 321, 115, 23);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					repositorio.delete(produto);
					JOptionPane.showMessageDialog(btnDeletar, "Produto deletado!");
					gerenciador.menuProduto();
				}catch (Exception ex) {
					throw new RuntimeException(ex);
					
				}
				
			}
		});
		setLayout(null);
		add(btnDeletar);
		
		ExibirProduto panel = new ExibirProduto(gerenciador, produto);
		panel.setBounds(0, 22, 594, 358);
		add(panel);
	}

}
