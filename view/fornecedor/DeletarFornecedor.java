package view.fornecedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Fornecedor;
import repository.RepositorioFornecedor;

public class DeletarFornecedor extends JPanel {
	private JTextField textCnpj;
	private ExibirFornecedor fornecedorSendoExibido;
	private JTextField textId;

	public DeletarFornecedor(GerenciadorFornecedor gerenciador, RepositorioFornecedor repositorio) {
		DeletarFornecedor esseDeletarFornecedor = this;
		setLayout(null);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(10, 11, 46, 14);
		add(lblCnpj);
		
		textCnpj = new JTextField();
		textCnpj.setBounds(10, 36, 331, 20);
		add(textCnpj);
		textCnpj.setColumns(10);
		
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setBounds(239, 39, 102, 14);
		add(lblMensagem);
		
		JButton btnBuscar = new JButton("Buscar");
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedor fornecedor = esseDeletarFornecedor.fornecedorSendoExibido.getFornecedor();
				
				try {
					repositorio.remove(fornecedor);
					JOptionPane.showMessageDialog(esseDeletarFornecedor, "Removido com sucesso!");
					gerenciador.menuFornecedor();
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(esseDeletarFornecedor, "Erro ao deletar.");
				}
			}
		}	
		);
		
		btnDeletar.setBounds(351, 35, 89, 23);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esseDeletarFornecedor.remove(esseDeletarFornecedor.fornecedorSendoExibido);
				esseDeletarFornecedor.remove(btnCancelar);
				esseDeletarFornecedor.add(btnBuscar);
				esseDeletarFornecedor.repaint();
			}
		}		
		);
		btnCancelar.setBounds(249, 35, 89, 23);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long cnpj = Long.parseLong(textCnpj.getText());
				Fornecedor fornecedor = repositorio.findByCnpj(cnpj);
				
				if(fornecedor == null) {
					lblMensagem.setText("Fornecedor não encontrado.");
				} else {
					lblMensagem.setText("");
					esseDeletarFornecedor.add(btnCancelar);
					
					ExibirFornecedor exibirFornecedor = new ExibirFornecedor(fornecedor);
									
					esseDeletarFornecedor.add(exibirFornecedor);
					exibirFornecedor.setBounds(0, 300, esseDeletarFornecedor.getWidth(), esseDeletarFornecedor.getHeight()-300);
					esseDeletarFornecedor.fornecedorSendoExibido = exibirFornecedor;
					
					esseDeletarFornecedor.add(btnDeletar);
				}
				esseDeletarFornecedor.repaint();
			}
		});
		btnBuscar.setBounds(351, 35, 89, 23);
		add(btnBuscar);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciador.menuFornecedor();
			}
		});
		btnNewButton.setBounds(351, 266, 89, 23);
		add(btnNewButton);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 67, 46, 14);
		add(lblId);
		
		textId = new JTextField();
		textId.setBounds(10, 92, 331, 20);
		add(textId);
		textId.setColumns(10);
		
		JButton btnBuscarId = new JButton("Buscar");
		btnBuscarId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textId.getText());
				Fornecedor fornecedor = repositorio.find(id);
				
				if(fornecedor == null) {
					lblMensagem.setText("Fornecedor não encontrado.");
				} else {
					lblMensagem.setText("");
					esseDeletarFornecedor.add(btnCancelar);
					
					ExibirFornecedor exibirFornecedor = new ExibirFornecedor(fornecedor);
									
					esseDeletarFornecedor.add(exibirFornecedor);
					exibirFornecedor.setBounds(0, 300, esseDeletarFornecedor.getWidth(), esseDeletarFornecedor.getHeight()-300);
					esseDeletarFornecedor.fornecedorSendoExibido = exibirFornecedor;
					
					esseDeletarFornecedor.add(btnDeletar);
				}
				esseDeletarFornecedor.repaint();
			}
		});
		btnBuscarId.setBounds(351, 91, 89, 23);
		add(btnBuscarId);
		
	}
}
