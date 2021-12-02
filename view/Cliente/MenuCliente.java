package view.Cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import modelo.Cliente;
import repository.RepositorioCliente;

public class MenuCliente extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuCliente(GerenciadorCliente gerenciadorCliente) {
		setBackground(new Color(0, 102, 102));
		setLayout(null);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorCliente.cadastrarCliente();
			}
		});
		btnCadastrarCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrarCliente.setBounds(10, 21, 228, 23);
		add(btnCadastrarCliente);
		
		JButton btnPesquisarCliente = new JButton("Pesquisar Cliente");
		btnPesquisarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisarCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPesquisarCliente.setBounds(10, 55, 228, 23);
		add(btnPesquisarCliente);
		
		JButton btnEditarCliente = new JButton("Editar Cliente");
		btnEditarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarCliente.setBounds(10, 89, 228, 23);
		add(btnEditarCliente);

	}
}
