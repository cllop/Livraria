package view.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import modelo.Produto;
import repository.RepositorioProdutoAndLivro;
import view.DadosPesquisa;

public class DeletarProduto extends DadosPesquisa {
	/**
	 * Create the panel.
	 */
	public DeletarProduto(GerenciadorProduto gerenciador,Produto produto) {
		
		
		btnPesquisarPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = null;
				
				Produto p;
				p= produto;
				nome = tfNome.getText();	
				
				
				gerenciador.deletarProduto(p);
						
			}
		});
		
		super.btnPesquisarPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				id= Integer.parseInt(tfId.getText());
				Produto p;
				p= repositorio.find(id);	
				gerenciador.deletarProduto();
			}
		});
		
	}
}
