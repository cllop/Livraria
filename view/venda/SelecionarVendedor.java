package view.venda;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class SelecionarVendedor extends JPanel {
	private JTextField tfCodigoVendedor;

	/**
	 * Create the panel.
	 */
	public SelecionarVendedor() {
		setBackground(new Color(0, 102, 102));
		setLayout(null);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIniciar.setBounds(459, 325, 89, 23);
		add(btnIniciar);
		
		JButton btnIniciarVendaSemVendedor = new JButton("Iniciar venda sem vendedor");
		btnIniciarVendaSemVendedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIniciarVendaSemVendedor.setBounds(252, 325, 197, 23);
		add(btnIniciarVendaSemVendedor);
		
		JLabel lblNewLabel = new JLabel("Iniciar venda com este vendedor(insira o codigo):");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(140, 95, 314, 14);
		add(lblNewLabel);
		
		tfCodigoVendedor = new JTextField();
		tfCodigoVendedor.setBounds(140, 140, 309, 20);
		add(tfCodigoVendedor);
		tfCodigoVendedor.setColumns(10);

	}

}
