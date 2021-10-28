package view.Venda;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Venda;
import view.GerenciadorPrincipal;

public class TelaPagamentoRealizado extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaPagamentoRealizado(GerenciadorPrincipal gerenciadorPrincipal, Venda venda) {
		setBackground(new Color(0, 102, 102));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pagamento realizado com sucesso");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(154, 32, 246, 14);
		add(lblNewLabel);
		
		JPanel DadosDaVendaEPagamento = new JPanel();
		DadosDaVendaEPagamento.setBackground(new Color(255, 0, 0));
		DadosDaVendaEPagamento.setBounds(34, 57, 442, 224);
		add(DadosDaVendaEPagamento);
		
		JLabel lblNewLabel_1 = new JLabel("Falta fazer");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		DadosDaVendaEPagamento.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Realizar nova venda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.iniciarVenda();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(311, 325, 165, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Estornar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(212, 325, 89, 23);
		add(btnNewButton_1);

	}
}
