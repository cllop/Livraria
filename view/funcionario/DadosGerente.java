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

		if (exibicao) {
			checkBoxSuperGerente.setEnabled(false);
		}
		checkBoxSuperGerente.setSelected(gerente.isSuperGerente());
	}

	private void adicionarComponentes() {
		checkBoxSuperGerente = new JCheckBox("Super Gerente");
		checkBoxSuperGerente.setBounds(162, 459, 97, 23);
		add(checkBoxSuperGerente);
	}

	public Gerente lerGerente() {
		return new Gerente(Long.parseLong(textCpf.getText()), textNome.getText(), textSobrenome.getText(),
				textNomeUsuario.getText(), textPais.getText(), textEstado.getText(), textCidade.getText(),
				textRua.getText(), textBairro.getText(), Integer.parseInt(textCep.getText()),
				Integer.parseInt(textNumeroResidencia.getText()), Byte.parseByte(textDdi.getText()),
				Byte.parseByte(textDdd.getText()), Integer.parseInt(textTelefone.getText()), checkBoxAtivo.isSelected(),
				checkBoxSuperGerente.isSelected());
	}
}
