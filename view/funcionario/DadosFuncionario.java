package view.funcionario;

import javax.swing.JCheckBox;

import modelo.Funcionario;
import view.Usuario.DadosUsuario;

public class DadosFuncionario extends DadosUsuario {
	JCheckBox checkBoxAtivo;
	
	public DadosFuncionario() {
		iniciarComponentes();
	}
	
	public DadosFuncionario(Funcionario funcionario, boolean exibicao) {
		super(funcionario, exibicao);
		iniciarComponentes();
		
		if(exibicao) {
			checkBoxAtivo.setEnabled(false);
		}
		
		checkBoxAtivo.setSelected(funcionario.isAtivo());
	}
	
	private void iniciarComponentes() {
		this.checkBoxAtivo = new JCheckBox("Ativo");
		checkBoxAtivo.setBounds(10, 459, 97, 23);
		add(checkBoxAtivo);
	}
	
	
}
