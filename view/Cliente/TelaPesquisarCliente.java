package view.Cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import repository.RepositorioCliente;
import view.DadosPesquisa;

public class TelaPesquisarCliente extends DadosPesquisa {

	/**
	 * Create the panel.
	 */
	public TelaPesquisarCliente(GerenciadorCliente gerenciadorCliente, RepositorioCliente repositorioCLiente) {
		btnPesquisarPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnPesquisarPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tfId.setLocation(10, 28);
		setBackground(new Color(102, 204, 204));
		setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorCliente.menuCliente();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(351, 266, 89, 23);
		add(btnNewButton_1);

	}
}
