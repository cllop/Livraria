package view.fornecedor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Fornecedor;

public class ExibirFornecedor extends JPanel {
	private JTextField textCNPJ;
	private JTextField textNome;
	private JTextField textRua;
	private JTextField textBairro;
	private JTextField textCEP;
	private JTextField textNumeroDoImovel;

	public ExibirFornecedor(GerenciadorFornecedor gerenciador, Fornecedor fornecedor) {
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 67, 46, 14);
		add(lblNome);
		
		textCNPJ = new JTextField();
		textCNPJ.setEditable(false);
		textCNPJ.setBounds(10, 36, 430, 20);
		add(textCNPJ);
		textCNPJ.setColumns(10);
		
		JLabel lblCNPJ = new JLabel("CNPJ");
		lblCNPJ.setBounds(10, 11, 46, 14);
		add(lblCNPJ);
		
		textNome = new JTextField();
		textNome.setEditable(false);
		textNome.setBounds(10, 92, 430, 20);
		add(textNome);
		textNome.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(10, 123, 46, 14);
		add(lblRua);
		
		textRua = new JTextField();
		textRua.setEditable(false);
		textRua.setBounds(10, 148, 430, 20);
		add(textRua);
		textRua.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 179, 46, 14);
		add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setEditable(false);
		textBairro.setBounds(10, 204, 430, 20);
		add(textBairro);
		textBairro.setColumns(10);
		
		textCEP = new JTextField();
		textCEP.setEditable(false);
		textCEP.setBounds(10, 260, 430, 20);
		add(textCEP);
		textCEP.setColumns(10);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(10, 235, 46, 14);
		add(lblCEP);
		
		JLabel lblNumeroDoImovel = new JLabel("N\u00FAmero do Im\u00F3vel");
		lblNumeroDoImovel.setBounds(10, 291, 109, 14);
		add(lblNumeroDoImovel);
		
		textNumeroDoImovel = new JTextField();
		textNumeroDoImovel.setEditable(false);
		textNumeroDoImovel.setBounds(10, 316, 430, 20);
		add(textNumeroDoImovel);
		textNumeroDoImovel.setColumns(10);

		
		textCNPJ.setText(Long.toString(fornecedor.getCnpj()));
		textNome.setText(fornecedor.getNome());
		textRua.setText(fornecedor.getRua());
		textBairro.setText(fornecedor.getBairro());
		textCEP.setText(Integer.toString(fornecedor.getCep()));
		textNumeroDoImovel.setText(Integer.toString(fornecedor.getNumeroDoImovel()));
		
	}

}
