package view.Usuario;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class AlterarSenhaDeUsuario extends JPanel {
	private JPasswordField ptfSenhaAntiga;
	private JPasswordField ptfSenhaNova;
	private JPasswordField ptfConfirmarSenha;

	/**
	 * Create the panel.
	 */
	public AlterarSenhaDeUsuario() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Senha Antiga");
		lblNewLabel.setBounds(10, 11, 106, 14);
		add(lblNewLabel);
		
		ptfSenhaAntiga = new JPasswordField();
		ptfSenhaAntiga.setBounds(10, 36, 149, 20);
		add(ptfSenhaAntiga);
		
		ptfSenhaNova = new JPasswordField();
		ptfSenhaNova.setBounds(10, 92, 149, 20);
		add(ptfSenhaNova);
		
		JLabel lblSenhaNova = new JLabel("Senha Nova");
		lblSenhaNova.setBounds(10, 67, 106, 14);
		add(lblSenhaNova);
		
		ptfConfirmarSenha = new JPasswordField();
		ptfConfirmarSenha.setBounds(10, 148, 149, 20);
		add(ptfConfirmarSenha);
		
		JLabel lblComfirmarSenhaNova = new JLabel("Comfirmar Senha Nova");
		lblComfirmarSenhaNova.setBounds(10, 123, 149, 14);
		add(lblComfirmarSenhaNova);
		
		JButton btnConfirmar = new JButton("Confirmar ");
		btnConfirmar.setBounds(422, 374, 89, 23);
		add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 374, 89, 23);
		add(btnVoltar);

	}
}
