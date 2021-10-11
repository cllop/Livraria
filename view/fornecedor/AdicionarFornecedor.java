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
	private JTextField textNumeroDoImovel;
	private JTextField textNomeFantasia;

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
		lblRua.setBounds(10, 179, 46, 14);
		add(lblRua);
		
		textRua = new JTextField();
		textRua.setBounds(10, 204, 430, 20);
		add(textRua);
		textRua.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 235, 46, 14);
		add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setBounds(10, 262, 430, 20);
		add(textBairro);
		textBairro.setColumns(10);
		
		textCEP = new JTextField();
		textCEP.setBounds(10, 318, 430, 20);
		add(textCEP);
		textCEP.setColumns(10);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(10, 293, 46, 14);
		add(lblCEP);
		
		JLabel lblNumeroDoImovel = new JLabel("N\u00FAmero do Im\u00F3vel");
		lblNumeroDoImovel.setBounds(10, 349, 109, 14);
		add(lblNumeroDoImovel);
		
		textNumeroDoImovel = new JTextField();
		textNumeroDoImovel.setBounds(10, 374, 430, 20);
		add(textNumeroDoImovel);
		textNumeroDoImovel.setColumns(10);
		
		JLabel lblNomeFantasia = new JLabel("Nome Fantasia");
		lblNomeFantasia.setBounds(10, 123, 98, 14);
		add(lblNomeFantasia);
		
		textNomeFantasia = new JTextField();
		textNomeFantasia.setBounds(10, 148, 430, 20);
		add(textNomeFantasia);
		textNomeFantasia.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long cnpj=Long.parseLong(textCNPJ.getText());
				String nome=textNome.getText();
				String nomeFantasia=textNomeFantasia.getText();
				String rua=textRua.getText();
				String bairro=textBairro.getText();
				int cep=Integer.parseInt(textCEP.getText());
				short numeroDoImovel=Short.parseShort(textNumeroDoImovel.getText());
				
				Fornecedor fornecedor=new Fornecedor(cnpj, nome, nomeFantasia, rua, bairro, cep, numeroDoImovel);
				repositorio.add(fornecedor);
			}
		});
		btnAdicionar.setBounds(343, 458, 98, 23);
		add(btnAdicionar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorFornecedor.menuFornecedor();
			}
		});
		btnCancelar.setBounds(235, 458, 98, 23);
		add(btnCancelar);
	}
}
