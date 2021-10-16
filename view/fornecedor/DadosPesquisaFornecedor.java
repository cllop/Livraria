package view.fornecedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Fornecedor;
import repository.RepositorioFornecedor;
import view.DadosPesquisa;

public class DadosPesquisaFornecedor extends DadosPesquisa {
	private JTextField textCNPJ;

	public DadosPesquisaFornecedor(GerenciadorFornecedor gerenciador, RepositorioFornecedor repositorio) {
		btnPesquisarPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome=tfNome.getText();
				
				Fornecedor fornecedor = repositorio.findByNome(nome);
				List<Fornecedor> listaDeFornecedor = Arrays.asList(fornecedor);
				gerenciador.exibirFornecedores(listaDeFornecedor);
			}
		});
		
		btnPesquisarPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tfId.getText());
				
				Fornecedor fornecedor=repositorio.find(id);
				List<Fornecedor> listaDeFornecedor = Arrays.asList(fornecedor);
				gerenciador.exibirFornecedores(listaDeFornecedor);
			}
		});
		tfId.setBounds(10, 28, 262, 20);
		
		JLabel lblCNPJ = new JLabel("CNPJ");
		lblCNPJ.setBounds(10, 115, 46, 14);
		add(lblCNPJ);
		
		textCNPJ = new JTextField();
		textCNPJ.setBounds(10, 140, 262, 20);
		add(textCNPJ);
		textCNPJ.setColumns(10);
		
		JButton btnPesquisarPorCNPJ = new JButton("Pesquisar por CNPJ");
		btnPesquisarPorCNPJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long cnpj = Long.parseLong(textCNPJ.getText());
				
				Fornecedor fornecedor=repositorio.findByCnpj(cnpj);
				List<Fornecedor> listaDeFornecedor = Arrays.asList(fornecedor);
				gerenciador.exibirFornecedores(listaDeFornecedor);
			}
		});
		btnPesquisarPorCNPJ.setBounds(282, 139, 158, 23);
		add(btnPesquisarPorCNPJ);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciador.menuFornecedor();
			}
		});
		btnCancelar.setBounds(351, 266, 89, 23);
		add(btnCancelar);

	}

}
