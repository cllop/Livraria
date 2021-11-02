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
	private JTextField textDdd;
	private JTextField textDdi;
	private JTextField textNumeroTelefone;
	private JTextField textPais;
	private JTextField textEstado;
	private JTextField textCidade;

	public AdicionarFornecedor(GerenciadorFornecedor gerenciadorFornecedor, RepositorioFornecedor repositorio) {
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 67, 46, 14);
		add(lblNome);
		
		textCNPJ = new JTextField();
		textCNPJ.setBounds(10, 36, 365, 20);
		add(textCNPJ);
		textCNPJ.setColumns(10);
		
		JLabel lblCNPJ = new JLabel("CNPJ");
		lblCNPJ.setBounds(10, 11, 46, 14);
		add(lblCNPJ);
		
		textNome = new JTextField();
		textNome.setBounds(10, 92, 365, 20);
		add(textNome);
		textNome.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(10, 289, 46, 14);
		add(lblRua);
		
		textRua = new JTextField();
		textRua.setBounds(10, 314, 365, 20);
		add(textRua);
		textRua.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(214, 233, 46, 14);
		add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setBounds(214, 258, 161, 20);
		add(textBairro);
		textBairro.setColumns(10);
		
		textCEP = new JTextField();
		textCEP.setBounds(10, 370, 161, 20);
		add(textCEP);
		textCEP.setColumns(10);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(10, 345, 46, 14);
		add(lblCEP);
		
		JLabel lblNumeroDoImovel = new JLabel("N\u00FAmero do Im\u00F3vel");
		lblNumeroDoImovel.setBounds(214, 345, 148, 14);
		add(lblNumeroDoImovel);
		
		textNumeroDoImovel = new JTextField();
		textNumeroDoImovel.setBounds(214, 370, 161, 20);
		add(textNumeroDoImovel);
		textNumeroDoImovel.setColumns(10);
		
		JLabel lblNomeFantasia = new JLabel("Nome Fantasia");
		lblNomeFantasia.setBounds(10, 123, 137, 14);
		add(lblNomeFantasia);
		
		textNomeFantasia = new JTextField();
		textNomeFantasia.setBounds(10, 148, 365, 20);
		add(textNomeFantasia);
		textNomeFantasia.setColumns(10);
		
		JLabel lblDdd = new JLabel("DDD");
		lblDdd.setBounds(425, 11, 46, 14);
		add(lblDdd);
		
		textDdd = new JTextField();
		textDdd.setBounds(425, 36, 161, 20);
		add(textDdd);
		textDdd.setColumns(10);
		
		JLabel lblDdi = new JLabel("DDI");
		lblDdi.setBounds(626, 11, 46, 14);
		add(lblDdi);
		
		textDdi = new JTextField();
		textDdi.setBounds(626, 36, 161, 20);
		add(textDdi);
		textDdi.setColumns(10);
		
		JLabel lblNumeroTelefone = new JLabel("N\u00FAmero de Telefone");
		lblNumeroTelefone.setBounds(425, 67, 119, 14);
		add(lblNumeroTelefone);
		
		textNumeroTelefone = new JTextField();
		textNumeroTelefone.setBounds(425, 92, 365, 20);
		add(textNumeroTelefone);
		textNumeroTelefone.setColumns(10);
		
		JLabel lblPais = new JLabel("Pa\u00EDs");
		lblPais.setBounds(10, 181, 46, 14);
		add(lblPais);
		
		textPais = new JTextField();
		textPais.setBounds(10, 202, 161, 20);
		add(textPais);
		textPais.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(214, 181, 46, 14);
		add(lblEstado);
		
		textEstado = new JTextField();
		textEstado.setBounds(214, 202, 161, 20);
		add(textEstado);
		textEstado.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 233, 46, 14);
		add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setBounds(10, 258, 161, 20);
		add(textCidade);
		textCidade.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long cnpj=Long.parseLong(textCNPJ.getText());
				String nome=textNome.getText();
				String nomeFantasia=textNomeFantasia.getText();
				String pais = textPais.getText();
				String estado = textEstado.getText();
				String cidade = textCidade.getText();
				String rua=textRua.getText();
				String bairro=textBairro.getText();
				int cep=Integer.parseInt(textCEP.getText());
				short numeroDoImovel=Short.parseShort(textNumeroDoImovel.getText());
				short ddd = Short.parseShort(textDdd.getText());
				short ddi = Short.parseShort(textDdi.getText());
				int numeroTelefone = Integer.parseInt(textNumeroTelefone.getText());
				
				Fornecedor fornecedor=new Fornecedor(cnpj, nome, nomeFantasia, pais, estado, cidade, rua, bairro, cep, numeroDoImovel, ddd, ddi, numeroTelefone);
				repositorio.add(fornecedor);
			}
		});
		btnAdicionar.setBounds(692, 458, 98, 23);
		add(btnAdicionar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorFornecedor.menuFornecedor();
			}
		});
		btnCancelar.setBounds(584, 458, 98, 23);
		add(btnCancelar);
				
		
	}
}
