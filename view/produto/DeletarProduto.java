package view.produto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import modelo.Produto;
import repository.RepositorioProduto;

public class DeletarProduto extends JPanel {

	public DeletarProduto(GerenciadorProduto gerenciador, RepositorioProduto repositorio, Produto produto) {
		setLayout(new BorderLayout(0, 0));
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					repositorio.delete(produto);
					
				} catch (Exception ex){
					
					throw new RuntimeException("Não foi possível deletar este produto."+ex);
				}
			}
		});
		add(btnDeletar, BorderLayout.NORTH);
		
		ExibirProduto panel = new ExibirProduto(gerenciador, produto);
		add(panel, BorderLayout.CENTER);
	}

}
