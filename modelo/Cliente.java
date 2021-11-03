package modelo;

import java.util.Objects;

import anotacoes.AnotacaoTabela;

@AnotacaoTabela(getNome="PerfilCliente")
public class Cliente extends Usuario{
	private int idCliente;

	public Cliente(int id, int idCliente, long cpf, String nome, String sobrenome, String nomeDeUsuario, String senha, String pais,
			String estado, String cidade, String rua, String bairro, int cep, short numeroDaResidencia, byte ddi,
			byte ddd, int telefone) {
		super(id, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi,
				ddd, telefone);
	this.idCliente = idCliente;
	}

	public Cliente(long cpf, String nome, String sobrenome, String nomeDeUsuario, String senha, String pais,
			String estado, String cidade, String rua, String bairro, int cep, short numeroDaResidencia, byte ddi,
			byte ddd, int telefone) {
		super(cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi, ddd,
				telefone);
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idCliente);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return idCliente == other.idCliente;
	}
	
}