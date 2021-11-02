package modelo;

import java.util.Objects;

public class Usuario {
	private int id;
	private long cpf;
	private String nome;
	private String sobrenome;
	private String nomeDeUsuario;
	private String senha;
	private String pais;
	private String estado;
	private String cidade;
	private String rua;
	private String bairro;
	private int cep;
	private short numeroDaResidencia;
	private byte ddi;
	private byte ddd;
	private int telefone;

	public Usuario(int id, long cpf, String nome, String sobrenome, String nomeDeUsuario, String senha, String pais,
			String estado, String cidade, String rua, String bairro, int cep, short numeroDaResidencia, byte ddi,
			byte ddd, int telefone) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nomeDeUsuario = nomeDeUsuario;
		this.senha = senha;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
		this.numeroDaResidencia = numeroDaResidencia;
		this.ddi = ddi;
		this.ddd = ddd;
		this.telefone = telefone;
	}
	

	public Usuario(long cpf, String nome, String sobrenome, String nomeDeUsuario, String senha, String pais,
			String estado, String cidade, String rua, String bairro, int cep, short numeroDaResidencia, byte ddi,
			byte ddd, int telefone) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nomeDeUsuario = nomeDeUsuario;
		this.senha = senha;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
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



	public void setId(int id) {
		this.id = id;
	}



	public long getCpf() {
		return cpf;
	}



	public void setCpf(long cpf) {
		this.cpf = cpf;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getSobrenome() {
		return sobrenome;
	}



	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}



	public String getNomeDeUsuario() {
		return nomeDeUsuario;
	}



	public void setNomeDeUsuario(String nomeDeUsuario) {
		this.nomeDeUsuario = nomeDeUsuario;
	}



	public String getPais() {
		return pais;
	}



	public void setPais(String pais) {
		this.pais = pais;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getRua() {
		return rua;
	}



	public void setRua(String rua) {
		this.rua = rua;
	}



	public String getBairro() {
		return bairro;
	}



	public void setBairro(String bairro) {
		this.bairro = bairro;
	}



	public int getCep() {
		return cep;
	}



	public void setCep(int cep) {
		this.cep = cep;
	}



	public short getNumeroDaResidencia() {
		return numeroDaResidencia;
	}



	public void setNumeroDaResidencia(short numeroDaResidencia) {
		this.numeroDaResidencia = numeroDaResidencia;
	}



	public byte getDdi() {
		return ddi;
	}



	public void setDdi(byte ddi) {
		this.ddi = ddi;
	}



	public byte getDdd() {
		return ddd;
	}



	public void setDdd(byte ddd) {
		this.ddd = ddd;
	}



	public int getTelefone() {
		return telefone;
	}



	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", sobrenome=" + sobrenome + ", nomeDeUsuario="
				+ nomeDeUsuario + ", senha=" + senha + ", pais=" + pais + ", estado=" + estado + ", cidade=" + cidade
				+ ", rua=" + rua + ", bairro=" + bairro + ", cep=" + cep + ", numeroDaResidencia=" + numeroDaResidencia
				+ ", ddi=" + ddi + ", ddd=" + ddd + ", telefone=" + telefone + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, cpf, ddd, ddi, estado, id, nome, nomeDeUsuario, numeroDaResidencia,
				pais, rua, senha, sobrenome, telefone);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(bairro, other.bairro) && cep == other.cep && Objects.equals(cidade, other.cidade)
				&& cpf == other.cpf && ddd == other.ddd && ddi == other.ddi && Objects.equals(estado, other.estado)
				&& id == other.id && Objects.equals(nome, other.nome)
				&& Objects.equals(nomeDeUsuario, other.nomeDeUsuario) && numeroDaResidencia == other.numeroDaResidencia
				&& Objects.equals(pais, other.pais) && Objects.equals(rua, other.rua)
				&& Objects.equals(senha, other.senha) && Objects.equals(sobrenome, other.sobrenome)
				&& telefone == other.telefone;
	}
}