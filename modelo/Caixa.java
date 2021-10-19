package modelo;

public class Caixa extends Usuario {

	public Caixa(int id, long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro, int cep, int numeroDaResidencia, short ddd, short ddi, int telefone) {
		super(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia);
	}

	public Caixa(long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro, int cep, int numeroDaResidencia) {
		super(cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia);
	}
	
}
