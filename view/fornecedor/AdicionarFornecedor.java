package view.fornecedor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AdicionarFornecedor extends JPanel {
	private JTextField textCNPJ;
	private JTextField textNome;
	private JTextField textRua;
	private JTextField textBairro;
	private JTextField textField;

	public AdicionarFornecedor(GerenciadorFornecedor gerenciadorFornecedor) {
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 67, 46, 14);
		add(lblNome);
		
		textCNPJ = new JTextField();
		textCNPJ.setBounds(10, 36, 430, 20);
		add(textCNPJ);
		textCNPJ.setColumns(10);
		
		JLabel lblCNPJ = new JLabel("CNPJ");
		lblCNPJ.setBounds(10, 11, 46, 14);
		add(lblCNPJ);
		
		textNome = new JTextField();
		textNome.setBounds(10, 92, 430, 20);
		add(textNome);
		textNome.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(10, 123, 46, 14);
		add(lblRua);
		
		textRua = new JTextField();
		textRua.setBounds(10, 148, 430, 20);
		add(textRua);
		textRua.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 179, 46, 14);
		add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setBounds(10, 204, 430, 20);
		add(textBairro);
		textBairro.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(10, 260, 430, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(10, 235, 46, 14);
		add(lblCEP);

	}
}
