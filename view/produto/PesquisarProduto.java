//package view.produto;
//
//import java.util.List;
//
//import javax.swing.JPanel;
//
//import modelo.Produto;
//import repository.RepositorioProdutoAndLivro;
//import view.GerenciadorPrincipal;
//
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//
//public class PesquisarProduto extends JPanel {
//	private JTextField tfId;
//
//	/**
//	 * Create the panel.
//	 */
//	public PesquisarProduto(GerenciadorProduto gerenciadorProduto,RepositorioProdutoAndLivro repositorio) {
//		setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("Id");
//		lblNewLabel.setBounds(10, 11, 46, 14);
//		add(lblNewLabel);
//		
//		tfId = new JTextField();
//		tfId.setBounds(10, 36, 110, 20);
//		add(tfId);
//		tfId.setColumns(10);
//		
//		JButton btnPesquisar = new JButton("Pesquisar");
//		btnPesquisar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int id;
//				
//				id = Integer.parseInt(tfId.getText());
//				
//				Produto p =repositorio.find(id);
//				
//				gerenciadorProduto.exibirProduto(p);
//				
//			}
//		});
//		btnPesquisar.setBounds(200, 35, 100, 23);
//		add(btnPesquisar);
//		
//
//	}
//}
