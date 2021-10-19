package view.fornecedor;

import java.awt.Color;
import java.awt.Container;
import java.util.List;

import javax.swing.JPanel;

import config.DevConfig;
import modelo.Fornecedor;
import repository.RepositorioFornecedor;

public class GerenciadorFornecedor extends JPanel {
	private Container menuSelecionado;
	private RepositorioFornecedor repositorio;

	public GerenciadorFornecedor(RepositorioFornecedor repositorio) {
		if (DevConfig.guiDevMode) {
			super.setBackground(Color.blue);
		}
		super.setLayout(null);
		this.repositorio = repositorio;
		this.menuFornecedor();
	}

	private void trocarTela(Container menuSelecionado) {
		if (this.menuSelecionado != null) {
			super.remove(this.menuSelecionado);
		}
		super.add(menuSelecionado);
		this.menuSelecionado = menuSelecionado;
		redimensionar();
	}

	public void redimensionar() {
		redimensionar(super.getWidth(), super.getHeight());
	}

	public void redimensionar(int largura, int altura) {
		if (this.menuSelecionado != null) {
			this.menuSelecionado.setBounds(0, 0, largura, altura);
		}
	}

	public void setBounds(int x, int y, int width, int height) {
		redimensionar(width, height);
		super.setBounds(x, y, width, height);
	}

	public void menuFornecedor() {
		this.trocarTela(new MenuFornecedor(this));
	}

	public void adicionarFornecedor() {
		this.trocarTela(new AdicionarFornecedor(this, this.repositorio));
	}

	public void editarFornecedor() {
		this.trocarTela(new PesquisarEditarFornecedor(this, repositorio));
	}
	
	public void editarFornecedor(Fornecedor fornecedor) {
		this.trocarTela(new EditarFornecedor(this, fornecedor, this.repositorio));
	}

	public void dadosDePesquisaFornecedor() {
		this.trocarTela(new DadosPesquisaFornecedor(this, this.repositorio));
	}

	public void deletarFornecedor() {
		this.trocarTela(new DeletarFornecedor(this, this.repositorio));
	}

	public void exibirFornecedores(List<Fornecedor> listaDeFornecedor) {
		this.trocarTela(new ExibirFornecedores(this, listaDeFornecedor));
	}

	public void exibirFornecedor(Fornecedor fornecedor) {
		this.trocarTela(new ExibirFornecedor(fornecedor));
	}
	
}
