package modelo;

public class Fornecedor{
	private int id;
	private long cnpj;
	private String nome;
	private String nomeFantasia;
	private String pais;
	private String estado;
	private String cidade;
	private String rua;
	private String bairro;
	private int cep;
	private short numeroDoImovel;
	private short ddd;
	private short ddi;
	private int numeroTelefone;
	
	public Fornecedor(int id, long cnpj, String nome, String nomeFantasia, String pais, String estado, String cidade,
			String rua, String bairro, int cep, short numeroDoImovel, short ddd, short ddi, int numeroTelefone) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
		this.nomeFantasia = nomeFantasia;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
		this.numeroDoImovel = numeroDoImovel;
		this.ddd = ddd;
		this.ddi = ddi;
		this.numeroTelefone = numeroTelefone;
	}

	public Fornecedor(long cnpj, String nome, String nomeFantasia, String pais, String estado, String cidade,
			String rua, String bairro, int cep, short numeroDoImovel, short ddd, short ddi, int numeroTelefone) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.nomeFantasia = nomeFantasia;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
		this.numeroDoImovel = numeroDoImovel;
		this.ddd = ddd;
		this.ddi = ddi;
		this.numeroTelefone = numeroTelefone;
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
	
	public String getNomeFantasia() {
		return nomeFantasia;
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

	public short getNumeroDoImovel() {
		return numeroDoImovel;
	}
	
	public short getDdd() {
		return ddd;
	}

	public short getDdi() {
		return ddi;
	}

	public int getNumeroTelefone() {
		return numeroTelefone;
	}
	
	public String getPais() {
		return pais;
	}

	public String getEstado() {
		return estado;
	}

	public String getCidade() {
		return cidade;
	}
	
}
