package view.Cliente;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		btnCadastrarCliente.setBounds(10, 21, 159, 23);
		add(btnCadastrarCliente);
		
		JButton btnPesquisarCliente = new JButton("Pesquisar Cliente");
		btnPesquisarCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPesquisarCliente.setBounds(10, 55, 159, 23);
		add(btnPesquisarCliente);
		
		JButton btnDeletarCliente = new JButton("Deletar Cliente");
		btnDeletarCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeletarCliente.setBounds(10, 89, 159, 23);
		add(btnDeletarCliente);

	}
}
