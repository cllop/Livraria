package repository;

import java.util.List;

import modelo.Cliente;

public interface RepositorioCliente{
	
	public Cliente getCliente(long cpf);
	
	public void add(Cliente cliente);
	
	public void remove(Cliente cliente);
	
	public void uptade(Cliente cliente);
	
	public Cliente find(int id);
	
	public Cliente findByCpf(long cpf);
	
	public List<Cliente> findByNomeDeUsuario(String nomeDeUsuario);
	
}
