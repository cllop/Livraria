package view.Usuario;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DadoCpf extends JPanel {
	private JTextField textCpf;

	public DadoCpf() {
		setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 11, 46, 14);
		add(lblCpf);
		
		textCpf = new JTextField();
		textCpf.setBounds(10, 36, 430, 20);
		add(textCpf);
		textCpf.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnConfirmar.setBounds(351, 266, 89, 23);
		add(btnConfirmar);

	}
}
