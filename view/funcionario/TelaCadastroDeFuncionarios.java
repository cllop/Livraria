package view.funcionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import repository.RepositorioCaixa;
import repository.RepositorioGerente;
import repository.RepositorioVendedor;
import view.Usuario.DadosUsuario;

public class TelaCadastroDeFuncionarios extends JPanel {
	private DadosUsuario dadosUsuario;

	public TelaCadastroDeFuncionarios(GerenciadorFuncionario gerenciadorFuncionario, RepositorioGerente rpGerente, RepositorioCaixa rpCaixa, RepositorioVendedor rpVendedor) {
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 796, 422);
		add(scrollPane);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 11, 796, 22);
		add(comboBox);
		comboBox.addItem("Gerente");
		comboBox.addItem("Caixa");
		comboBox.addItem("Vendedor");

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("Gerente")) {
					dadosUsuario = new DadosGerente();
					scrollPane.setViewportView(dadosUsuario);
				} else if (comboBox.getSelectedItem().equals("Caixa")) {
					dadosUsuario = new DadosCaixa();
					scrollPane.setViewportView(dadosUsuario);
				} else if (comboBox.getSelectedItem().equals("Vendedor")) {
					dadosUsuario = new DadosVendedor();
					scrollPane.setViewportView(dadosUsuario);
				}
			}
		});

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if (comboBox.getSelectedItem().equals("Gerente")) {
						rpGerente.add(((DadosGerente)dadosUsuario).lerGerente());
					} else if (comboBox.getSelectedItem().equals("Caixa")) {
						rpCaixa.add(((DadosCaixa)dadosUsuario).lerCaixa());
					} else if (comboBox.getSelectedItem().equals("Vendedor")) {
						rpVendedor.add(((DadosVendedor)dadosUsuario).lerVendedor());
					}
					
					JOptionPane.showMessageDialog(btnConfirmar,"Funcionário cadastrado com sucesso.");
					
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(btnConfirmar, "Nao foi possível continuar a operação.");
				}
			}
		});
		btnConfirmar.setBounds(603, 465, 89, 23);
		add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorFuncionario.menuFuncionario();
			}
		});
		btnCancelar.setBounds(20, 465, 120, 23);
		add(btnCancelar);

	}
}
