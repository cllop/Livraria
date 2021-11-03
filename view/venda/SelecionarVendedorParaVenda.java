package view.venda;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Vendedor;
import repository.RepositorioCliente;
import repository.RepositorioVendedor;
import view.GerenciadorPrincipal;

public class SelecionarVendedorParaVenda extends JPanel {
	private JTextField tfCodigoVendedor;

	/**
	 * Create the panel.
	 */
	public SelecionarVendedorParaVenda(GerenciadorPrincipal gerenciadorPrincipal ,RepositorioVendedor repositorio, RepositorioCliente repositorioCliente) {
		setBackground(new Color(0, 102, 102));
		setLayout(null);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idVendedor = Integer.parseInt(tfCodigoVendedor.getText());
				try { 
					Vendedor vendedor = repositorio.find(idVendedor);
					JanelaSelecionarCliente selecionarCliente = new JanelaSelecionarCliente(gerenciadorPrincipal, vendedor, repositorioCliente);
					gerenciadorPrincipal.esperarParaClienteInserirDados(vendedor);
					
				}catch(Exception ex){
					JOptionPane.showMessageDialog(btnIniciar, "Vendedor não encontrado. ");
					
				}
			}
		});
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
