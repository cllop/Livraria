package view.funcionario;

import modelo.Vendedor;

public class DadosVendedor extends DadosFuncionario {

	
	public DadosVendedor() {
		

	}
	
	public Vendedor lerVendedor() {
		
		return new Vendedor(Long.parseLong(tfCpf.getText()),tfNome.getText(),tfSobrenome.getText(),tfNomeDeUsuario.getText(),tfRua.getText(), tfBairro.getText(), Integer.parseInt(tfCep.getText()),Integer.parseInt(tfNumeroDaResidencia.getText()),Byte.parseByte(tfDdi.getText()),Byte.parseByte(tfDdd.getText()),Integer.parseInt(tfTelefone.getText()));
		
	}
	

}
