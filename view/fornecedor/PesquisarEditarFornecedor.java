package view.fornecedor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Fornecedor;
import repository.RepositorioFornecedor;
import view.DadosPesquisa;

public class PesquisarEditarFornecedor extends DadosPesquisa{
	private JTextField textCnpj;

	public PesquisarEditarFornecedor(GerenciadorFornecedor gerenciador, RepositorioFornecedor repositorio) {
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setForeground(Color.RED);
		lblMensagem.setBounds(10, 224, 430, 65);
		add(lblMensagem);
		tfId.setSize(262, 20);
		tfNome.setLocation(10, 84);
		tfId.setLocation(10, 28);
		setLayout(null);
		
		btnPesquisarPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tfId.getText());
				
				try {
					Fornecedor fornecedor = repositorio.find(id);
					gerenciador.editarFornecedor(fornecedor);
				} catch(Exception ex) {
					lblMensagem.setText("Fornecedor não encontrado.");
				}
			}
		});
		
		btnPesquisarPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tfNome.getText();
				
				try {
					Fornecedor fornecedor = repositorio.findByNome(nome);
					gerenciador.editarFornecedor(fornecedor);
				} catch(Exception ex) {
					lblMensagem.setText("Fornecedor não encontrado.");
				}
			}
		});
		
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
				long cnpj = Long.parseLong(textCnpj.getText());
				
				try {
					Fornecedor fornecedor = repositorio.findByCnpj(cnpj);
					gerenciador.editarFornecedor(fornecedor);
				}catch (Exception ex){
					lblMensagem.setText("Fornecedor não econtrado.");
				}
			}
		});
		btnPesquisarPorCnpj.setBounds(282, 139, 158, 23);
		add(btnPesquisarPorCnpj);
	}
	
}
