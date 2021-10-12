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
		return new FabricaDeRepositoriosJDBC(new FabricaDeConexao(this.host, "Gerente", "38964"));
	}

	public FabricaDeRepositorios criarFabricaParaCliente() {
		return new FabricaDeRepositoriosJDBC(new FabricaDeConexao(this.host, "Cliente", "3reaix"));
	}

	public FabricaDeRepositorios criarFabricaParaCaixa() {
		return new FabricaDeRepositoriosJDBC(new FabricaDeConexao(this.host, "Caixa", "reporepo"));
	}

	public FabricaDeRepositorios criarFabricaParaVendedor() {
		return new FabricaDeRepositoriosJDBC(new FabricaDeConexao(this.host, "Vendedor", "comsono"));
	}

	public FabricaDeRepositorios criarFabricaParaLogin() {
		return new FabricaDeRepositoriosJDBC(new FabricaDeConexao(this.host, "Login", "09876Logoff"));
	}

}
