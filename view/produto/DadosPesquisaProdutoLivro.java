package view.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Produto;
import repository.RepositorioProdutoAndLivro;
import view.DadosPesquisa;

public class DadosPesquisaProdutoLivro extends DadosPesquisa {
	private JTextField tfCategoria;
	private JTextField tfAutor;

	/**
	 * Create the panel.
	 */
	public DadosPesquisaProdutoLivro(PesquisarProduto pesquisa,RepositorioProdutoAndLivro repositorio) {
		super.btnPesquisarPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				id= Integer.parseInt(tfId.getText());
				Produto p;
				p= repositorio.find(id);
				List<Produto> listaDeProduto= Arrays.asList(p);
				pesquisa.exibirprodutos(listaDeProduto);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Nome do Autor");
		lblNewLabel.setBounds(10, 110, 92, 14);
		add(lblNewLabel);
		
		tfCategoria = new JTextField();
		tfCategoria.setBounds(10, 130, 262, 20);
		add(tfCategoria);
		tfCategoria.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Categoria");
		lblNewLabel_1.setBounds(10, 157, 116, 14);
		add(lblNewLabel_1);
		
		tfAutor = new JTextField();
		tfAutor.setBounds(10, 174, 262, 20);
		add(tfAutor);
		tfAutor.setColumns(10);
		
		
		JButton btnPesquisarAutor = new JButton("Pesquisar por Autor");
		btnPesquisarAutor.setBounds(282, 129, 158, 23);
		add(btnPesquisarAutor);
		
		JButton btnPesquisarCategoria = new JButton("Pesquisar por Categoria");
		btnPesquisarCategoria.setBounds(282, 173, 158, 23);
		add(btnPesquisarCategoria);
		
		
	}

}
