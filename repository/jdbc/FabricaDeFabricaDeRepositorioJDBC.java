package repository.jdbc;

import config.FabricaDeConexao;
import repository.FabricaDeFabricaDeRepositorios;
import repository.FabricaDeRepositorios;

public class FabricaDeFabricaDeRepositorioJDBC implements FabricaDeFabricaDeRepositorios {

	private String host;
	
	
	public FabricaDeFabricaDeRepositorioJDBC(String host) {
		super();
		this.host = host;
	}

	public FabricaDeRepositorios criarFabricaParaGerente() {
		return new FabricaDeRepositoriosJDBC(
				new FabricaDeConexao(this.host, "Gerente", "38964"));
	}

	@Override
	public FabricaDeRepositorios criarFabricaParaCliente() {
		return new FabricaDeRepositoriosJDBC(
				new FabricaDeConexao("jdbc:mysql://localhost:3306/Livraria", "Cliente", "3reaix"));
	}

	@Override
	public FabricaDeRepositorios criarFabricaParaCaixa() {
		return new FabricaDeRepositoriosJDBC(
				new FabricaDeConexao("jdbc:mysql://localhost:3306/Livraria", "Caixa", "reporepo"));
	}

	@Override
	public FabricaDeRepositorios criarFabricaParaVendedor() {
		return new FabricaDeRepositoriosJDBC(
				new FabricaDeConexao("jdbc:mysql://localhost:3306/Livraria", "Vendedor", "comsono"));
	}

	@Override
	public FabricaDeRepositorios criarFabricaParaLogin() {
		return  new FabricaDeRepositoriosJDBC(new FabricaDeConexao("jdbc:mysql://localhost:3306/Livraria","Login", "09876Logoff"));
	}

}
