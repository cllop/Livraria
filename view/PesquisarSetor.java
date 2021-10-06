package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PesquisarSetor extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PesquisarSetor() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do Setor");
		lblNewLabel.setBounds(10, 11, 126, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 156, 20);
		add(textField);
		textField.setColumns(10);

	}
}
