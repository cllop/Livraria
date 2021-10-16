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
					throw new UnsupportedOperationException("Mudar para autor n�o cadastrado n�o foi implementado ainda");
				}
				
				
				comandoSql = conexao.prepareStatement("INSERT INTO produto(nome, descricao, pre�o, quantidade) VALUES (?, ?, ?, ?);"
						+ "INSERT INTO livros(isbn, autor, editora) VALUES (?, ?, ?);");
			} else {
				comandoSql = conexao
						.prepareStatement("INSERT INTO produto(nome, descricao, preco, quantidade) VALUES (?, ?, ?, ?);");
			}
			comandoSql.setString(1, produto.getNome());
			comandoSql.setString(2, produto.getDescri�ao());
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

			throw new RuntimeException("Opera��o n�o pode ser concluida");
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
				String descri�ao = conjuntoDeResultados.getString("descricao");
				int quantidade = conjuntoDeResultados.getInt("quantidade");
				
				if (conjuntoDeResultados.getString("isbn") == null) {
					return new Produto(id, nome, descri�ao, preco, quantidade);

				} else {
					
					long isbn = conjuntoDeResultados.getLong("isbn");
					String autor = conjuntoDeResultados.getString("autor");
					String editora = conjuntoDeResultados.getString("editora");
					
		
					return new Livro(nome, descri�ao, preco, quantidade, isbn, autor, editora);

				}

			}else {
				throw new RuntimeException("Produto n�o encontrado");
			}
			
			
			
		} catch (SQLException execao) {

			throw new RuntimeException("Opera��o n�o pode ser concluida");

		}
	}

	
	public Produto findByNome(String nome) {
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
					"SELECT * FROM Produto WHERE nome=?"
					);
			ps.setString(1, nome);
			ps.execute();
			
			ResultSet rs = ps.executeQuery();
			boolean temResultado = rs.next();
			
			if(temResultado) {
				int id = rs.getInt("id");
				Real preco = new Real (rs.getInt("preco"));
				String descricao = rs.getString("descricao");	
				short quantidade = rs.getShort("quantidade");
				
				return new Produto(id, nome, descricao, preco, quantidade);
			}else {
				throw new RuntimeException("produto n�o cadastrado.");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("N�o foi poss�vel encontrar o produto.", e);
		}finally {
			if(!jaExisteConexao) {
				super.fecharConexao();
			}
		}
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
