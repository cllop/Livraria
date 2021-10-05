package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MenuBarFuncionario extends MenuBarUsuario {

	/**
	 * Create the panel.
	 */
	public MenuBarFuncionario(GerenciadorPrincipal gerenciadorprincipal) {
		super(gerenciadorprincipal);
		
		JButton btnNewButton = new JButton("Menu de Cliente");
		btnNewButton.setBounds(42, 87, 160, 23);
		add(btnNewButton);

	}
}
