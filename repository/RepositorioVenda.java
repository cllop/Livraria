package repository;

import modelo.Venda;

public interface RepositorioVenda {
	public void salvarVenda(Venda venda);
	public Venda find(int id);
}
