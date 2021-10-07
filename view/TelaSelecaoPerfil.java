package view;

import java.util.List;

import javax.swing.JPanel;

import modelo.Usuario;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class TelaSelecaoPerfil extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaSelecaoPerfil(TelaLogin telaLogin ,List <Usuario> usuarios) {
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(51, 21, 365, 42);
		add(comboBox);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setBounds(303, 196, 89, 23);
		add(btnSelecionar);
		//se comunica com tela de login chamando o metodo do perfil selecionado
	}
}
