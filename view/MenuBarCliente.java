package view;
import javax.swing.JButton;

public class MenuBarCliente extends MenuBarUsuario {

	/**
	 * Create the panel.
	 */
	public MenuBarCliente(GerenciadorPrincipal gp) {
		super(gp);
		
		JButton btnApagarDadosPessoais = new JButton("Apagar Dados Pessoais");
		
		add(btnApagarDadosPessoais);
		
		
	}
}
