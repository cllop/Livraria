package view.venda;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Venda;
import repository.RepositorioVenda;
import view.GerenciadorPrincipal;

public class TelaPagamentoEmDinheiro extends JPanel {
	private JTextField tfValor;

	/**
	 * Create the panel.
	 */
	public TelaPagamentoEmDinheiro(GerenciadorPrincipal gerenciadorPrincipal, Venda venda, RepositorioVenda repositorioVenda) {
		setBackground(new Color(0, 102, 102));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Valor(R$):");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(22, 31, 86, 14);
		add(lblNewLabel);
		
		tfValor = new JTextField();
		tfValor.setBounds(22, 51, 151, 20);
		add(tfValor);
		tfValor.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar pagamento");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(venda.estaCompletamentePaga()) {
					try {
						repositorioVenda.salvarVenda(venda);
						
						gerenciadorPrincipal.pagamentoRealizado(venda);
					}catch(Exception ex){
						throw new UnsupportedOperationException(ex);
						
					}
				}else {
					throw new UnsupportedOperationException();
				}
				
			}
		});
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(255, 255, 171, 23);
		add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(156, 255, 89, 23);
		add(btnCancelar);

	}
}
