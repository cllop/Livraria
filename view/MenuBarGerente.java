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
		
		add(btnFuncionario);
		
		JButton btnProduto = new JButton("Menu Produto");
		btnProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.menuProduto();
			}
		});
		
		add(btnProduto);
		
		JButton btnFornecedor = new JButton("Menu Fornecedor ");
		btnFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.menuFornecedor();
			}
		});
	
		add(btnFornecedor);
		
		JButton btnSetor = new JButton("Menu Setor");
		btnSetor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.menuSetor();	
			}
		});
		
		add(btnSetor);
		
		JButton btnMenuCompras = new JButton("Menu Compras");
		btnMenuCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.menuCompras();
			}
		});
	
		add(btnMenuCompras);
		
		JButton btnCadastrarPlanoVip = new JButton("Cadastrar Plano Vip");
		btnCadastrarPlanoVip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 gerenciadorPrincipal.cadastrarPlanoVip();	
			}
		});
		
		add(btnCadastrarPlanoVip);
	}
	
}
