package view.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Produto;
import repository.RepositorioProduto;
import view.DadosPesquisa;
import view.GerenciadorPrincipal;

public class DadosPesquisaProduto extends DadosPesquisa {

	public DadosPesquisaProduto(GerenciadorPrincipal gerenciador,RepositorioProduto repositorio) {
		btnPesquisarPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome;
				nome = tfNome.getText();
				Produto p;
				p = repositorio.findByNome(nome);
				gerenciador.exibirProduto(p);
			}
		});
		super.btnPesquisarPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				id= Integer.parseInt(tfId.getText());
				Produto p;
				p= repositorio.find(id);
				gerenciador.exibirProduto(p);
			}
		});
		
		
	}

}
