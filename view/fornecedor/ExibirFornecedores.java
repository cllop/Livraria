package view.fornecedor;

import java.util.List;

import javax.swing.JScrollPane;

import modelo.Fornecedor;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;

public class ExibirFornecedores extends JScrollPane {
	

	public ExibirFornecedores(GerenciadorFornecedor gerenciador, List<Fornecedor> listaFornecedores) {
		
		JPanel panel = new JPanel();
		setViewportView(panel);
		panel.setLayout(new GridLayout(listaFornecedores.size(), 1, 0, 0));
		
		JButton btnVoltarMenu = new JButton("Voltar Para Menu Fornecedor");
		setColumnHeaderView(btnVoltarMenu);
		
		for (Fornecedor fornecedor : listaFornecedores) {
			panel.add(new ExibirFornecedor(gerenciador, fornecedor));
		}

	}

}
