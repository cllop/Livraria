package modelo;

import anotacoes.AnotacaoTabela;

@AnotacaoTabela(getNome="PerfilCaixa")
public class Caixa extends Funcionario {
	
	public Caixa(int id, long cpf, String nome, String sobrenome, String nomeDeUsuario, String senha, String pais,
			String estado, String cidade, String rua, String bairro, int cep, short numeroDaResidencia, byte ddi,
			byte ddd, int telefone, boolean ativo) {
		super(id, cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi,
				ddd, telefone, ativo);
	}

	public Caixa(long cpf, String nome, String sobrenome, String nomeDeUsuario, String senha, String pais,
			String estado, String cidade, String rua, String bairro, int cep, short numeroDaResidencia, byte ddi,
			byte ddd, int telefone, boolean ativo) {
		super(cpf, nome, sobrenome, nomeDeUsuario, senha, pais, estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi, ddd,
				telefone, ativo);
	}

	@Override
	public String toString() {
		return "Caixa []" + super.toString();
	}

	
}
