package modelo;

import java.util.Objects;

import anotacoes.TabelaInexistente;

@TabelaInexistente
public class Funcionario extends Usuario{
	private boolean ativo;

	public Funcionario(int id, long cpf, String nome, String sobrenome, String nomeDeUsuario, String senha, String pais,
			String estado, String cidade, String rua, String bairro, int cep, short numeroDaResidencia, byte ddi,
			byte ddd, int telefone, boolean ativo) {
		super(id, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi,
				ddd, telefone);
		this.ativo = ativo;
	}

	public Funcionario(long cpf, String nome, String sobrenome, String nomeDeUsuario, String senha, String pais,
			String estado, String cidade, String rua, String bairro, int cep, short numeroDaResidencia, byte ddi,
			byte ddd, int telefone, boolean ativo) {
		super(cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi, ddd,
				telefone);
		this.ativo = ativo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	@Override
	public String toString() {
		return "Funcionario [ativo=" + ativo + "]" + super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(ativo);
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
		Funcionario other = (Funcionario) obj;
		return ativo == other.ativo;
	}

}
