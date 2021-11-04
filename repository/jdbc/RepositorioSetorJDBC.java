package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.FabricaDeConexao;
import modelo.Produto;
import modelo.Setor;
import repository.RepositorioSetor;

public class RepositorioSetorJDBC extends RepositorioJDBC implements RepositorioSetor {

	public RepositorioSetorJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	public void add(Setor model) {
		Connection con = super.getConexao();
		Boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}
		PreparedStatement ps;

	}

	public Setor findByNome(String nome) {
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
			ps = con.prepareStatement(
					"SELECT produto.*, setor.id AS idSetor, setor.nome AS nomeSet FROM setor LEFT JOIN produtos WHERE setor.id=? ");
			ps.setString(1, nome);
			ps.execute();

			ResultSet rs = ps.executeQuery();

			return lerSetor(rs);

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possivel encontrar o produto.", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public Setor find(int id) {
		Connection con = super.getConexao();

		boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}

		PreparedStatement ps = null;

		try {

			ps = con.prepareStatement(
					"SELECT produto.*, setor.id AS idSetor, setor.nome AS nomeSetor FROM setor LEFT JOIN produto ON setor.id = produto.idSetor WHERE setor.id=?;");

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			return lerSetor(rs);

		} catch (SQLException e) {
			throw new RuntimeException("Operação não pode ser concluida", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}

	public void updade(int id) {
		Connection con = super.getConexao();

		boolean jaExisteConexao;
		if (con == null) {
			jaExisteConexao = false;
			con = super.criarConexao();
		} else {
			jaExisteConexao = true;
		}

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("UPDATE ");
		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	public Setor lerSetor(ResultSet conjuntoDeResultados) throws SQLException {
	
		if (conjuntoDeResultados.next()) {

			int id = conjuntoDeResultados.getInt("idSetor");
			String nome = conjuntoDeResultados.getString("nomeSetor");
			String strIdProduto = conjuntoDeResultados.getString("id");
			int atualId = id;

			List<Produto> produtos = new ArrayList<>(conjuntoDeResultados.getRow());

			if (strIdProduto != null) {
				Produto produto = RepositorioProdutoJDBC.apenasLerProduto(conjuntoDeResultados);
				produtos.add(produto);
			}

			while (conjuntoDeResultados.next() && id == atualId) {
				if (strIdProduto != null) {
					Produto produto = RepositorioProdutoJDBC.apenasLerProduto(conjuntoDeResultados);
					produtos.add(produto);
				}
				atualId = conjuntoDeResultados.getInt("idSetor");
			}

			return new Setor(id, nome, produtos);

		} else {

			throw new RuntimeException("Setor não encontrado");
		}
	}

}
