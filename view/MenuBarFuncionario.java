package view;

import javax.swing.JButton;

public class MenuBarFuncionario extends MenuBarUsuario {

	/**
	 * Create the panel.
	 */
	public MenuBarFuncionario(GerenciadorPrincipal gerenciadorPrincipal) {
		super(gerenciadorPrincipal);
		
		JButton btnNewButton = new JButton("Menu de Cliente");
		
		add(btnNewButton);

	}
}
