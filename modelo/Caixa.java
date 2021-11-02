package modelo;

import anotacoes.AnotacaoTabela;

@AnotacaoTabela(getNome="PerfilCaixa")
public class Caixa extends Funcionario {

	public Caixa(int id, long cpf, String nome, String sobrenome, String nomeDeUsuario, String pais,
			String estado, String cidade, String rua, String bairro, int cep, short numeroDaResidencia, byte ddi, byte ddd, int telefone, boolean ativo) {
		super(id, cpf, nome, sobrenome, nomeDeUsuario, pais, estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi, ddd, telefone, ativo);		
	}

	public Caixa(long cpf, String nome, String sobrenome, String nomeDeUsuario, String pais,
			String estado, String cidade, String rua, String bairro, int cep, short numeroDaResidencia, byte ddi, byte ddd, int telefone, boolean ativo) {
		super(cpf, nome, sobrenome, nomeDeUsuario, pais, estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi, ddd, telefone, ativo);
		
	}
	
}
