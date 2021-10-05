package view.produto;

import javax.swing.JPanel;

import view.DadosDePesquisa;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DadosDePesquisaDeLivro extends DadosDePesquisa {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public DadosDePesquisaDeLivro() {
		
		JLabel lblNewLabel = new JLabel("Nome do Autor");
		lblNewLabel.setBounds(10, 110, 92, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 130, 262, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Categoria");
		lblNewLabel_1.setBounds(10, 157, 116, 14);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 174, 262, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar por Nome");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(282, 80, 158, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pesquisar por Autor");
		btnNewButton_1.setBounds(282, 129, 158, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Pesquisar por Categoria");
		btnNewButton_2.setBounds(282, 173, 158, 23);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Pesquisar por Id");
		btnNewButton_3.setBounds(282, 27, 158, 23);
		add(btnNewButton_3);

	}

}
