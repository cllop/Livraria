package view.funcionario;

import modelo.Vendedor;

public class DadosVendedor extends DadosFuncionario {
	
	public DadosVendedor() {
		
	}
	
	public Vendedor lerVendedor() {
		return new Vendedor(Long.parseLong(textCpf.getText()),textNome.getText(),textSobrenome.getText(),textNomeUsuario.getText(),textRua.getText(), textBairro.getText(), Integer.parseInt(textCep.getText()),Integer.parseInt(textNumeroResidencia.getText()),Byte.parseByte(textDdi.getText()),Byte.parseByte(textDdd.getText()),Integer.parseInt(textTelefone.getText()));
	}
	
}
