package view.GerenciadorCaixa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Caixa;
import repository.RepositorioCaixa;
import javax.swing.JPasswordField;

public class AdicionarCaixa extends JPanel {
	private JTextField tfCPF;
	private JTextField tfNome;
	private JTextField tfSobrenome;
	private JTextField tfCEP;
	private JTextField tfBairro;
	private JTextField tfRua;
	private JTextField tfNumeroDaResidencia;
	private JTextField tfNomeDeUsuario;
	private JTextField tfDDI;
	private JTextField tfDDD;
	private JTextField tfTelefone;
	private JPasswordField pfSenha;

	/**
	 * Create the panel.
	 */
	public AdicionarCaixa(GerenciadorCaixa gerenciadorCaixa, RepositorioCaixa repositorio) {
		setLayout(null);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(10, 11, 113, 14);
		add(lblCPF);
		
		tfCPF = new JTextField();
		tfCPF.setBounds(10, 36, 238, 20);
		add(tfCPF);
		tfCPF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 67, 113, 14);
		add(lblNewLabel);
		
		tfNome = new JTextField();
		tfNome.setBounds(10, 89, 238, 20);
		add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Sobrenome");
		lblNewLabel_1.setBounds(10, 120, 113, 14);
		add(lblNewLabel_1);
		
		tfSobrenome = new JTextField();
		tfSobrenome.setBounds(10, 145, 238, 20);
		add(tfSobrenome);
		tfSobrenome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CEP");
		lblNewLabel_2.setBounds(10, 289, 113, 14);
		add(lblNewLabel_2);
		
		tfCEP = new JTextField();
		tfCEP.setBounds(10, 314, 238, 20);
		add(tfCEP);
		tfCEP.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Bairro");
		lblNewLabel_3.setBounds(10, 345, 103, 14);
		add(lblNewLabel_3);
		
		tfBairro = new JTextField();
		tfBairro.setBounds(10, 370, 238, 20);
		add(tfBairro);
		tfBairro.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Rua");
		lblNewLabel_4.setBounds(284, 11, 103, 14);
		add(lblNewLabel_4);
		
		tfRua = new JTextField();
		tfRua.setBounds(284, 36, 238, 20);
		add(tfRua);
		tfRua.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Numero da resid\u00EAncia");
		lblNewLabel_5.setBounds(284, 67, 103, 14);
		add(lblNewLabel_5);
		
		tfNumeroDaResidencia = new JTextField();
		tfNumeroDaResidencia.setBounds(284, 89, 238, 20);
		add(tfNumeroDaResidencia);
		tfNumeroDaResidencia.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Nome de usuario");
		lblNewLabel_6.setBounds(10, 176, 113, 14);
		add(lblNewLabel_6);
		
		tfNomeDeUsuario = new JTextField();
		tfNomeDeUsuario.setBounds(10, 201, 238, 20);
		add(tfNomeDeUsuario);
		tfNomeDeUsuario.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("DDI");
		lblNewLabel_7.setBounds(284, 120, 103, 14);
		add(lblNewLabel_7);
		
		tfDDI = new JTextField();
		tfDDI.setBounds(284, 145, 238, 20);
		add(tfDDI);
		tfDDI.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("DDD");
		lblNewLabel_8.setBounds(284, 176, 103, 14);
		add(lblNewLabel_8);
		
		tfDDD = new JTextField();
		tfDDD.setBounds(284, 201, 238, 20);
		add(tfDDD);
		tfDDD.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Telefone");
		lblNewLabel_9.setBounds(284, 230, 208, 14);
		add(lblNewLabel_9);
		
		tfTelefone = new JTextField();
		tfTelefone.setBounds(284, 255, 238, 20);
		add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long cpf = Long.parseLong(tfCPF.getText());
				String nome = tfNome.getText();
				String sobrenome = tfSobrenome.getText();
				String nomeDeUsuario = tfNomeDeUsuario.getText();
				String senha = pfSenha.getText();
				String pais = tfPais.getText();
				String estado = tfEstado.getText();
				String cidade = tfCidade.getText();
				String rua = tfRua.getText();
				String bairro = tfBairro.getText();
				int cep = Long.parseLong(tfCEP.getText());
				short numeroDaResidencia = Short.parseShort(tfNumeroDaResidencia.getText());
				byte ddi = Byte.parseByte(tfDDI.getText());
				byte ddd = Byte.parseByte(tfDDD.getText());
				int telefone = Integer.parseInt(tfTelefone.getText());
				boolean ativo;
//				 String pais,String estado, String cidade, String rua, String bairro, int cep, short numeroDaResidencia, byte ddi,byte ddd, int telefone, boolean ativo
				
				Caixa caixa = new Caixa(cpf, nome, sobrenome, nomeDeUsuario, cep, bairro, rua, numeroDaResidencia, ddi, ddd, telefone);
				repositorio.add(caixa);
				}
		});
		btnAdicionar.setBounds(650, 400, 89, 23);
		add(btnAdicionar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancelar.setBounds(551, 400, 89, 23);
		add(btnCancelar);
		
		JLabel lblNewLabel_10 = new JLabel("Senha");
		lblNewLabel_10.setBounds(10, 232, 46, 14);
		add(lblNewLabel_10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(10, 255, 238, 20);
		add(pfSenha);

	}
}
