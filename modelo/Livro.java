package modelo;

import util.Real;

public class Livro extends Produto {
	private long isbn;
	private String autor;
	private String editora;
	
	
	public Livro(String nome, String descri�ao, Real preco, int quantidade, long isbn, String autor, String editora) {
		super(nome, descri�ao, preco, quantidade);
		this.isbn = isbn;
		this.autor = autor;
		this.editora = editora;
	}
	public Livro(int id, String nome, String descri�ao, Real preco, int quantidade, long isbn, String autor, String editora) {
		super(id, nome, descri�ao, preco, quantidade);
		this.isbn = isbn;
		this.autor = autor;
		this.editora = editora;
	}
	public long getIsbn() {
		return isbn;
	}
	public String getAutor() {
		return autor;
	}
	public String getEditora() {
		return editora;
	}
	
}
