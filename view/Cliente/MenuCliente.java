package view.Cliente;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class MenuCliente extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuCliente() {
		setBackground(new Color(0, 102, 102));
		setLayout(null);
		
		JButton btnNewButton = new JButton("Adicionar Cliente");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(10, 21, 159, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pesquisar Cliente");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(10, 55, 159, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Deletar Cliente");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(10, 89, 159, 23);
		add(btnNewButton_2);

	}
}
