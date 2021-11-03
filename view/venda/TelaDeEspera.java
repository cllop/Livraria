package view.venda;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Vendedor;
import view.GerenciadorPrincipal;

public class TelaDeEspera extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaDeEspera(GerenciadorPrincipal gerenciadorPrincipal ,Vendedor vendedor) {
		setBackground(new Color(0, 102, 102));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pessa para o cliente inserir os dados...");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(139, 83, 302, 14);
		add(lblNewLabel);
		
		JButton btnRealizarVendaSemCliente = new JButton("Realizar venda sem cliente");
		btnRealizarVendaSemCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRealizarVendaSemCliente.setBounds(157, 183, 212, 23);
		add(btnRealizarVendaSemCliente);

	}

}
