package view;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuBarCaixa extends MenuBarUsuario {

	/**
	 * Create the panel.
	 */
	public MenuBarCaixa(GerenciadorPrincipal gerenciadorPrincipal) {
		super(gerenciadorPrincipal);
		
		JButton btnVender = new JButton("Vender");
		btnVender.setBounds(42, 79, 157, 23);
		add(btnVender);
		
		JButton btnEstornarVenda = new JButton("Estornar Venda");
		btnEstornarVenda.setBounds(42, 113, 157, 23);
		add(btnEstornarVenda);
		
		JButton btnDevolucao = new JButton("Devolu\u00E7\u00E3o");
		btnDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDevolucao.setBounds(42, 148, 157, 23);
		add(btnDevolucao);
		

	}
}
