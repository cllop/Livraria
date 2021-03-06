package view.produto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Produto;
import repository.RepositorioProduto;
import view.GerenciadorPrincipal;

public class EditarProduto extends JPanel {
	public EditarProduto(GerenciadorProduto gerenciadorProduto, RepositorioProduto repositorio, Produto produto) {
		setLayout(null);

		ExibirProduto panel = new ExibirProduto(gerenciadorProduto, produto);
		panel.setBounds(10, 11, 739, 390);
		add(panel);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorProduto.menuProduto();
			}
		});
		btnCancelar.setBounds(31, 412, 119, 23);
		add(btnCancelar);

		JLabel lblMensagem = new JLabel("");
		lblMensagem.setForeground(Color.RED);
		lblMensagem.setBounds(265, 412, 170, 14);
		add(lblMensagem);

		JButton btnComfirmarEdicao = new JButton("Confirmar Edi\u00E7\u00E3o");
		btnComfirmarEdicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Produto produto;

				produto = panel.lerCampos();

				try {

					repositorio.update(produto);

					JOptionPane.showMessageDialog(null, "Produto editado com sucesso");

					gerenciadorProduto.menuProduto();

				} catch (Exception execao) {

					lblMensagem.setText("N?o ? posssivel editar o produto.");

				}

			}

		});
		btnComfirmarEdicao.setBounds(561, 412, 148, 23);
		add(btnComfirmarEdicao);

		panel.habilitarCamposEditaveis();
	}
}
