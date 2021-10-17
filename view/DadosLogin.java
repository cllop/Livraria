package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import config.DevConfig;
import modelo.Usuario;
import repository.RepositorioUsuario;

public class DadosLogin extends JPanel {
	private JTextField tfNomeDeUsuario;
	private JPasswordField tfSenha;

	/**
	 * Create the panel.
	 */
	public DadosLogin(TelaLogin telaLogin, RepositorioUsuario repositorio) {
		if (DevConfig.guiDevMode) {
			this.setBackground(Color.orange);
		}
		setLayout(null);
		
		
		
		tfNomeDeUsuario = new JTextField();
		tfNomeDeUsuario.setBounds(42, 81, 278, 20);
		add(tfNomeDeUsuario);
		tfNomeDeUsuario.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome de Usuario");
		lblNome.setBounds(42, 56, 108, 14);
		add(lblNome);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(42, 122, 46, 14);
		add(lblNewLabel_1);
		
		tfSenha = new JPasswordField();
		tfSenha.setBounds(42, 145, 278, 20);
		add(tfSenha);
		
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setForeground(Color.RED);
		lblMensagem.setBounds(42, 11, 172, 14);
		add(lblMensagem);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List <Usuario> perfisDeUsuario= repositorio.findTodosPerfisByNomeDeUsuarioAndSenha(tfNomeDeUsuario.getText(),tfSenha.getText() );
				
				if(perfisDeUsuario.size()>0) {
					
					telaLogin.realizarLogin(perfisDeUsuario);
					
				}else {
					
					lblMensagem.setText("Usuario não encotrado");
					
				}
				
				
				
				
			}
		});
		btnConfirmar.setBounds(256, 216, 102, 23);
		add(btnConfirmar);
		
		
		//campos de login
		//ao apertar o boato de logar usa o repositorio de usuario e obtem o usuario
	}
}
