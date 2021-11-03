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
	
	@Override
	public void salvarVenda(Venda venda) {
		// TODO Auto-generated method stub	
	}
	@Override
	public Venda find(int id) {
		// TODO Auto-generated method stub
		return null;
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
		int idSetor = conjuntoDeResultados.getInt("idSetor");
		

		Produto produto = new Produto(idProduto, nome, descricao, precoProduto, quantidadeProduto, idSetor);

		return new ItemDeVenda(idVenda, id, quantidade, preco, produto);

	}

	public static Venda lerVenda(ResultSet conjuntoDeResultados) throws SQLException {

		if (conjuntoDeResultados.next()) {

			return apenasLerVenda(conjuntoDeResultados);
		} else {
			throw new RuntimeException("venda nao encontrada");
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

		if (strIdItemDeVenda != null) {
			ItemDeVenda itemDeVenda = apenasLerItemDeVenda(conjuntoDeResultados);
			itensDeVenda.add(itemDeVenda);

		}
		while (conjuntoDeResultados.next() && id == atualId) {
			if (strIdItemDeVenda != null) {
				ItemDeVenda itemDeVenda = apenasLerItemDeVenda(conjuntoDeResultados);
				itensDeVenda.add(itemDeVenda);
			}
			atualId = conjuntoDeResultados.getInt("idVenda");

		}
		// int id, Date data, Vendedor vendedor, Cliente cliente, Caixa caixa,
		// List<ItemDeVenda> itensDeVenda, List<Pagamento> pagamentos
		return new Venda(id, data, apenasLerVendedor(conjuntoDeResultados), apenasLerCliente(conjuntoDeResultados),
				apenasLerCaixa(conjuntoDeResultados), itensDeVenda, pagamentos);
	}

	private static Vendedor apenasLerVendedor(ResultSet conjuntoDeResultados) throws SQLException {

		int id = conjuntoDeResultados.getInt("id");
		long cpf = conjuntoDeResultados.getLong("cpf");
		String nome = conjuntoDeResultados.getString("nome");
		String sobrenome = conjuntoDeResultados.getString("sobrenome");
		String nomeDeUsuario = conjuntoDeResultados.getString("nomeDeUsuario");
		String senha = conjuntoDeResultados.getString("senha");
		String pais = conjuntoDeResultados.getString("pais");
		String cidade = conjuntoDeResultados.getString("cidade");
		String estado = conjuntoDeResultados.getString("estado");
		String rua = conjuntoDeResultados.getString("rua");
		String bairro = conjuntoDeResultados.getString("bairro");
		int cep = conjuntoDeResultados.getInt("cep");
		Short numeroDaResidencia = conjuntoDeResultados.getShort("numeroDaResidencia");
		byte ddi = conjuntoDeResultados.getByte("ddi");
		byte ddd = conjuntoDeResultados.getByte("ddd");
		int telefone = conjuntoDeResultados.getInt("telefone");
		boolean ativo = conjuntoDeResultados.getBoolean("ativo");

		return new Vendedor(id, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro, cep,
				numeroDaResidencia, ddi, ddd, telefone, ativo);

	}

	private static Caixa apenasLerCaixa(ResultSet conjuntoDeResultados) throws SQLException {

		int id = conjuntoDeResultados.getInt("id");
		long cpf = conjuntoDeResultados.getLong("cpf");
		String nome = conjuntoDeResultados.getString("nome");
		String sobrenome = conjuntoDeResultados.getString("sobrenome");
		String nomeDeUsuario = conjuntoDeResultados.getString("nomeDeUsuario");
		String senha = conjuntoDeResultados.getString("senha");
		String pais = conjuntoDeResultados.getString("pais");
		String estado = conjuntoDeResultados.getString("estado");
		String cidade = conjuntoDeResultados.getString("cidade");
		String rua = conjuntoDeResultados.getString("rua");
		String bairro = conjuntoDeResultados.getString("bairro");
		int cep = conjuntoDeResultados.getInt("cep");
		short numeroDaResidencia = conjuntoDeResultados.getShort("numeroDaResidencia");
		byte ddi = conjuntoDeResultados.getByte("DDI");
		byte ddd = conjuntoDeResultados.getByte("DDD");
		int telefone = conjuntoDeResultados.getInt("telefone");
		boolean ativo = conjuntoDeResultados.getBoolean("ativo");

		return new Caixa(id, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro, cep,
				numeroDaResidencia, ddi, ddd, telefone, ativo);

	}

	public static Cliente apenasLerCliente(ResultSet conjuntoDeResultados) throws SQLException {

		int idUsuario = conjuntoDeResultados.getInt("idUsuario");
		int idCliente = conjuntoDeResultados.getInt("idCliente");
		long cpf = conjuntoDeResultados.getLong("cpf");
		String nome = conjuntoDeResultados.getString("nome");
		String sobrenome = conjuntoDeResultados.getString("sobrenome");
		String nomeDeUsuario = conjuntoDeResultados.getString("nomeDeUsuario");
		String senha = conjuntoDeResultados.getString("senha");
		String pais = conjuntoDeResultados.getString("pais");
		String estado = conjuntoDeResultados.getString("estado");
		String cidade = conjuntoDeResultados.getString("cidade");
		String rua = conjuntoDeResultados.getString("rua");
		String bairro = conjuntoDeResultados.getString("bairro");
		int cep = conjuntoDeResultados.getInt("cep");
		short numeroDaResidencia = conjuntoDeResultados.getShort("numeroDaResidencia");
		byte ddi = conjuntoDeResultados.getByte("DDI");
		byte ddd = conjuntoDeResultados.getByte("DDD");
		int telefone = conjuntoDeResultados.getInt("telefone");

		return new Cliente(idUsuario, idCliente, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua,
				bairro, cep, numeroDaResidencia, ddi, ddd, telefone);

	}
}
