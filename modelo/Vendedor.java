package modelo;

import anotacoes.AnotacaoTabela;

@AnotacaoTabela(getNome="PerfilVendedor")
public class Vendedor extends Funcionario {

	public Vendedor(int id, long cpf, String nome, String sobrenome, String nomeDeUsuario, String senha, String pais,
			String estado, String cidade, String rua, String bairro, int cep, short numeroDaResidencia, byte ddi,
			byte ddd, int telefone, boolean ativo) {
		super(id, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi,
				ddd, telefone, ativo);
	}

	public Vendedor(long cpf, String nome, String sobrenome, String nomeDeUsuario, String senha, String pais,
			String estado, String cidade, String rua, String bairro, int cep, short numeroDaResidencia, byte ddi,
			byte ddd, int telefone, boolean ativo) {
		super(cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi, ddd,
				telefone, ativo);
	}
	
	

}
