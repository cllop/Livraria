package view.funcionario;

import javax.swing.JCheckBox;

import modelo.Gerente;

public class DadosGerente extends DadosFuncionario {
	private JCheckBox checkBoxSuperGerente;

	public DadosGerente() {
		adicionarComponentes();
		
	}
	
	public DadosGerente(Gerente gerente, boolean exibicao) {
		super(gerente, exibicao);
		adicionarComponentes();
	}

	private void adicionarComponentes() {
		checkBoxSuperGerente = new JCheckBox("Super Gerente");
		checkBoxSuperGerente.setBounds(162, 459, 97, 23);
		add(checkBoxSuperGerente);
	}
}
