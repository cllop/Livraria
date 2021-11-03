package view.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Produto;
import repository.RepositorioProduto;
import view.DadosPesquisa;

public class DadosPesquisaParaDeletarProduto extends DadosPesquisa {

	public DadosPesquisaParaDeletarProduto(GerenciadorProduto gerenciador, RepositorioProduto repositorio) {
//		btnPesquisarPorNome.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String nome = null;
//				nome = tfNome.getText();
//				Produto p = repositorio.findByNome(nome);
//				gerenciador.deletarProduto(p);
//			}
//		});

		
		btnPesquisarPorNome.setVisible(false);
		super.btnPesquisarPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				id = Integer.parseInt(tfId.getText());
				Produto p;
				p = repositorio.find(id);
				gerenciador.deletarProduto(p);
			}
		});
	}
}
