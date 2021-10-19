package modelo;

public class Usuario {
	private int id;
	private long cpf;
	private String nome;
	private String sobrenome;
	private String nomeDeUsuario;
	private String rua;
	private String bairro;
	private int cep;
	private int numeroDaResidencia;
	private byte ddi;
	private byte ddd;
	private int telefone;
	


	public Usuario(long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro, int cep,
			int numeroDaResidencia, byte ddi, byte ddd, int telefone) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nomeDeUsuario = nomeDeUsuario;
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
		this.numeroDaResidencia = numeroDaResidencia;
		this.ddi = ddi;
		this.ddd = ddd;
		this.telefone = telefone;
	}

	public Usuario(int id, long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro,
			int cep, int numeroDaResidencia, byte ddi, byte ddd, int telefone) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nomeDeUsuario = nomeDeUsuario;
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
		this.numeroDaResidencia = numeroDaResidencia;
		this.ddi = ddi;
		this.ddd = ddd;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public long getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getNomeDeUsuario() {
		return nomeDeUsuario;
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

	public int getNumeroDaResidencia() {
		return numeroDaResidencia;
	}

}