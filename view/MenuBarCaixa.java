package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MenuBarCaixa extends MenuBarUsuario {

	/**
	 * Create the panel.
	 */
	public MenuBarCaixa(GerenciadorPrincipal gerenciadorPrincipal) {
		super(gerenciadorPrincipal);
		
		JButton btnVender = new JButton("Vender");
	
		add(btnVender);
		
		JButton btnEstornarVenda = new JButton("Estornar Venda");
		
		add(btnEstornarVenda);
		
		JButton btnDevolucao = new JButton("Devolu\u00E7\u00E3o");
		btnDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		add(btnDevolucao);
		
		JButton btnAssinarPlanoVip = new JButton("Assinar Plano Vip");
		
		add(btnAssinarPlanoVip);
		

	}
}
