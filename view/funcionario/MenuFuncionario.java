package view.funcionario;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuFuncionario extends JPanel {

	public MenuFuncionario(GerenciadorFuncionario gerenciadorFuncionario) {
		setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar Funcion\u00E1rio");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorFuncionario.cadastrarFuncionario();
			}
		});
		btnCadastrar.setBounds(10, 11, 430, 23);
		add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar Funcion\u00E1rio");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorFuncionario.editarFuncionario();
			}
		});
		btnEditar.setBounds(10, 45, 430, 23);
		add(btnEditar);
		
		JButton btnExibir = new JButton("Exibir Funcion\u00E1rios");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorFuncionario.exibirFuncionarios(null);
			}
		});
		btnExibir.setBounds(10, 79, 430, 23);
		add(btnExibir);
		
		JButton btnRemover = new JButton("Remover Funcion\u00E1rio");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorFuncionario.removerFuncionario();
			}
		});
		btnRemover.setBounds(10, 113, 430, 23);
		add(btnRemover);

	}
}
