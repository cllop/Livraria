package view.fornecedor;

import javax.swing.JLabel;
import javax.swing.JTextField;

import repository.RepositorioFornecedor;
import view.DadosDePesquisa;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PesquisarEditarFornecedor extends DadosDePesquisa{
	private JTextField textCnpj;

	public PesquisarEditarFornecedor(GerenciadorFornecedor gerenciadorFornecedor, RepositorioFornecedor repositorio) {
		tfId.setSize(262, 20);
		tfNome.setLocation(10, 84);
		tfId.setLocation(10, 28);
		setLayout(null);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(10, 115, 46, 14);
		add(lblCnpj);
		
		textCnpj = new JTextField();
		textCnpj.setBounds(10, 140, 262, 20);
		add(textCnpj);
		textCnpj.setColumns(10);
		
		JButton btnPesquisarPorCnpj = new JButton("Pesquisar por CNPJ");
		btnPesquisarPorCnpj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnPesquisarPorCnpj.setBounds(282, 139, 158, 23);
		add(btnPesquisarPorCnpj);
		
		
		
		

	}
}
