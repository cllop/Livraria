package view;

import javax.swing.JButton;

import repository.RepositorioCaixa;
import repository.RepositorioFuncionario;
import repository.RepositorioGerente;
import repository.RepositorioVendedor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuBarFuncionario extends MenuBarUsuario {

	/**
	 * Create the panel.
	 */
	public MenuBarFuncionario(GerenciadorPrincipal gerenciadorPrincipal) {
		super(gerenciadorPrincipal);
		
		JButton btnNewButton = new JButton("Menu de Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.menuCliente();
			}
		});
		
		add(btnNewButton);

	}

	
}
