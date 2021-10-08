package modelo;

public class Cliente extends Usuario{

	public Cliente(int id, long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro, int cep, int numeroDaResidencia) {
		super(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia);
	}

	public Cliente(long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro, int cep, int numeroDaResidencia) {
		super(cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia);
	}
	
}


