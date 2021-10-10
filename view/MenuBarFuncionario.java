package view;

import javax.swing.JButton;

public class MenuBarFuncionario extends MenuBarUsuario {

	/**
	 * Create the panel.
	 */
	public MenuBarFuncionario(GerenciadorPrincipal gerenciadorprincipal) {
		super(gerenciadorprincipal);
		
		JButton btnNewButton = new JButton("Menu de Cliente");
		
		add(btnNewButton);

	}
}
