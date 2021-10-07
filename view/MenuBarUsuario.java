package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuBarUsuario extends JPanel {
	private int quantidadeDeBotoesAdicionada;

	/**
	 * Create the panel.
	 */
	public MenuBarUsuario(GerenciadorPrincipal gerenciadorPrincipal) {
		setLayout(null);
		
		JButton btnPesquisarProduto = new JButton("Pesquisar Produto");
		btnPesquisarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.pesquisarProduto();
				
			}
		});

		add(btnPesquisarProduto);
		
		JButton btnEditarDadosDAConta = new JButton("Editar Dados da Conta");
		btnEditarDadosDAConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.alterarSenha();
			}
		});
		add(btnEditarDadosDAConta);
	
		JButton btnPesquisarPlanoVip = new JButton("Pesquisar Plano Vip");
		btnPesquisarPlanoVip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				gerenciadorPrincipal.pesquisarPlanoVip();
				
			}
		});
		add(btnPesquisarPlanoVip);
	}
	
	
	public Component add(Component comp) {
		
		if(comp instanceof JButton) {
			posicionarBotao((JButton)comp);
		}
		
		return super.add(comp);
	}
	public void posicionarBotao(JButton botao) {
		int y = 10+((10*quantidadeDeBotoesAdicionada)+25*quantidadeDeBotoesAdicionada);
		botao.setBounds(41, y, 160, 25);
		
		
		quantidadeDeBotoesAdicionada++;
	}
}
