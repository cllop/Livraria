package view.funcionario;

import modelo.Caixa;

public class DadosCaixa extends DadosFuncionario {

	public DadosCaixa() {

	}

	public DadosCaixa(Caixa caixa, boolean exibicao) {
		super();
	}

	public Caixa lerCaixa() {
		return new Caixa(Long.parseLong(textCpf.getText()), textNome.getText(), textSobrenome.getText(),
				textNomeUsuario.getText(), textSenha.getText(), textPais.getText(), textEstado.getText(),
				textCidade.getText(), textRua.getText(), textBairro.getText(), Integer.parseInt(textCep.getText()),
				Short.parseShort(textNumeroResidencia.getText()), Byte.parseByte(textDdi.getText()),
				Byte.parseByte(textDdd.getText()), Integer.parseInt(textTelefone.getText()),
				checkBoxAtivo.isSelected());
	}

}
