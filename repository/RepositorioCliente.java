package repository;

import java.util.List;

import modelo.Cliente;

public interface RepositorioCliente{
		
	public void add(Cliente cliente);
	
	public void remove(Cliente cliente);
	
	public void update(Cliente cliente);
	
	public Cliente find(int id);
	
	public Cliente findByCpf(long cpf);
	
	public List<Cliente> findByNomeDeUsuario(String nomeDeUsuario);
	
}
