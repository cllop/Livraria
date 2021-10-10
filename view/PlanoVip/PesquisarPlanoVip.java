package view.PlanoVip;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PesquisarPlanoVip extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PesquisarPlanoVip() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipos de Plano");
		lblNewLabel.setBounds(10, 11, 109, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 221, 20);
		add(textField);
		textField.setColumns(10);

	}

}
