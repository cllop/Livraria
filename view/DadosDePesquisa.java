package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DadosDePesquisa extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public DadosDePesquisa() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(10, 11, 46, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 28, 161, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 59, 46, 14);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 84, 262, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar por Nome");
		btnNewButton.setBounds(282, 83, 158, 23);
		add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Pesquisar por Id");
		btnNewButton_3.setBounds(282, 27, 158, 23);
		add(btnNewButton_3);

	}
}
