package view.fornecedor;

import view.DadosDePesquisa;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DadosDePesquisaFornecedor extends DadosDePesquisa {
	private JTextField textCNPJ;

	public DadosDePesquisaFornecedor() {
		tfId.setBounds(10, 28, 262, 20);
		
		JLabel lblCNPJ = new JLabel("CNPJ");
		lblCNPJ.setBounds(10, 115, 46, 14);
		add(lblCNPJ);
		
		textCNPJ = new JTextField();
		textCNPJ.setBounds(10, 140, 262, 20);
		add(textCNPJ);
		textCNPJ.setColumns(10);
		
		JButton btnPesquisarPorCNPJ = new JButton("Pesquisar por CNPJ");
		btnPesquisarPorCNPJ.setBounds(282, 139, 158, 23);
		add(btnPesquisarPorCNPJ);

	}

}
