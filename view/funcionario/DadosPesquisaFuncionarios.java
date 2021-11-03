package view.funcionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import modelo.Caixa;
import modelo.Gerente;
import modelo.Vendedor;
import repository.RepositorioCaixa;
import repository.RepositorioGerente;
import repository.RepositorioVendedor;
import view.DadosPesquisa;

public class DadosPesquisaFuncionarios extends DadosPesquisa {
	private DadosFuncionario dadosFuncionario; 

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
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(252, 460, 89, 23);
		add(btnVoltar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dadosFuncionario instanceof DadosGerente) {
					Gerente gerente = ((DadosGerente)dadosFuncionario).lerGerente();
					scrollPane.setViewportView(new EditarFuncionarios(gerente, rpGerente));
				}
			}
		});
		btnEditar.setBounds(351, 460, 89, 23);
		add(btnEditar);

		btnPesquisarPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("Gerente")) {
					Gerente gerente = rpGerente.find(Integer.parseInt(tfId.getText()));
					dadosFuncionario = new DadosGerente(gerente, true);
					scrollPane.setViewportView(dadosFuncionario);
					
				} else if (comboBox.getSelectedItem().equals("Caixa")) {
					Caixa caixa = rpCaixa.find(Integer.parseInt(tfId.getText()));
					dadosFuncionario = new DadosCaixa(caixa, true);
					scrollPane.setViewportView(dadosFuncionario);
					
				} else if (comboBox.getSelectedItem().equals("Vendedor")) {
					Vendedor vendedor = rpVendedor.find(Integer.parseInt(tfId.getText()));
					dadosFuncionario = new DadosVendedor(vendedor, true);
					scrollPane.setViewportView(dadosFuncionario);
				}
			}
		});
	}
}
