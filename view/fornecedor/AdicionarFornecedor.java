package view.fornecedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Fornecedor;
import repository.RepositorioFornecedor;

public class AdicionarFornecedor extends JPanel {
	private JTextField textCNPJ;
	private JTextField textNome;
	private JTextField textRua;
	private JTextField textBairro;
	private JTextField textCEP;
	private JTextField textNumeroIDomovel;

	public AdicionarFornecedor(GerenciadorFornecedor gerenciadorFornecedor, RepositorioFornecedor repositorio) {
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
		
		textCEP = new JTextField();
		textCEP.setBounds(10, 260, 430, 20);
		add(textCEP);
		textCEP.setColumns(10);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(10, 235, 46, 14);
		add(lblCEP);
		
		JLabel lblNumeroDoImovel = new JLabel("N\u00FAmero do Im\u00F3vel");
		lblNumeroDoImovel.setBounds(10, 291, 109, 14);
		add(lblNumeroDoImovel);
		
		textNumeroIDomovel = new JTextField();
		textNumeroIDomovel.setBounds(10, 316, 430, 20);
		add(textNumeroIDomovel);
		textNumeroIDomovel.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long cnpj=Long.parseLong(textCNPJ.getText());
				String nome=textNome.getText();
				String rua=textRua.getText();
				String bairro=textBairro.getText();
				int cep=Integer.parseInt(textCEP.getText());
				int numeroDoImovel=Integer.parseInt(textNumeroIDomovel.getText());
				
				Fornecedor fornecedor=new Fornecedor(cnpj, nome, rua, bairro, cep, numeroDoImovel);
				repositorio.add(fornecedor);
			}
		});
		btnConfirmar.setBounds(352, 362, 89, 23);
		add(btnConfirmar);

	}
}
