package view.PlanoVip;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AssinarPlanoVip extends JPanel {
	private JTextField tfNomeDoPlano;
	private JTextField tfDataDeInicio;
	private JTextField tfTipoDePlano;

	/**
	 * Create the panel.
	 */
	public AssinarPlanoVip() {
		setLayout(null);
		
		JLabel lblNomeDoPlano = new JLabel("Nome do Plano");
		lblNomeDoPlano.setBounds(10, 11, 125, 14);
		add(lblNomeDoPlano);
		
		tfNomeDoPlano = new JTextField();
		tfNomeDoPlano.setBounds(10, 36, 143, 20);
		add(tfNomeDoPlano);
		tfNomeDoPlano.setColumns(10);
		
		JLabel lblDataDeInicio = new JLabel("Data de Inicio");
		lblDataDeInicio.setBounds(10, 67, 107, 14);
		add(lblDataDeInicio);
		
		tfDataDeInicio = new JTextField();
		tfDataDeInicio.setBounds(10, 92, 143, 20);
		add(tfDataDeInicio);
		tfDataDeInicio.setColumns(10);
		
		tfTipoDePlano = new JTextField();
		tfTipoDePlano.setBounds(10, 148, 143, 20);
		add(tfTipoDePlano);
		tfTipoDePlano.setColumns(10);
		
		JLabel lblTipoDePlano = new JLabel("Tipo de Plano");
		lblTipoDePlano.setBounds(10, 123, 107, 14);
		add(lblTipoDePlano);
		
		JButton btnConcluido = new JButton("Concluido");
		btnConcluido.setBounds(351, 266, 89, 23);
		add(btnConcluido);

	}
}
