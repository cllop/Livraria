package view.fornecedor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modelo.Fornecedor;

public class ExibirFornecedores extends JScrollPane {
	

	public ExibirFornecedores(GerenciadorFornecedor gerenciador, List<Fornecedor> listaDeFornecedores) {
		
		JPanel panel = new JPanel();
		setViewportView(panel);
		panel.setLayout(new GridLayout(listaDeFornecedores.size(), 1, 0, 0));
		
		JButton btnVoltarMenu = new JButton("Voltar Para Menu Fornecedor");
		btnVoltarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciador.menuFornecedor();
			}
		});
		setColumnHeaderView(btnVoltarMenu);
		
		for (Fornecedor fornecedor : listaDeFornecedores) {
			panel.add(new ExibirFornecedor(fornecedor));
		}

	}

}
