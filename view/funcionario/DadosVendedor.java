package view.funcionario;

import javax.swing.JCheckBox;

import modelo.Vendedor;

public class DadosVendedor extends DadosFuncionario {

	public DadosVendedor() {

	}

	public DadosVendedor(Vendedor vendedor, boolean exibicao) {
		super();
	}

	public Vendedor lerVendedor() { 
		return new Vendedor(Long.parseLong(textCpf.getText()), textNome.getText(), textSobrenome.getText(),
				textNomeUsuario.getText(), textSenha.getText(), textPais.getText(), textEstado.getText(), textCidade.getText(),
				textRua.getText(), textBairro.getText(), Integer.parseInt(textCep.getText()),
				Short.parseShort(textNumeroResidencia.getText()), Byte.parseByte(textDdi.getText()),
				Byte.parseByte(textDdd.getText()), Integer.parseInt(textTelefone.getText()),
				checkBoxAtivo.isSelected());
	}

}
