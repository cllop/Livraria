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
	private Fornecedor fornecedor;
	private JTextField textId;
	private JTextField textNomeFantasia;
	private JTextField textDdi;
	private JTextField textDdd;
	private JTextField textNumeroTelefone;

	public ExibirFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
		setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 117, 46, 14);
		add(lblNome);

		textCNPJ = new JTextField();
		textCNPJ.setEditable(false);
		textCNPJ.setBounds(10, 36, 365, 20);
		add(textCNPJ);
		textCNPJ.setColumns(10);

		JLabel lblCNPJ = new JLabel("CNPJ");
		lblCNPJ.setBounds(10, 11, 46, 14);
		add(lblCNPJ);

		textNome = new JTextField();
		textNome.setEditable(false);
		textNome.setBounds(10, 142, 365, 20);
		add(textNome);
		textNome.setColumns(10);

		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(10, 224, 46, 14);
		add(lblRua);

		textRua = new JTextField();
		textRua.setEditable(false);
		textRua.setBounds(10, 249, 365, 20);
		add(textRua);
		textRua.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 280, 46, 14);
		add(lblBairro);

		textBairro = new JTextField();
		textBairro.setEditable(false);
		textBairro.setBounds(10, 305, 365, 20);
		add(textBairro);
		textBairro.setColumns(10);

		textCEP = new JTextField();
		textCEP.setEditable(false);
		textCEP.setBounds(10, 361, 365, 20);
		add(textCEP);
		textCEP.setColumns(10);

		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(10, 336, 46, 14);
		add(lblCEP);

		JLabel lblNumeroDoImovel = new JLabel("N\u00FAmero do Im\u00F3vel");
		lblNumeroDoImovel.setBounds(10, 392, 109, 14);
		add(lblNumeroDoImovel);

		textNumeroDoImovel = new JTextField();
		textNumeroDoImovel.setEditable(false);
		textNumeroDoImovel.setBounds(10, 417, 365, 20);
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
		lblDdi.setBounds(425, 67, 46, 14);
		add(lblDdi);

		textDdi = new JTextField();
		textDdi.setEditable(false);
		textDdi.setBounds(425, 86, 365, 20);
		add(textDdi);
		textDdi.setColumns(10);

		JLabel lblDdd = new JLabel("DDD");
		lblDdd.setBounds(425, 11, 46, 14);
		add(lblDdd);

		textDdd = new JTextField();
		textDdd.setEditable(false);
		textDdd.setBounds(425, 36, 365, 20);
		add(textDdd);
		textDdd.setColumns(10);

		JLabel lblNumeroTelefone = new JLabel("N\u00FAmero de Telefone");
		lblNumeroTelefone.setBounds(425, 123, 119, 14);
		add(lblNumeroTelefone);

		textNumeroTelefone = new JTextField();
		textNumeroTelefone.setEditable(false);
		textNumeroTelefone.setBounds(425, 142, 365, 20);
		add(textNumeroTelefone);
		textNumeroTelefone.setColumns(10);

		textId.setText(Integer.toString(fornecedor.getId()));
		textCNPJ.setText(Long.toString(fornecedor.getCnpj()));
		textNome.setText(fornecedor.getNome());
		textNomeFantasia.setText(fornecedor.getNomeFantasia());
		textRua.setText(fornecedor.getRua());
		textBairro.setText(fornecedor.getBairro());
		textCEP.setText(Integer.toString(fornecedor.getCep()));
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
		textBairro.setEditable(true);
		textRua.setEditable(true);
		textCEP.setEditable(true);
		textNumeroDoImovel.setEditable(true);
		textDdd.setEditable(true);
		textDdi.setEditable(true);
		textNumeroTelefone.setEditable(true);
	}

	public Fornecedor lerCamposDigitadosPeloUsuario() {
		return new Fornecedor(Integer.parseInt(textId.getText()), Long.parseLong(textCNPJ.getText()),
				textNome.getText(), textNomeFantasia.getText(), textRua.getText(), textBairro.getText(),
				Integer.parseInt(textCEP.getText()), Short.parseShort(textNumeroDoImovel.getText()),
				Short.parseShort(textDdd.getText()), Short.parseShort(textDdi.getText()), Integer.parseInt(textNumeroTelefone.getText()));
	}
}
