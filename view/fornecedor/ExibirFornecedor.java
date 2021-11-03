package view.fornecedor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Fornecedor;

public class ExibirFornecedor extends JPanel {
	private JTextField textCnpj;
	private JTextField textNome;
	private JTextField textRua;
	private JTextField textBairro;
	private JTextField textCep;
	private JTextField textNumeroDoImovel;
	private Fornecedor fornecedor;
	private JTextField textId;
	private JTextField textNomeFantasia;
	private JTextField textDdi;
	private JTextField textDdd;
	private JTextField textNumeroTelefone;
	private JTextField textPais;
	private JTextField textEstado;
	private JTextField textCidade;

	public ExibirFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
		setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 117, 46, 14);
		add(lblNome);

		textCnpj = new JTextField();
		textCnpj.setEditable(false);
		textCnpj.setBounds(10, 36, 365, 20);
		add(textCnpj);
		textCnpj.setColumns(10);

		JLabel lblCNPJ = new JLabel("CNPJ");
		lblCNPJ.setBounds(10, 11, 46, 14);
		add(lblCNPJ);

		textNome = new JTextField();
		textNome.setEditable(false);
		textNome.setBounds(10, 142, 365, 20);
		add(textNome);
		textNome.setColumns(10);

		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(10, 335, 46, 14);
		add(lblRua);

		textRua = new JTextField();
		textRua.setEditable(false);
		textRua.setBounds(10, 360, 365, 20);
		add(textRua);
		textRua.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(214, 280, 46, 14);
		add(lblBairro);

		textBairro = new JTextField();
		textBairro.setEditable(false);
		textBairro.setBounds(214, 305, 161, 20);
		add(textBairro);
		textBairro.setColumns(10);

		textCep = new JTextField();
		textCep.setEditable(false);
		textCep.setBounds(10, 416, 161, 20);
		add(textCep);
		textCep.setColumns(10);

		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(10, 391, 46, 14);
		add(lblCEP);

		JLabel lblNumeroDoImovel = new JLabel("N\u00FAmero do Im\u00F3vel");
		lblNumeroDoImovel.setBounds(214, 391, 109, 14);
		add(lblNumeroDoImovel);

		textNumeroDoImovel = new JTextField();
		textNumeroDoImovel.setEditable(false);
		textNumeroDoImovel.setBounds(214, 416, 161, 20);
		add(textNumeroDoImovel);
		textNumeroDoImovel.setColumns(10);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 67, 46, 14);
		add(lblId);

		textId = new JTextField();
		textId.setEditable(false);
		textId.setBounds(10, 86, 365, 20);
		add(textId);
		textId.setColumns(10);

		JLabel lblNomeFantasia = new JLabel("Nome Fant\u00E1sia");
		lblNomeFantasia.setBounds(10, 173, 81, 14);
		add(lblNomeFantasia);

		textNomeFantasia = new JTextField();
		textNomeFantasia.setEditable(false);
		textNomeFantasia.setBounds(10, 193, 365, 20);
		add(textNomeFantasia);
		textNomeFantasia.setColumns(10);

		JLabel lblDdi = new JLabel("DDI");
		lblDdi.setBounds(629, 11, 46, 14);
		add(lblDdi);

		textDdi = new JTextField();
		textDdi.setEditable(false);
		textDdi.setBounds(629, 36, 161, 20);
		add(textDdi);
		textDdi.setColumns(10);

		JLabel lblDdd = new JLabel("DDD");
		lblDdd.setBounds(425, 11, 46, 14);
		add(lblDdd);

		textDdd = new JTextField();
		textDdd.setEditable(false);
		textDdd.setBounds(425, 36, 161, 20);
		add(textDdd);
		textDdd.setColumns(10);

		JLabel lblNumeroTelefone = new JLabel("N\u00FAmero de Telefone");
		lblNumeroTelefone.setBounds(425, 67, 161, 14);
		add(lblNumeroTelefone);

		textNumeroTelefone = new JTextField();
		textNumeroTelefone.setEditable(false);
		textNumeroTelefone.setBounds(425, 86, 365, 20);
		add(textNumeroTelefone);
		textNumeroTelefone.setColumns(10);

		JLabel lblPais = new JLabel("Pa\u00EDs");
		lblPais.setBounds(10, 224, 46, 14);
		add(lblPais);

		textPais = new JTextField();
		textPais.setEditable(false);
		textPais.setBounds(10, 249, 161, 20);
		add(textPais);
		textPais.setColumns(10);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(214, 224, 46, 14);
		add(lblEstado);

		textEstado = new JTextField();
		textEstado.setEditable(false);
		textEstado.setBounds(214, 249, 161, 20);
		add(textEstado);
		textEstado.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 280, 46, 14);
		add(lblCidade);

		textCidade = new JTextField();
		textCidade.setEditable(false);
		textCidade.setBounds(10, 305, 161, 20);
		add(textCidade);
		textCidade.setColumns(10);

		textId.setText(Integer.toString(fornecedor.getId()));
		textCnpj.setText(Long.toString(fornecedor.getCnpj()));
		textNome.setText(fornecedor.getNome());
		textNomeFantasia.setText(fornecedor.getNomeFantasia());
		textPais.setText(fornecedor.getPais());
		textEstado.setText(fornecedor.getEstado());
		textCidade.setText(fornecedor.getCidade());
		textRua.setText(fornecedor.getRua());
		textBairro.setText(fornecedor.getBairro());
		textCep.setText(Integer.toString(fornecedor.getCep()));
		textNumeroDoImovel.setText(Integer.toString(fornecedor.getNumeroDoImovel()));
		textDdd.setText(Short.toString(fornecedor.getDdd()));
		textDdi.setText(Short.toString(fornecedor.getDdi()));
		textNumeroTelefone.setText(Integer.toString(fornecedor.getNumeroTelefone()));
	}

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void habilitarCamposEditaveis() {
		textNome.setEditable(true);
		textNomeFantasia.setEditable(true);
		textPais.setEditable(true);
		textEstado.setEditable(true);
		textCidade.setEditable(true);
		textBairro.setEditable(true);
		textRua.setEditable(true);
		textCep.setEditable(true);
		textNumeroDoImovel.setEditable(true);
		textDdd.setEditable(true);
		textDdi.setEditable(true);
		textNumeroTelefone.setEditable(true);
	}

	public Fornecedor lerCamposDigitadosPeloUsuario() {
		return new Fornecedor(Integer.parseInt(textId.getText()), Long.parseLong(textCnpj.getText()),
				textNome.getText(), textNomeFantasia.getText(), textPais.getText(), textEstado.getText(),
				textCidade.getText(), textRua.getText(), textBairro.getText(), Integer.parseInt(textCep.getText()),
				Short.parseShort(textNumeroDoImovel.getText()), Short.parseShort(textDdd.getText()),
				Short.parseShort(textDdi.getText()), Integer.parseInt(textNumeroTelefone.getText()));
	}
}
