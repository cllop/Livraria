package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DadosPesquisa extends JPanel {
	protected JTextField tfId;
	protected JTextField tfNome;
	protected JButton btnPesquisarPorId;
	protected JButton btnPesquisarPorNome;
 
	/**
	 * Create the panel.
	 */
	public DadosPesquisa() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(10, 11, 46, 14);
		add(lblNewLabel);
		
		tfId = new JTextField();
		tfId.setBounds(10, 28, 161, 20);
		add(tfId);
		tfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 59, 46, 14);
		add(lblNewLabel_1);
		
		tfNome = new JTextField();
		tfNome.setBounds(10, 84, 262, 20);
		add(tfNome);
		tfNome.setColumns(10);
		
		this.btnPesquisarPorNome = new JButton("Pesquisar por Nome");
		this.btnPesquisarPorNome.setBounds(282, 83, 158, 23);
		add(this.btnPesquisarPorNome);
		
		this.btnPesquisarPorId= new JButton("Pesquisar por Id");
		this.btnPesquisarPorId.setBounds(282, 27, 158, 23);
		add(this.btnPesquisarPorId);

	}
}
