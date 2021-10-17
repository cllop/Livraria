package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			conexao = super.criarConexao();
		} else {
			conexaoJaExistia = true;
		}

		PreparedStatement comandoSql = null;

		try {
			int idAutor = -1;
			int idEditora = -1;
			if (produto instanceof Livro) {
				Livro livro = (Livro) produto;
				PreparedStatement declaracaoSqlObterIdAutor = conexao
						.prepareStatement("SELECT id FROM Autor WHERE nome= ?;");
				declaracaoSqlObterIdAutor.setString(1, livro.getAutor());
				ResultSet resultadoIdAutor = declaracaoSqlObterIdAutor.executeQuery();
				if (resultadoIdAutor.next()) {
					idAutor = resultadoIdAutor.getInt(1);
				} else {
					throw new UnsupportedOperationException(
							"Mudar para autor não cadastrado não foi implementado ainda");
				}

				comandoSql = conexao
						.prepareStatement("INSERT INTO produto(nome, descricao, preço, quantidade) VALUES (?, ?, ?, ?);"
								+ "INSERT INTO livros(isbn, autor, editora) VALUES (?, ?, ?);");
			} else {
				comandoSql = conexao.prepareStatement(
						"INSERT INTO produto(nome, descricao, preco, quantidade) VALUES (?, ?, ?, ?);");
			}
			comandoSql.setString(1, produto.getNome());
			comandoSql.setString(2, produto.getDescricao());
			comandoSql.setInt(3, produto.getPreco().getCentavos());
			comandoSql.setInt(4, produto.getQuantidade());

			if (produto instanceof Livro) {
				Livro livro = (Livro) produto;
				comandoSql.setLong(5, livro.getIsbn());
				comandoSql.setInt(6, idAutor);
				comandoSql.setInt(7, idEditora);
			}
			comandoSql.execute();
		} catch (SQLException execao) {

			throw new RuntimeException("Operaï¿½ï¿½o nï¿½o pode ser concluida");
		}

	}

	public Produto find(int id) {
		Connection conexao = super.getConexao();
		boolean conexaoJaExistia;
		if (conexao== null) {
			conexaoJaExistia = false;
			conexao =super.criarConexao();
		} else {
			conexaoJaExistia = true;
		}

		PreparedStatement ps = null;

		try {

//			ps = conecxao.prepareStatement(
//					"SELECT produto.*, livro.*, autor.nome as autor, editora.nome as editora FROM produto "
//							+ "LEFT JOIN livro ON produto.id=livro.id " + "LEFT JOIN autor ON livro.idAutor= autor.id "
//							+ "LEFT JOIN editora On livro.idEditora= editora.id " + "WHERE produto.id= ?;");
			ps = conexao.prepareStatement("SELECT * FROM produto WHERE id=?;");
			ps.setInt(1, id);
			
			ResultSet conjuntoDeResultados = ps.executeQuery();
			boolean existeResultado = conjuntoDeResultados.next();
			
			if (existeResultado) {
				String nome = conjuntoDeResultados.getString("nome");
				Real preco = new Real(conjuntoDeResultados.getInt("preco"));
				String descricao = conjuntoDeResultados.getString("descricao");
				int quantidade = conjuntoDeResultados.getInt("quantidade");

//				if (conjuntoDeResultados.getString("isbn") == null) {
				if(conjuntoDeResultados != null) {
					return new Produto(id, nome, descricao, preco, quantidade);

				} else {

					long isbn = conjuntoDeResultados.getLong("isbn");
					String autor = conjuntoDeResultados.getString("autor");
					String editora = conjuntoDeResultados.getString("editora");

					return new Livro(nome, descricao, preco, quantidade, isbn, autor, editora);

				}

			} else {
				throw new RuntimeException("Produto não encontrado!!!");
			}

		} catch (SQLException execao) {

			throw new RuntimeException("Operação não pode ser concluida"+ execao);

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
			ps = con.prepareStatement("SELECT * FROM produto WHERE nome=?");
			ps.setString(1, nome);
			ps.execute();

			ResultSet rs = ps.executeQuery();
			boolean temResultado = rs.next();

			if (temResultado) {
				int id = rs.getInt("id");
				Real preco = new Real(rs.getInt("preco"));
				String descricao = rs.getString("descricao");
				short quantidade = rs.getShort("quantidade");

				return new Produto(id, nome, descricao, preco, quantidade);
			} else {
				throw new RuntimeException("produto não cadastrado.");
			}

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possivel encontrar o produto.", e);
		} finally {
			if (!jaExisteConexao) {
				super.fecharConexao();
			}
		}
	}
	
	public void update(Produto produto, Livro livro) {
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
			ps = con.prepareStatement("UPDATE produto SET nome=?, preco=?, descricao=?, quantidade=?, isbn=?, autor=?, editora=?  WHERE id=?");
			ps.setString(1, produto.getNome());
			//ps.setInt(2, produto.getPreco());
			ps.setString(3, produto.getDescricao());
			ps.setInt(4, produto.getQuantidade());
			
			ps.setLong(5, livro.getIsbn());
			ps.setString(6, livro.getAutor());
			ps.setString(7, livro.getEditora());
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException("Os dados não foram alterados " + e);
		}

	}

	
	public Produto findByAutor(String autor) {
	
		return null;
	}

	
	public Produto findByCategoria(String categoria) {
		
		return null;
	}

	private List<Produto> lerProdutos(ResultSet conjuntoDeResultados) throws SQLException {
		
		List<Produto> produtos = new ArrayList<>(conjuntoDeResultados.getRow());
		
		while(conjuntoDeResultados.next()) {
			
				int id = conjuntoDeResultados.getInt("id");
				String nome = conjuntoDeResultados.getString("nome");
				Real preco = new Real(conjuntoDeResultados.getInt("preco"));
				String descricao = conjuntoDeResultados.getString("descricao");
				int quantidade = conjuntoDeResultados.getInt("quantidade");
				
			produtos.add(new Produto(id, nome, descricao, preco, quantidade));
				
			}
			return produtos;
		}
	private Produto lerProduto(ResultSet conjuntoDeResultados) throws SQLException{
		boolean existeResultado = conjuntoDeResultados.next();
		
		if(existeResultado) {
			int id = conjuntoDeResultados.getInt("id");
			String nome = conjuntoDeResultados.getString("nome");
			Real preco = new Real(conjuntoDeResultados.getInt("preco"));
			String descricao = conjuntoDeResultados.getString("descricao");
			int quantidade = conjuntoDeResultados.getInt("quantidade");
			
			return new Produto(id, nome, descricao, preco, quantidade);
		}else {
			throw new RuntimeException("Produto não encontrado");
		}
		
	}

	
	

	


	

}
