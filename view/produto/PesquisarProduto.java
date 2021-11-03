package view.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Produto;
import repository.RepositorioProduto;

public class PesquisarProduto extends JPanel {
	private JTextField tfId;

	public PesquisarProduto(GerenciadorProduto gerenciadorProduto, RepositorioProduto repositorio) {
		setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 46, 14);
		add(lblId);

		tfId = new JTextField();
		tfId.setBounds(10, 36, 320, 20);
		add(tfId);
		tfId.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				id = Integer.parseInt(tfId.getText());

				Produto p = repositorio.find(id);

				gerenciadorProduto.exibirProduto(p);
			}
		});
		btnPesquisar.setBounds(340, 35, 100, 23);
		add(btnPesquisar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorProduto.menuProduto();
			}
		});
		btnCancelar.setBounds(340, 266, 100, 23);
		add(btnCancelar);
	}
	
}
