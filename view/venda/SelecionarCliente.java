package view.Venda;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

public class SelecionarCliente extends JPanel {
	private JTextField tfNomeDeUsuario;
	private JPasswordField pfSenha;

	/**
	 * Create the panel.
	 */
	public SelecionarCliente() {
		setBackground(new Color(0, 102, 102));
		setLayout(null);
		
		JButton btnProximo = new JButton("Proximo");
		btnProximo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProximo.setBounds(407, 350, 89, 23);
		add(btnProximo);
		
		JLabel lblNewLabel = new JLabel("Nome de usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(21, 50, 140, 14);
		add(lblNewLabel);
		
		tfNomeDeUsuario = new JTextField();
		tfNomeDeUsuario.setBounds(21, 75, 214, 20);
		add(tfNomeDeUsuario);
		tfNomeDeUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(21, 116, 46, 14);
		add(lblNewLabel_1);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(21, 141, 214, 20);
		add(pfSenha);

	}
}
