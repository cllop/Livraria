package view.fornecedor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import config.DevConfig;

public class MenuFornecedor extends JPanel {

	public MenuFornecedor(GerenciadorFornecedor gerenciadorFornecedor) {
		if(DevConfig.guiDevMode) {
			super.setBackground(Color.white);
		}
		setLayout(null);

		JButton btnAdicionar = new JButton("Adicionar Fornecedor");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorFornecedor.adicionarFornecedor();
			}
		});
		btnAdicionar.setBounds(10, 75, 430, 23);
		add(btnAdicionar);

		JButton btnPesquisar = new JButton("Pesquisar Fornecedor");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorFornecedor.dadosDePesquisaFornecedor();
			}
		});
		btnPesquisar.setBounds(10, 143, 430, 23);
		add(btnPesquisar);

		JButton btnDeletar = new JButton("Deletar Fornecedor");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorFornecedor.deletarFornecedor();
			}
		});
		btnDeletar.setBounds(10, 177, 430, 23);
		add(btnDeletar);

		JButton btnEditar = new JButton("Editar Fornecedor");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorFornecedor.editarFornecedor();
			}
		});
		btnEditar.setBounds(10, 109, 430, 23);
		add(btnEditar);

	}
}
