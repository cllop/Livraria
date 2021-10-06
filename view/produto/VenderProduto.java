package view.produto;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VenderProduto extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public VenderProduto() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do Produto");
		lblNewLabel.setBounds(10, 11, 97, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 32, 165, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pre\u00E7o");
		lblNewLabel_1.setBounds(10, 63, 46, 14);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 88, 138, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade");
		lblNewLabel_2.setBounds(10, 119, 86, 14);
		add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 144, 138, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnComcluido = new JButton("Concluido");
		btnComcluido.setBounds(351, 266, 89, 23);
		add(btnComcluido);

	}
}
