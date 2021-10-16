package view.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import modelo.Produto;
import repository.RepositorioProdutoAndLivro;
import view.DadosPesquisa;

public class PesquisarDeletarProduto extends DadosPesquisa {
	/**
	 * Create the panel.
	 */
	public PesquisarDeletarProduto(GerenciadorProduto gerenciador,RepositorioProdutoAndLivro repositorio) {
		
		
		btnPesquisarPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = null;
				
				Produto p;
				nome = tfNome.getText();	
				p = repositorio.findByNome(nome);
				
				gerenciador.deletarProduto();
						
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
