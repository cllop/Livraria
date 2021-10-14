package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.FabricaDeConexao;
import modelo.Livro;
import modelo.Produto;
import repository.RepositorioProdutoAndLivro;
import util.Real;

public class RepositorioProdutoAndLivroJDBC extends RepositorioJDBC implements RepositorioProdutoAndLivro {

	public RepositorioProdutoAndLivroJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	public void add(Produto produto) {
		Connection conexao = super.getConexao();
		boolean conexaoJaExistia;
		if (conexao == null) {
			conexaoJaExistia = false;
			conexao=super.criarConexao();
		} else {
			conexaoJaExistia = true;
		}

		PreparedStatement comandoSql = null;

		try {
			int idAutor= -1;
			int idEditora= -1;
			if(produto instanceof Livro) {
				Livro livro = (Livro) produto;
				PreparedStatement declaracaoSqlObterIdAutor = conexao.prepareStatement("SELECT id FROM Autor WHERE nome= ?;");
				declaracaoSqlObterIdAutor.setString(1, livro.getAutor());
				ResultSet resultadoIdAutor= declaracaoSqlObterIdAutor.executeQuery();
				if(resultadoIdAutor.next()) {
					idAutor = resultadoIdAutor.getInt(1);
				}else {
					throw new UnsupportedOperationException("Mudar para autor não cadastrado não foi implementado ainda");
				}
				
				
				comandoSql = conexao.prepareStatement("INSERT INTO produto(nome, descricao, preço, quantidade) VALUES (?, ?, ?, ?);"
						+ "INSERT INTO livros(isbn, autor, editora) VALUES (?, ?, ?);");
			} else {
				comandoSql = conexao
						.prepareStatement("INSERT INTO produtos(nome, descricao, preco, quantidade) VALUES (?, ?, ?, ?);");
			}
			comandoSql.setString(1, produto.getNome());
			comandoSql.setString(2, produto.getDescriçao());
			comandoSql.setInt(3, produto.getPreco().getCentavos());
			comandoSql.setInt(4, produto.getQuantidade());
		
			if(produto instanceof Livro) {
				Livro livro = (Livro) produto;
				comandoSql.setLong(5, livro.getIsbn());
				comandoSql.setInt(6, idAutor);
				comandoSql.setInt(7, idEditora);
			}
			comandoSql.execute();
		} catch (SQLException execao) {

			throw new RuntimeException("Operação não pode ser concluida");
		}

	}

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

			}else {
				throw new RuntimeException("Produto não encontrado");
			}
			
			
			
		} catch (SQLException execao) {

			throw new RuntimeException("Operação não pode ser concluida");

		}
	}

	
	public Produto findByNome(String nome) {
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
			ps = conecxao.prepareStatement("");
			
		} catch (SQLException eexecao) {
			throw new RuntimeException();
		}
		
		
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
