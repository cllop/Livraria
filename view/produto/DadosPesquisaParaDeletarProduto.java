package view.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import modelo.Produto;
import repository.RepositorioProduto;
import view.DadosPesquisa;

public class DadosPesquisaParaDeletarProduto extends DadosPesquisa {
	/**
	 * Create the panel.
	 */
	public DadosPesquisaParaDeletarProduto(GerenciadorProduto gerenciador,Produto produto) {
		
		
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
