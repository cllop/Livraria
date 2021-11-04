package view.Cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.Cliente;
import repository.RepositorioCliente;

public class TelaCadastrarCliente extends JPanel {
	private JTextField tfNome;
	private JTextField tfSobrenome;
	private JTextField tfNomeDeUsuario;
	private JPasswordField pfSenha;
	private JTextField tfPais;
	private JTextField tfEstado;
	private JTextField tfCidade;
	private JTextField tfRua;
	private JTextField tfBairro;
	private JTextField tfCEP;
	private JTextField tfNumeroDaResidencia;
	private JTextField tfDDI;
	private JTextField tfDDD;
	private JTextField tfTelefone;
	private JTextField tfCPF;

	public TelaCadastrarCliente(GerenciadorCliente gerenciadorCliente, RepositorioCliente repositorioCliente) {
		setBackground(new Color(0, 102, 102));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 60, 147, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sobrenome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 116, 147, 14);
		add(lblNewLabel_1);
		
		tfNome = new JTextField();
		tfNome.setBounds(10, 85, 235, 20);
		add(tfNome);
		tfNome.setColumns(10);
		
		tfSobrenome = new JTextField();
		tfSobrenome.setBounds(10, 141, 235, 20);
		add(tfSobrenome);
		tfSobrenome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome De Usuario:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 172, 147, 14);
		add(lblNewLabel_2);
		
		tfNomeDeUsuario = new JTextField();
		tfNomeDeUsuario.setBounds(10, 197, 235, 20);
		add(tfNomeDeUsuario);
		tfNomeDeUsuario.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Senha:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 228, 147, 14);
		add(lblNewLabel_3);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(10, 253, 235, 20);
		add(pfSenha);
		
		JLabel lblNewLabel_4 = new JLabel("Pa\u00EDs:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 284, 188, 14);
		add(lblNewLabel_4);
		
		tfPais = new JTextField();
		tfPais.setBounds(10, 309, 235, 20);
		add(tfPais);
		tfPais.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Estado:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 340, 46, 14);
		add(lblNewLabel_5);
		
		tfEstado = new JTextField();
		tfEstado.setBounds(10, 365, 235, 20);
		add(tfEstado);
		tfEstado.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Cidade:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 396, 147, 14);
		add(lblNewLabel_6);
		
		tfCidade = new JTextField();
		tfCidade.setBounds(10, 421, 235, 20);
		add(tfCidade);
		tfCidade.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Rua:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(262, 13, 71, 14);
		add(lblNewLabel_7);
		
		tfRua = new JTextField();
		tfRua.setBounds(262, 32, 235, 20);
		add(tfRua);
		tfRua.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Bairro:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(262, 60, 91, 14);
		add(lblNewLabel_8);
		
		tfBairro = new JTextField();
		tfBairro.setBounds(262, 85, 235, 20);
		add(tfBairro);
		tfBairro.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("CEP:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9.setBounds(262, 116, 91, 14);
		add(lblNewLabel_9);
		
		tfCEP = new JTextField();
		tfCEP.setBounds(262, 141, 235, 20);
		add(tfCEP);
		tfCEP.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Numero Da Resid\u00EAncia:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10.setBounds(262, 172, 211, 14);
		add(lblNewLabel_10);
		
		tfNumeroDaResidencia = new JTextField();
		tfNumeroDaResidencia.setBounds(262, 197, 235, 20);
		add(tfNumeroDaResidencia);
		tfNumeroDaResidencia.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("DDI:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_11.setBounds(262, 228, 46, 14);
		add(lblNewLabel_11);
		
		tfDDI = new JTextField();
		tfDDI.setBounds(262, 253, 235, 20);
		add(tfDDI);
		tfDDI.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("DDD:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_12.setBounds(262, 284, 46, 14);
		add(lblNewLabel_12);
		
		tfDDD = new JTextField();
		tfDDD.setBounds(262, 309, 235, 20);
		add(tfDDD);
		tfDDD.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Telefone:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_13.setBounds(262, 340, 71, 14);
		add(lblNewLabel_13);
		
		tfTelefone = new JTextField();
		tfTelefone.setBounds(262, 365, 235, 20);
		add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorCliente.menuCliente();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(294, 466, 91, 23);
		add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
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
				int cep = Integer.parseInt(tfCEP.getText());
				short numeroDaResidencia = Short.parseShort(tfNumeroDaResidencia.getText());
				byte ddi = Byte.parseByte(tfDDI.getText());
				byte ddd = Byte.parseByte(tfDDD.getText());
				int telefone = Integer.parseInt(tfTelefone.getText());
				
				Cliente cliente = new Cliente(cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi, ddd, telefone);
				repositorioCliente.add(cliente);
				
			}
		});
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(395, 466, 102, 23);
		add(btnConfirmar);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setBounds(10, 13, 147, 14);
		add(lblCpf);
		
		tfCPF = new JTextField();
		tfCPF.setBounds(10, 32, 235, 20);
		add(tfCPF);
		tfCPF.setColumns(10);

	}
}
