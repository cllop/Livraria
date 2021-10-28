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

public class MetodoDePagamento extends JPanel {

	/**
	 * Create the panel.
	 */
	public MetodoDePagamento(GerenciadorPrincipal gerenciadorPrincipal, Venda venda) {
		setBackground(new Color(0, 102, 102));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escolha o m\u00E9todo de pagamento:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(126, 45, 206, 14);
		add(lblNewLabel);
		
		JButton btnPagamentoEmDinheiro = new JButton("Pagamento em dinheiro");
		btnPagamentoEmDinheiro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPagamentoEmDinheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorPrincipal.telaDePagamentoEmDinheiro(venda);
			}
		});
		btnPagamentoEmDinheiro.setBounds(126, 70, 206, 23);
		add(btnPagamentoEmDinheiro);
		
		JButton btnPagamentoEmCheque = new JButton("Pagamento em cheque");
		btnPagamentoEmCheque.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPagamentoEmCheque.setBounds(126, 104, 206, 23);
		add(btnPagamentoEmCheque);
		
		JButton btnPagamentoEmCartao = new JButton("Pagamento em cart\u00E3o");
		btnPagamentoEmCartao.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPagamentoEmCartao.setBounds(126, 138, 206, 23);
		add(btnPagamentoEmCartao);
		
		JLabel lblNewLabel_1 = new JLabel("Valor a ser pago: " + venda.getValorASerPago().toString());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(126, 195, 314, 14);
		add(lblNewLabel_1);

	}
}
