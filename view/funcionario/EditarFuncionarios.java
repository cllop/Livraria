package view.funcionario;

import javax.swing.JPanel;

import modelo.Funcionario;
import repository.RepositorioCaixa;
import repository.RepositorioGerente;
import repository.RepositorioVendedor;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class EditarFuncionarios extends JPanel {

	public EditarFuncionarios(Funcionario funcionario, RepositorioGerente rpGerente, RepositorioCaixa rpCaixa, RepositorioVendedor rpVendedor) {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 430, 435);
		add(scrollPane);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(351, 457, 89, 23);
		add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(252, 457, 89, 23);
		add(btnCancelar);

	}
}
