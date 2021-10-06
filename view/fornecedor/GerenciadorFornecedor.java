package view.fornecedor;

import java.awt.Container;
import java.util.List;

import javax.swing.JPanel;

import modelo.Fornecedor;
import repository.RepositorioFornecedor;

public class GerenciadorFornecedor extends JPanel {
	
	private Container menuSelecionado;
	private RepositorioFornecedor repositorio;

	public GerenciadorFornecedor() {

	}
	
	public void trocarTela (Container menuSelecionado) {
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
	
	public void exibirFornecedores(List<Fornecedor>listaFornecedor) {
		this.trocarTela(new ExibirFornecedores(this, listaFornecedor));
	}
	
}
