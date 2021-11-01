package modelo;

import anotacoes.TabelaInexistente;

@TabelaInexistente
public class Funcionario extends Usuario{
	private boolean ativo;

	public Funcionario(int id, long cpf, String nome, String sobrenome, String nomeDeUsuario, String pais,
			String estado, String cidade, String rua, String bairro, int cep, int numeroDaResidencia, byte ddi,
			byte ddd, int telefone, boolean ativo) {
		super(id, cpf, nome, sobrenome, nomeDeUsuario, pais, estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi,
				ddd, telefone);
		this.ativo = ativo;
	}



	
	public Funcionario(long cpf, String nome, String sobrenome, String nomeDeUsuario, String pais,
			String estado, String cidade, String rua, String bairro, int cep, int numeroDaResidencia, byte ddi,
			byte ddd, int telefone, boolean ativo) {
		super(cpf, nome, sobrenome, nomeDeUsuario, pais, estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi,
				ddd, telefone);
		this.ativo = ativo;
	}



	



	public boolean isAtivo() {
		return ativo;
	}
	
}
