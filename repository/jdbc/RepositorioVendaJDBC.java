package repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Caixa;
import modelo.Cliente;
import modelo.ItemDeVenda;
import modelo.Pagamento;
import modelo.Produto;
import modelo.Venda;
import modelo.Vendedor;
import repository.RepositorioVenda;
import util.Real;

public class RepositorioVendaJDBC extends RepositorioJDBC implements RepositorioVenda {

	public RepositorioVendaJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	public static ItemDeVenda apenasLerItemDeVenda(ResultSet conjuntoDeResultados) throws SQLException {

		int idVenda = conjuntoDeResultados.getInt("Id da venda");
		int id = conjuntoDeResultados.getInt("Id");
		int quantidade = conjuntoDeResultados.getInt("Quantidade");
		Real preco = new Real(conjuntoDeResultados.getInt("preco"));

		int idProduto = conjuntoDeResultados.getInt("id");
		String nome = conjuntoDeResultados.getString("nome");
		Real precoProduto = new Real(conjuntoDeResultados.getInt("preco"));
		String descricao = conjuntoDeResultados.getString("descricao");
		int quantidadeProduto = conjuntoDeResultados.getInt("quantidade");

		Produto produto = new Produto(idProduto, nome, descricao, precoProduto, quantidadeProduto);

		return new ItemDeVenda(idVenda, id, quantidade, preco, produto);

	}

	public static Venda lerVenda(ResultSet conjuntoDeResultados) throws SQLException {

		if (conjuntoDeResultados.next()) {

			return apenasLerVenda(conjuntoDeResultados);

		}
	}

	public static Venda apenasLerVenda(ResultSet conjuntoDeResultados) throws SQLException {
		
		int id = conjuntoDeResultados.getInt("IdVenda");
		int valor = conjuntoDeResultados.getInt("Valor");
		Date data = conjuntoDeResultados.getDate("Data");
		String strIdItemDeVenda = conjuntoDeResultados.getString("idItemDeVenda");
		int atualId = id;
		
		List<ItemDeVenda> itensDeVenda = new ArrayList<>(conjuntoDeResultados.getRow());
		List<Pagamento> pagamentos = new ArrayList<>(conjuntoDeResultados.getRow());
		
		if(strIdItemDeVenda != null) {
			ItemDeVenda itemDeVenda = apenasLerItemDeVenda(conjuntoDeResultados);
			itensDeVenda.add(itemDeVenda); 
			
		}
		while(conjuntoDeResultados.next() && id == atualId) {
			if(strIdItemDeVenda != null) {
				ItemDeVenda itemDeVenda = apenasLerItemDeVenda(conjuntoDeResultados);
				itensDeVenda.add(itemDeVenda);
			}
			atualId  = conjuntoDeResultados.getInt("idVenda");
			
		}
		// List<ItemDeVenda> itensDeVenda, List<Pagamento> pagamentos
		return new Venda(id, data, apenasLerVendedor(conjuntoDeResultados), apenasLerCliente(conjuntoDeResultados), apenasLerCaixa(conjuntoDeResultados), valor, strIdItemDeVenda, itensDeVenda, pagamentos);
	}
	
	private static Vendedor apenasLerVendedor(ResultSet conjuntoDeResultados) throws SQLException {

			int id = conjuntoDeResultados.getInt("id");
			long cpf = conjuntoDeResultados.getLong("cpf");
			String nome = conjuntoDeResultados.getString("nome");
			String sobrenome = conjuntoDeResultados.getString("sobrenome");
			String nomeDeUsuario = conjuntoDeResultados.getString("nomeDeUsuario");
			String rua = conjuntoDeResultados.getString("rua");
			String bairro = conjuntoDeResultados.getString("bairro");
			int cep = conjuntoDeResultados.getInt("cep");
			int numeroDaResidencia = conjuntoDeResultados.getInt("numeroDeResidencia");
			boolean ativo = conjuntoDeResultados.getBoolean("ativo");
			byte ddi = conjuntoDeResultados.getByte("DDI");
			int telefone = conjuntoDeResultados.getInt("numeroTelefone");
			
			return new Vendedor(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, ddi, ddi, telefone);

	}
	
	private static Caixa apenasLerCaixa(ResultSet conjuntoDeResultados) throws SQLException {

			int id = conjuntoDeResultados.getInt("id");
			long cpf = conjuntoDeResultados.getLong("cpf");
			String nome = conjuntoDeResultados.getString("nome");
			String sobrenome = conjuntoDeResultados.getString("sobrenome");
			String nomeDeUsuario = conjuntoDeResultados.getString("nomeDeUsuario");
			String rua = conjuntoDeResultados.getString("rua");
			String bairro = conjuntoDeResultados.getString("bairro");
			int cep = conjuntoDeResultados.getInt("cep");
			int numeroDaResidencia = conjuntoDeResultados.getInt("numeroDeResidencia");
			byte ddd = conjuntoDeResultados.getByte("DDD");
			byte ddi = conjuntoDeResultados.getByte("DDI");
			int telefone = conjuntoDeResultados.getInt("numeroTelefone");

			return new Caixa(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, ddi, ddd, telefone);

	}
	
	public static Cliente apenasLerCliente(ResultSet conjuntoDeResultados) throws SQLException {
		
		if(conjuntoDeResultados.next()) {
			
			int id = conjuntoDeResultados.getInt(2);
			String nome = conjuntoDeResultados.getString(3);
			String sobrenome = conjuntoDeResultados.getString(4);
			String nomeDeUsuario = conjuntoDeResultados.getString(5);
			String rua = conjuntoDeResultados.getString(6);
			String bairro = conjuntoDeResultados.getString(7);
			int cep = conjuntoDeResultados.getInt(8);
			int numeroDaResidencia = conjuntoDeResultados.getInt(9);
			byte ddd = conjuntoDeResultados.getByte("DDD");
			byte ddi = conjuntoDeResultados.getByte("DDI");
			int telefone = conjuntoDeResultados.getInt("numeroTelefone");
		
//			return new Cliente(id, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, ddd, ddi, telefone);
			return null;
		}
	}
}
