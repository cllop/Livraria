package modelo;

public class Fornecedor extends Usuario {
	private int id;
	private long cnpj;
	private String nome;
	private String rua;
	private String bairro;
	private int cep;
	private int numeroDoImovel;
	
	public Fornecedor(int id, long cnpj, String nome, String rua, String bairro, int cep, int numeroDoImovel) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
		this.numeroDoImovel = numeroDoImovel;
	}

	public Fornecedor(long cnpj, String nome, String rua, String bairro, int cep, int numeroDoImovel) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
		this.numeroDoImovel = numeroDoImovel;
	}

	public int getId() {
		return id;
	}

	public long getCnpj() {
		return cnpj;
	}

	public String getNome() {
		return nome;
	}

	public String getRua() {
		return rua;
	}

	public String getBairro() {
		return bairro;
	}

	public int getCep() {
		return cep;
	}

	public int getNumeroDoImovel() {
		return numeroDoImovel;
	}
	
	
	
}
