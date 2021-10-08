package repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.FabricaDeConexao;
import modelo.Produto;
import repository.RepositorioDeProduto;

public class RepositorioProdutoJDBC extends RepositorioJDBC implements RepositorioDeProduto {

	public RepositorioProdutoJDBC(FabricaDeConexao fabricadeconexoes) {
		super(fabricadeconexoes);
	}

	@Override
	public void add(Produto produto) {
		Connection conecxao = super.getConecxao();
		boolean conecxaoJaExistia;
		if(conecxao == null) {
			conecxaoJaExistia = false;
			super.criarConexao();
		}else {
			conecxaoJaExistia = true;
		}
		
		PreparedStatement ps = null;
		
		try {
			
			ps = conecxao.prepareStatement("INSERT INTO produtos(nome, descrição, preço, quanidade) VALUES (?, ?, ?, ?);");
			
			
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
		// TODO Auto-generated method stub
		return null;
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
