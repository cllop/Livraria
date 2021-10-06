package view.fornecedor;

import javax.swing.JPanel;

import repository.RepositorioFornecedor;

public class GerenciadorFornecedor extends JPanel {
	
	private JPanel menuSelecionado;
	private RepositorioFornecedor repositorio;

	public GerenciadorFornecedor() {

	}
	
	public void trocarTela (JPanel menuSelecionado) {
		if(this.menuSelecionado!=null) {
			super.remove(this.menuSelecionado);
		}
		super.add(menuSelecionado);
		this.menuSelecionado = menuSelecionado;
		redimencionar();
	}
	
	public void redimencionar() {
		//copiar de gerenciador principal fazendo alteracoes necessarias
	}
	
	public void adicionarFornecedor() {
		this.trocarTela(new AdicionarFornecedor(this, this.repositorio));
	}
	
	public void editarFornecedor() {
		this.trocarTela(new EditarFornecedor(this));
	}
	
	public void pesquisarFornecedor() {
		this.trocarTela(new PesquisarFornecedor(this));
	}
	
	public void deletarFornecedor() {
		this.trocarTela(new DeletarFornecedor(this));
	}
	
	public void menuFornecedor() {
		this.trocarTela(new MenuFornecedor(this));
	}
	
}
