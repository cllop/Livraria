package view.venda;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class ConfirmarVenda extends JPanel {

	/**
	 * Create the panel.
	 */
	public ConfirmarVenda() {
		setBackground(new Color(0, 102, 102));
		setLayout(null);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(106, 178, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Confirmar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(300, 178, 89, 23);
		add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("ATEN\u00C7\u00C3O!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(220, 52, 83, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Voc\u00EA tem certeza que deseja finalizar a venda?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(106, 89, 300, 14);
		add(lblNewLabel_1);

	}

}
