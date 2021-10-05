package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuBarGerente extends MenuBarUsuario {

	
	public MenuBarGerente(GerenciadorPrincipal gerenciadorPrincipal) {
		super(gerenciadorPrincipal);
		
		JButton btnFuncionario = new JButton("Menu Funcionario");
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.menuFuncionario();
			}
		});
		btnFuncionario.setBounds(42, 80, 163, 23);
		add(btnFuncionario);
		
		JButton btnProduto = new JButton("Menu Produto");
		btnProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.menuFuncionario();
			}
		});
		btnProduto.setBounds(42, 114, 163, 23);
		add(btnProduto);
		
		JButton btnFornecedor = new JButton("Menu Fornecedor ");
		btnFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.menuFornecedor();
			}
		});
		btnFornecedor.setBounds(42, 148, 163, 23);
		add(btnFornecedor);
		
		JButton btnSetor = new JButton("Menu Setor");
		btnSetor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.menuSetor();	
			}
		});
		btnSetor.setBounds(42, 182, 163, 23);
		add(btnSetor);
		
		JButton btnMenuCompras = new JButton("Menu Compras");
		btnMenuCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.menuCompras();
			}
		});
		btnMenuCompras.setBounds(42, 216, 163, 23);
		add(btnMenuCompras);
	}
}
