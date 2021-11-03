package view.funcionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import modelo.Caixa;
import modelo.Gerente;
import modelo.Vendedor;
import repository.RepositorioCaixa;
import repository.RepositorioGerente;
import repository.RepositorioVendedor;
import view.DadosPesquisa;
import javax.swing.JButton;

public class DadosPesquisaFuncionarios extends DadosPesquisa {

	public DadosPesquisaFuncionarios(RepositorioGerente rpGerente, RepositorioCaixa rpCaixa, RepositorioVendedor rpVendedor) {
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 115, 430, 22);
		add(comboBox);
		comboBox.addItem("Gerente");
		comboBox.addItem("Caixa");
		comboBox.addItem("Vendedor");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 405, 388, -236);
		add(scrollPane);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(351, 465, 89, 23);
		add(btnCancelar);

		btnPesquisarPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("Gerente")) {
					Gerente gerente = rpGerente.find(Integer.parseInt(tfId.getText()));
					scrollPane.setViewportView(new DadosGerente(gerente, true));
				} else if (comboBox.getSelectedItem().equals("Caixa")) {
					Caixa caixa = rpCaixa.find(Integer.parseInt(tfId.getText()));
					scrollPane.setViewportView(new DadosCaixa(caixa, true));
				} else if (comboBox.getSelectedItem().equals("Vendedor")) {
					Vendedor vendedor = rpVendedor.find(Integer.parseInt(tfId.getText()));
					scrollPane.setViewportView(new DadosVendedor(vendedor, true));
				}
			}
		});
	}
}
