package view.produto;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ExibirProduto extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ExibirProduto() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setBounds(25, 44, 46, -19);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome ");
		lblNewLabel_1.setBounds(25, 11, 46, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(25, 35, 185, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pre\u00E7o");
		lblNewLabel_2.setBounds(227, 11, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_3.setBounds(25, 66, 46, 14);
		add(lblNewLabel_3);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(25, 98, 200, 50);
		add(textPane);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(227, 35, 202, 20);
		add(textField_1);
		textField_1.setColumns(10);

	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
