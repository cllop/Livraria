package view.fornecedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Fornecedor;
import repository.RepositorioFornecedor;

public class EditarFornecedor extends JPanel {

	public EditarFornecedor(GerenciadorFornecedor gerenciador, Fornecedor fornecedor, RepositorioFornecedor repositorio) {
		setLayout(null);
		
		ExibirFornecedor panel = new ExibirFornecedor(fornecedor);
		panel.setBounds(0, 0, 400, 300);
		add(panel);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedor fornecedor = panel.lerCamposDigitadosPeloUsuario();
								
				try {
					repositorio.update(fornecedor);
					JOptionPane.showMessageDialog(btnEditar, "Fornecedor alterado com sucesso!");
				} catch (Exception ex){
					JOptionPane.showMessageDialog(btnEditar, "Erro ao editar.");
				}
			}
		});
		btnEditar.setBounds(351, 346, 89, 23);
		add(btnEditar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciador.menuFornecedor();
			}
		});
		btnCancelar.setBounds(252, 346, 89, 23);
		add(btnCancelar);
		
		panel.habilitarCamposEditaveis();

	}
}
