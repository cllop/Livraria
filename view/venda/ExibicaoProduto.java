package view.venda;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.Border;

import modelo.Produto;

public class ExibicaoProduto extends JPanel {
	private JTextPane textConteudoDescricao;
	private JTextPane textConteudoNome;

	/**
	 * Create the panel.
	 */
	public ExibicaoProduto() {
		setBackground(new Color(0, 102, 102));
		setLayout(null);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescricao.setBounds(10, 73, 71, 20);
		add(lblDescricao);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(10, 11, 58, 20);
		add(lblNome);
	    
	    textConteudoDescricao = new JTextPane();
	    textConteudoDescricao.setEditable(false);
	    textConteudoDescricao.setFont(new Font("Tahoma", Font.BOLD, 10));
	    textConteudoDescricao.setEnabled(false);
	    textConteudoDescricao.setBounds(89, 72, 214, 135);
	    add(textConteudoDescricao);
	    
	    textConteudoNome = new JTextPane();
	    textConteudoNome.setEditable(false);
	    textConteudoNome.setFont(new Font("Tahoma", Font.BOLD, 10));
	    textConteudoNome.setEnabled(false);
	    textConteudoNome.setBounds(89, 11, 214, 40);
	    add(textConteudoNome);
	    
	    Border borda = BorderFactory.createLineBorder(Color.BLACK, 1);
	    this.setBorder(borda);

	}
	
	public void exibirProduto(Produto produto) {
		this.textConteudoDescricao.setText(produto.getDescricao());
		this.textConteudoNome.setText(produto.getNome());
	}
}
