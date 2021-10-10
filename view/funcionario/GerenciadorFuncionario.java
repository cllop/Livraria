package view.funcionario;

import java.awt.Container;
import java.util.List;

import javax.swing.JPanel;

import modelo.Funcionario;
import repository.RepositorioCaixa;
import repository.RepositorioFuncionario;
import repository.RepositorioGerente;
import repository.RepositorioVendedor;

public class GerenciadorFuncionario extends JPanel {
	private Container menuSelecionado;
	private RepositorioFuncionario repositorioFuncionario;
	private RepositorioGerente repositorioGerente;
	private RepositorioCaixa repositorioCaixa;
	private RepositorioVendedor repositorioVendedor;

	public GerenciadorFuncionario(RepositorioFuncionario repositorioFuncionario, RepositorioGerente repositorioGerente, RepositorioCaixa repositorioCaixa, RepositorioVendedor repositorioVendedor) {
		this.repositorioFuncionario = repositorioFuncionario;
		this.repositorioGerente
		

	}
	
	private void trocarTela (Container menuSelecionado) {
		if(this.menuSelecionado!=null) {
			super.remove(this.menuSelecionado);
		}
		super.add(menuSelecionado);
		this.menuSelecionado = menuSelecionado;
		repaint();
	}
	
	public void menuFuncionario() {
		
	}
	
	public void cadastrarFuncionario() {
		
	}
	
	public void atualizarFuncionario() {
		
	}
	
	public void exibirFuncionarios(List<Funcionario> listaDeFuncionario) {
		
	}
	
	public void cadastrarGerente(Funcionario funcionario) {
		
	}
	
	public void cadastrarCaixa(Funcionario funcionario) {
		
	}
	
	public void cadastrarVendedor(Funcionario funcionario) {
		
	}

}
