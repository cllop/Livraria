package modelo;

public class Vendedor extends Funcionario {

	public Vendedor(int id, long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro,
			int cep, int numeroDaResidencia, boolean ativo) {
		super(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, ativo);
		
	}

	public Vendedor(long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro, int cep,
			int numeroDaResidencia) {
		super(cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia);
		
	}

	

}
