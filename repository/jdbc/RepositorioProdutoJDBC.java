package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Produto;
import repository.RepositorioProduto;
import util.Real;

public class RepositorioProdutoJDBC extends RepositorioJDBC implements RepositorioProduto {

	public RepositorioProdutoJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	public void add(Produto produto) {
		Connection conexao = super.getConexao();
		boolean conexaoJaExistia;
		if (conexao == null) {
			conexaoJaExistia = false;
			conexao = super.criarConexao();
		} else {
			conexaoJaExistia = true;
		}

		PreparedStatement comandoSql = null;

		try {

			comandoSql = conexao
					.prepareStatement("INSERT INTO produto(idSetor, nome, descricao, preco, quantidade) VALUES (?, ?, ?, ?, ?);");

			comandoSql.setInt(1, produto.getIdSetor());
			comandoSql.setString(2, produto.getNome());
			comandoSql.setString(3, produto.getDescricao());
			comandoSql.setInt(4, produto.getPreco().getCentavos());
			comandoSql.setInt(5, produto.getQuantidade());

			comandoSql.execute();
		} catch (SQLException execao) {

			throw new RuntimeException("Operaï¿½ï¿½o nï¿½o pode ser concluida", execao);
		}finally {
			if(conexaoJaExistia) {
				super.fecharConexao();
			}
		}

	}

	public Produto find(int id) {
		Connection conexao = super.getConexao();
		boolean conexaoJaExistia;
		if (conexao == null) {
			conexaoJaExistia = false;
			conexao = super.criarConexao();
		} else {
			conexaoJaExistia = true;
		}

		PreparedStatement ps = null;

		try {

			ps = conexao.prepareStatement("SELECT * FROM produto WHERE produto.id=?;");

			ps.setInt(1, id);

			ResultSet conjuntoDeResultados = ps.executeQuery();

			return lerProduto(conjuntoDeResultados);

		} catch (SQLException execao) {

			throw new RuntimeException("Operação não pode ser concluida" + execao);

		}finally {
			if(conexaoJaExistia) {
				super.fecharConexao();
			}
		}
	}

	public List<Produto> findByNome(String nome) {
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM produto WHERE nome=?");
			ps.setString(1, nome);
			ps.execute();

			ResultSet rs = ps.executeQuery();

			return lerProdutos(rs);

		} catch (SQLException e) {

			throw new RuntimeException("Não foi possivel encontrar o produto.", e);

		} finally {

			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void delete(Produto produto) {//Tem q terminar ainda!!
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
			PreparedStatement ps;
		try {
			
			ps = con.prepareStatement("DELETE INTO produto WHERE ID=?");
			ps.setInt(1, produto.getId());	
		} catch (Exception e) {
			throw new RuntimeException ("Não foi possivel deletar o produto", e);
		}finally {
			if(jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void update(Produto produto) {
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;

		try {

			ps = con.prepareStatement("UPDATE produto SET idSetor=? nome=?, preco=?, descricao=?;");
			
			ps.setInt(1, produto.getIdSetor());
			ps.setString(2, produto.getNome());
			ps.setInt(3, produto.getPreco().getCentavos());
			ps.setString(4, produto.getDescricao());

			ps.execute();

		} catch (SQLException e) {

			throw new RuntimeException("Os dados não foram alterados " + e);

		}finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}

	}

	public Produto findByCategoria(String categoria) {

		return null;
	}

	private List<Produto> lerProdutos(ResultSet conjuntoDeResultados) throws SQLException {

		List<Produto> produtos = new ArrayList<>(conjuntoDeResultados.getRow());

		while (conjuntoDeResultados.next()) {

			

			produtos.add(apenasLerProduto(conjuntoDeResultados));

		}
		return produtos;
	}

	private Produto lerProduto(ResultSet conjuntoDeResultados) throws SQLException {

		boolean existeResultado = conjuntoDeResultados.next();

		if (existeResultado) {
			return apenasLerProduto(conjuntoDeResultados);	
		} else {
			throw new RuntimeException("Produto não encontrado");
		}
	}
	
	public static Produto apenasLerProduto(ResultSet conjuntoDeResultados) throws SQLException {
		
		int id = conjuntoDeResultados.getInt("id");
		String nome = conjuntoDeResultados.getString("nome");
		Real preco = new Real(conjuntoDeResultados.getInt("preco"));
		String descricao = conjuntoDeResultados.getString("descricao");
		int quantidade = conjuntoDeResultados.getInt("quantidade");
		int idSetor = conjuntoDeResultados.getInt("idSetor");
		
		return new Produto(id, nome, descricao, preco, quantidade, idSetor);
	}
	
	public void remove(Produto produto) {
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement("DELETE FROM produto WHERE id=?");
			ps.setLong(1, produto.getId());
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível remover produto.", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}
	
}
