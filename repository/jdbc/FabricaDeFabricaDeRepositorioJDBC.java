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
		return new FabricaDeRepositoriosJDBC(new FabricaDeConexao(this.host, "gerente", "reporepo"));
	}

	public FabricaDeRepositorios criarFabricaParaCliente() {
		return new FabricaDeRepositoriosJDBC(new FabricaDeConexao(this.host, "cliente", "3reaix"));
	}

	public FabricaDeRepositorios criarFabricaParaCaixa() {
		return new FabricaDeRepositoriosJDBC(new FabricaDeConexao(this.host, "caixa", "comsono"));
	}

	public FabricaDeRepositorios criarFabricaParaVendedor() {
		return new FabricaDeRepositoriosJDBC(new FabricaDeConexao(this.host, "vendedor", "38964"));
	}

	public FabricaDeRepositorios criarFabricaParaLogin() {
		return new FabricaDeRepositoriosJDBC(new FabricaDeConexao(this.host, "paraLogin", "09876Logoff"));
	}

}
