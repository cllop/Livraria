package view.venda;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.Cliente;
import modelo.Vendedor;
import repository.RepositorioCliente;
import view.GerenciadorPrincipal;

public class SelecionarCliente extends JPanel {
	private JTextField tfNomeDeUsuario;
	private JPasswordField pfSenha;

	/**
	 * Create the panel.
	 */
	public SelecionarCliente(GerenciadorPrincipal gerenciadorPrincipal, Vendedor vendedor, RepositorioCliente repositorio) {
		setBackground(new Color(0, 102, 102));
		setLayout(null);
		
		JButton btnProximo = new JButton("Proximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeDeUsuario = tfNomeDeUsuario.getText();
				String senhaDoUsuario = pfSenha.getText();
				
				try {
					Cliente cliente = repositorio.findByNomeDeUsuarioAndSenha(nomeDeUsuario, senhaDoUsuario);
					gerenciadorPrincipal.selecionarProdutosDaVenda(vendedor, cliente);
			
				}catch(Exception ex){
					JOptionPane.showMessageDialog(btnProximo, "Cliente não cadastrado");
					
				}
			}
		});
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
