package view.produto;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PesquisarDeletarProduto extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public PesquisarDeletarProduto() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pesquisar Por Nome");
		lblNewLabel.setBounds(10, 83, 132, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 52, 186, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pesquisar Por Id");
		lblNewLabel_1.setBounds(10, 26, 130, 14);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 108, 186, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
	}
}
