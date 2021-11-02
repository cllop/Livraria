package modelo;

import anotacoes.AnotacaoTabela;

@AnotacaoTabela(getNome="PerfilGerente")
public class Gerente extends Funcionario {
	private boolean superGerente;

	public Gerente(int id, long cpf, String nome, String sobrenome, String nomeDeUsuario, String pais, String estado,
			String cidade, String rua, String bairro, int cep, short numeroDaResidencia, byte ddi, byte ddd, int telefone,
			boolean ativo, boolean superGerente) {
		super(id, cpf, nome, sobrenome, nomeDeUsuario, pais, estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi,
				ddd, telefone, ativo);
		this.superGerente = superGerente;
	}

	
	public Gerente(long cpf, String nome, String sobrenome, String nomeDeUsuario, String pais, String estado,
			String cidade, String rua, String bairro, int cep, short numeroDaResidencia, byte ddi, byte ddd, int telefone,
			boolean ativo, boolean superGerente) {
		super(cpf, nome, sobrenome, nomeDeUsuario, pais, estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi,
				ddd, telefone, ativo);
		this.superGerente = superGerente;
	}

	public boolean isSuperGerente() {
		return superGerente;
	}
	
}
