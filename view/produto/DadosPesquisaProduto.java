package view.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Produto;
import repository.RepositorioProduto;
import view.DadosPesquisa;
import view.GerenciadorPrincipal;
import java.awt.Color;
import javax.swing.SwingConstants;



public class DadosPesquisaProduto extends DadosPesquisa {
	
	DadosPesquisaProduto essaPesquisa = this;
	
	public DadosPesquisaProduto(GerenciadorPrincipal gerenciador,RepositorioProduto repositorio) {
		
		JLabel lblMenssage = new JLabel("");
		lblMenssage.setForeground(Color.RED);
		lblMenssage.setBackground(Color.BLACK);
		lblMenssage.setBounds(10, 130, 158, 23);
		add(lblMenssage);
		btnPesquisarPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String nome;
					nome = tfNome.getText();
					Produto p;
					
					try {
						p = repositorio.findByNome(nome);
						gerenciador.exibirProduto(p);
						
					}catch (Exception es) {
						lblMenssage.setText("Produto nâo encontrado");
					}
		
			}
	
		});
		super.btnPesquisarPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				id= Integer.parseInt(tfId.getText());
				Produto p;
				try {
					p = repositorio.find(id);
					gerenciador.exibirProduto(p);
					
				}catch (Exception es) {
					lblMenssage.setText("Produto nâo encontrado");
				}
			}
		});
		
		
	}
}
