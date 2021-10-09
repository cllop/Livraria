package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.FabricaDeConexao;
import modelo.Livro;
import modelo.Produto;
import repository.RepositorioDeProduto;
import util.Real;

public class RepositorioProdutoJDBC extends RepositorioJDBC implements RepositorioDeProduto {

	public RepositorioProdutoJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	@Override
	public void add(Produto produto) {
		Connection conecxao = super.getConexao();
		boolean conecxaoJaExistia;
		if (conecxao == null) {
			conecxaoJaExistia = false;
			super.criarConexao();
		} else {
			conecxaoJaExistia = true;
		}

		PreparedStatement ps = null;

		try {

			ps = conecxao
					.prepareStatement("INSERT INTO produtos(nome, descrição, preço, quanidade) VALUES (?, ?, ?, ?);");

			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescriçao());
			ps.setInt(3, produto.getPreco().getCentavos());
			ps.setInt(4, produto.getQuantidade());

		} catch (SQLException execao) {

			throw new RuntimeException("Operação não pode ser concluida");
		}

	}

	@Override
	public Produto find(int id) {
		Connection conecxao = super.getConexao();
		boolean conecxaoJaExistia;
		if (conecxao == null) {
			conecxaoJaExistia = false;
			super.criarConexao();
		} else {
			conecxaoJaExistia = true;
		}

		PreparedStatement ps = null;

		try {

			ps = conecxao.prepareStatement(
					"SELECT produto.*, livro.*, autor.nome as autor, editora.nome as editora FROM produto "
					+ "LEFT JOIN livro ON produto.id=livro.id "
					+ "LEFT JOIN autor ON livro.idAutor= autor.id "
					+ "LEFT JOIN editora On livro.idEditora= editora.id "
					+ "WHERE produto.id= ?;");
			ps.setInt(1, id);
			ResultSet conjuntoDeResultados = ps.executeQuery();
			boolean existeResultado = conjuntoDeResultados.next();
			if (existeResultado) {
				String nome = conjuntoDeResultados.getString("nome");
				Real preco = new Real(conjuntoDeResultados.getInt("preco"));
				String descriçao = conjuntoDeResultados.getString("descricao");
				int quantidade = conjuntoDeResultados.getInt("quantidade");

				if (conjuntoDeResultados.getString("isbn") == null) {
					return new Produto(id, nome, descriçao, preco, quantidade);

				} else {
					
					long isbn = conjuntoDeResultados.getLong("isbn");
					String autor = conjuntoDeResultados.getString("autor");
					String editora = conjuntoDeResultados.getString("editora");
					
		
					return new Livro(nome, descriçao, preco, quantidade, isbn, autor, editora);

				}

			}
		} catch (SQLException execao) {

			throw new RuntimeException("Operação não pode ser concluida");

		}
	}

	@Override
	public Produto findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto findByAutor(String autor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto findByCategoria(String categoria) {
		// TODO Auto-generated method stub
		return null;
	}

}
