package view.Usuario;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Usuario;

public class DadosUsuario extends JPanel {
	protected JTextField textCpf;
	protected JTextField textNome;
	protected JTextField textSobrenome;
	protected JTextField textNomeUsuario;
	protected JTextField textPais;
	protected JTextField textEstado;
	protected JTextField textCidade;
	protected JTextField textRua;
	protected JTextField textBairro;
	protected JTextField textCep;
	protected JTextField textNumeroResidencia;
	protected JTextField textDdi;
	protected JTextField textDdd;
	protected JTextField textTelefone;
	protected JLabel lblSenha;
	protected JTextField textSenha;

	public DadosUsuario() {
		setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 11, 46, 14);
		add(lblCpf);
		
		textCpf = new JTextField();
		textCpf.setBounds(10, 36, 365, 20);
		add(textCpf);
		textCpf.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 67, 46, 14);
		add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(10, 92, 365, 20);
		add(textNome);
		textNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setBounds(10, 123, 109, 14);
		add(lblSobrenome);
		
		textSobrenome = new JTextField();
		textSobrenome.setBounds(10, 148, 365, 20);
		add(textSobrenome);
		textSobrenome.setColumns(10);
		
		JLabel lblNomeUsuario = new JLabel("Nome de Usu\u00E1rio");
		lblNomeUsuario.setBounds(10, 179, 137, 14);
		add(lblNomeUsuario);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(214, 179, 46, 14);
		add(lblSenha);
		
		textSenha = new JTextField();
		textSenha.setBounds(214, 204, 161, 20);
		add(textSenha);
		textSenha.setColumns(10);
		
		textNomeUsuario = new JTextField();
		textNomeUsuario.setBounds(10, 204, 161, 20);
		add(textNomeUsuario);
		textNomeUsuario.setColumns(10);
		
		JLabel lblPais = new JLabel("Pa\u00EDs");
		lblPais.setBounds(10, 235, 46, 14);
		add(lblPais);
		
		textPais = new JTextField();
		textPais.setBounds(10, 260, 161, 20);
		add(textPais);
		textPais.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(214, 235, 46, 14);
		add(lblEstado);
		
		textEstado = new JTextField();
		textEstado.setBounds(214, 260, 161, 20);
		add(textEstado);
		textEstado.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 291, 46, 14);
		add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setBounds(10, 316, 161, 20);
		add(textCidade);
		textCidade.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(10, 347, 46, 14);
		add(lblRua);
		
		textRua = new JTextField();
		textRua.setBounds(10, 372, 161, 20);
		add(textRua);
		textRua.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(214, 291, 46, 14);
		add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setBounds(214, 316, 161, 20);
		add(textBairro);
		textBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(10, 403, 46, 14);
		add(lblCep);
		
		textCep = new JTextField();
		textCep.setBounds(10, 428, 161, 20);
		add(textCep);
		textCep.setColumns(10);
		
		JLabel lblNumeroResidencia = new JLabel("N\u00FAmero da Resid\u00EAncia");
		lblNumeroResidencia.setBounds(214, 347, 198, 14);
		add(lblNumeroResidencia);
		
		textNumeroResidencia = new JTextField();
		textNumeroResidencia.setBounds(214, 372, 161, 20);
		add(textNumeroResidencia);
		textNumeroResidencia.setColumns(10);
		
		JLabel lblDdi = new JLabel("DDI");
		lblDdi.setBounds(433, 11, 46, 14);
		add(lblDdi);
		
		textDdi = new JTextField();
		textDdi.setBounds(433, 36, 161, 20);
		add(textDdi);
		textDdi.setColumns(10);
		
		JLabel lblDdd = new JLabel("DDD");
		lblDdd.setBounds(635, 11, 46, 14);
		add(lblDdd);
		
		textDdd = new JTextField();
		textDdd.setBounds(635, 36, 161, 20);
		add(textDdd);
		textDdd.setColumns(10);
		
		JLabel lblTelefone = new JLabel("N\u00FAmero de Telefone");
		lblTelefone.setBounds(433, 67, 198, 14);
		add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(433, 92, 161, 20);
		add(textTelefone);
		textTelefone.setColumns(10);
	}
	
	public DadosUsuario(Usuario usuario, boolean exibicao) {
		this();
		
		if(usuario == null) {
			throw new IllegalArgumentException("Usuário não pode ser nulo nesse método.");
		}
		
		if(exibicao) {
			textCpf.setEditable(false);
			textNome.setEditable(false);
			textSobrenome.setEditable(false);
			textNomeUsuario.setEditable(false);
			textSenha.setEditable(false);
			textPais.setEditable(false);
			textEstado.setEditable(false);
			textCidade.setEditable(false);
			textRua.setEditable(false);
			textBairro.setEditable(false);
			textCep.setEditable(false);
			textNumeroResidencia.setEditable(false);
			textDdi.setEditable(false);
			textDdd.setEditable(false);
			textTelefone.setEditable(false);
		} else { // set editable false para nao editaveis
			textCpf.setEditable(false);
		}
		
		textCpf.setText(Long.toString(usuario.getCpf()));
		textNome.setText(usuario.getNome());
		textSobrenome.setText(usuario.getSobrenome());
		textNomeUsuario.setText(usuario.getNomeDeUsuario());
		textSenha.setText(usuario.getSenha());
		textPais.setText(usuario.getPais());
		textEstado.setText(usuario.getEstado());
		textCidade.setText(usuario.getCidade());
		textRua.setText(usuario.getRua());
		textBairro.setText(usuario.getBairro());
		textCep.setText(Integer.toString(usuario.getCep()));
		textNumeroResidencia.setText(Integer.toString(usuario.getNumeroDaResidencia()));
		textDdi.setText(Byte.toString(usuario.getDdi()));
		textDdd.setText(Byte.toString(usuario.getDdd()));
		textTelefone.setText(Integer.toString(usuario.getTelefone()));
	}

}
