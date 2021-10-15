package view.funcionario;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class AdicionarFuncionario extends JPanel {
	private JTextField tfNome;
	private JTextField tfSobrenome;
	private JTextField tfNomeDeUsuario;
	private JTextField tfCpf;
	private JTextField tfTelefone;
	private JTextField tfRua;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textField;
	private JLabel lblNewLabel_7;
	private JTextField tfCep;
	private JLabel lblNewLabel_8;
	private JTextField tfNumeroDaResidencia;
	public AdicionarFuncionario() {
		setLayout(null);
		
		tfNome = new JTextField();
		tfNome.setBounds(10, 24, 86, 20);
		add(tfNome);
		tfNome.setColumns(10);
		
		tfSobrenome = new JTextField();
		tfSobrenome.setBounds(10, 66, 86, 20);
		add(tfSobrenome);
		tfSobrenome.setColumns(10);
		
		tfNomeDeUsuario = new JTextField();
		tfNomeDeUsuario.setBounds(10, 111, 86, 20);
		add(tfNomeDeUsuario);
		tfNomeDeUsuario.setColumns(10);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(10, 155, 86, 20);
		add(tfCpf);
		tfCpf.setColumns(10);
		
		tfTelefone = new JTextField();
		tfTelefone.setBounds(10, 197, 86, 20);
		add(tfTelefone);
		tfTelefone.setColumns(10);
		
		tfRua = new JTextField();
		tfRua.setBounds(129, 66, 86, 20);
		add(tfRua);
		tfRua.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("nome");
		lblNewLabel.setBounds(26, 11, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("sobrenome");
		lblNewLabel_1.setBounds(20, 55, 64, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("nome de usuario");
		lblNewLabel_2.setBounds(10, 97, 95, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("cpf");
		lblNewLabel_3.setBounds(20, 143, 46, 14);
		add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("telefone");
		lblNewLabel_4.setBounds(20, 186, 46, 14);
		add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("rua");
		lblNewLabel_5.setBounds(161, 55, 46, 14);
		add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("bairro");
		lblNewLabel_6.setBounds(161, 11, 46, 14);
		add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(129, 24, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		lblNewLabel_7 = new JLabel("cep");
		lblNewLabel_7.setBounds(161, 97, 46, 14);
		add(lblNewLabel_7);
		
		tfCep = new JTextField();
		tfCep.setBounds(129, 111, 86, 20);
		add(tfCep);
		tfCep.setColumns(10);
		
		lblNewLabel_8 = new JLabel("numero da residencia");
		lblNewLabel_8.setBounds(129, 143, 128, 14);
		add(lblNewLabel_8);
		
		tfNumeroDaResidencia = new JTextField();
		tfNumeroDaResidencia.setBounds(129, 155, 86, 20);
		add(tfNumeroDaResidencia);
		tfNumeroDaResidencia.setColumns(10);
	}
}
