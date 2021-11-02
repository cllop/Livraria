package view.Setor;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdicionarSetor extends JPanel {
	private JTextField tfNomeSetor;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AdicionarSetor() {
		setBackground(new Color(0, 102, 102));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 79, 123, 14);
		add(lblNewLabel);
		
		tfNomeSetor = new JTextField();
		tfNomeSetor.setBounds(10, 104, 167, 20);
		add(tfNomeSetor);
		tfNomeSetor.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 25, 46, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 48, 167, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(351, 266, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(252, 266, 89, 23);
		add(btnNewButton_1);

	}
}
